
document.addEventListener('DOMContentLoaded', async () => {

    allaboard_url = "https://allaboard.bbdgrad.com";

    async function apiGet(endpoint) {
        return await fetch(allaboard_url + endpoint, {
            method: "GET",
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
                'Authorization': 'Bearer ' + localStorage.getItem('token')
            }
        });
    }

    async function apiPost(endpoint, body) {
        return await fetch(allaboard_url + endpoint, {
            method: "POST",
            body: body,
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
                'Authorization': 'Bearer ' + localStorage.getItem('token')
            }
        });
    }



    const toDropdown = document.getElementById('toDropdown');
    const fromDropdown = document.getElementById('fromDropdown');
    const searchBtn = document.getElementById('search-btn');
    const errorLbl = document.getElementById('error-lbl');
    const travelDate = document.getElementById('travel-date');
    const tbody = document.getElementById('trainTable').getElementsByTagName('tbody')[0];

    async function populateDropdowns() {
        const trainStation = await (await apiGet('/station/stations')).json();
        const data = trainStation.data;

        data.forEach(station => {

            const option = document.createElement('option');
            option.value = station.station_name;
            option.textContent = station.station_name;
            fromDropdown.appendChild(option);
        })

        data.forEach(station => {
            const option = document.createElement('option');
            option.value = station.station_name;
            option.textContent = station.station_name;
            toDropdown.appendChild(option);
        })

    }
    populateDropdowns();


    async function searchTrains() {
        const to = toDropdown.value;
        const currentDate = new Date();
        const from = fromDropdown.value;
        const date = travelDate.value; //new Date(travelDate.value);

        console.log(from)
        console.log(to)
        console.log(date)
        // const jsonResponse = [
        //     {
        //       "train_name": "Express",
        //       "time": "10:00 AM",
        //       "cost": "$25",
        //       "peak_time": "No"
        //     },
        //     {
        //       "train_name": "Super Express",
        //       "time": "2:30 PM",
        //       "cost": "$35",
        //       "peak_time": "Yes"
        //     }
            
        //   ];
        //const trainResults = apiGet('/train/getTrainsBasedOnStation?from=' + from + '&to=' + to + '&date=' + date);
        //console.log(trainResults);
        //const jsonResponse = trainResults;
        //console.log(jsonResponse);

        // let results = await (await apiGet('/train/getTrainsBasedOnStation?from=' + from + '&to=' + to)).json();
        // let jsonResponse = results.data;
        // console.log(jsonResponse);

        // jsonResponse.forEach(train => {
        //     console.log(train);
        //     const row = document.createElement('tr');

        //     const trainNameCell = document.createElement('td');
        //     trainNameCell.textContent = train.trainName;
        //     row.appendChild(trainNameCell);

        //     const timeCell = document.createElement('td');
        //     timeCell.textContent = train.time;
        //     row.appendChild(timeCell);

        //     const costCell = document.createElement('td');
        //     costCell.textContent = train.cost;
        //     row.appendChild(costCell);

        //     const peakTimeCell = document.createElement('td');
        //     peakTimeCell.textContent = train.peakTime;
        //     row.appendChild(peakTimeCell);

        //     tbody.appendChild(row);
        // });

        //   for(let i = 0; i < jsonResponse.length; i++){
        //     tbody.innerHTML += `<tr>
        //                           <td>`+ jsonResponse[i].train_name +`</td>
        //                           <td>` + jsonResponse[i].time+ `</td>
        //                           <td>` + jsonResponse[i].cost + `</td>
        //                           <td>` +jsonResponse[i].peak_time + `</td>
        //                         </tr>`;
        //   }
        if (toDropdown.value === "disabled selected" || fromDropdown.value === "disabled selected") {
            errorLbl.style.display = "block";
            errorLbl.textContent = "please select location and destination";
        } else if (toDropdown.value === fromDropdown.value) {
            errorLbl.style.display = "block";
            errorLbl.textContent = "location and destination cannot be the same";
        } else if (date < currentDate) {
            errorLbl.style.display = "block";
            errorLbl.textContent = "Please choose a different date from the future";
        } else {

            errorLbl.style.display = "none";

            searchForm = document.getElementById("searchForm");
            console.log(searchForm);
            //searchForm.style.display = "none";
            

            
            //apiGet('/train/getTrainsBasedOnStation?from=' + from + '&to=' + to + '&date=' + date)
            apiGet('/train/getTrainsBasedOnStation?from=' + from + '&to=' + to)
                .then(response => response.json())
                .then(data => {

                    tbody.innerText = "";

                    data = data.data;
                    console.log(data);


                    data.forEach(train => {
                        console.log(train);
                        const row = document.createElement('tr');

                        const trainNameCell = document.createElement('td');
                        trainNameCell.textContent = train.train_name;
                        row.appendChild(trainNameCell);

                        const timeCell = document.createElement('td');
                        timeCell.textContent = train.departure_time;
                        row.appendChild(timeCell);

                        // <button class="next-1 next">Next</button>
                        const selectTrainBtn = document.createElement("button");
                        selectTrainBtn.innerText = "Select";
                        selectTrainBtn.addEventListener('click', (event)=>{
                            localStorage.setItem("train_id", train.train_id);
                            event.preventDefault();
                            slidePage.style.marginLeft = "-50%";
                            bullet[current - 1].classList.add("active");
                            progressCheck[current - 1].classList.add("active");
                            progressText[current - 1].classList.add("active");
                            current += 1;
                        })
                        row.appendChild(selectTrainBtn);

                        // const costCell = document.createElement('td');
                        // costCell.textContent = train.cost;
                        // row.appendChild(costCell);

                        // const peakTimeCell = document.createElement('td');
                        // peakTimeCell.textContent = train.peakTime;
                        // row.appendChild(peakTimeCell);

                        tbody.appendChild(row);
                    });

                    localStorage.setItem('toDropdownValue', toDropdown.value);
                    localStorage.setItem('fromDropdownValue', fromDropdown.value);
                    localStorage.setItem('travelDateValue', travelDate.value);
                })
                .catch(error => {
                    console.error("Error fetching train data:", error);
                });
                
        
        }
    }

    searchBtn.addEventListener('click', (event) => {
        event.preventDefault();
        searchTrains();
    });

});
