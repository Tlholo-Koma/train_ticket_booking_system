
document.addEventListener('DOMContentLoaded', async() => {
   
    allaboard_url = "https://allaboard.bbdgrad.com";

    async function apiGet(endpoint) {
        return await fetch(allaboard_url+ endpoint, {
        method: "GET",
        headers: {
            'Content-type': 'application/json; charset=UTF-8',
            'Authorization': 'Bearer ' + localStorage.getItem('token')
        }
    });
    }
    
    async function apiPost(endpoint, body) {
        return await fetch(allaboard_url+ endpoint, {
        method: "POST",
        body: JSON.stringify(body),
        headers: {
            'Content-type': 'application/json; charset=UTF-8',
            'Authorization': 'Bearer ' + localStorage.getItem('token'),
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
            option.value = station.station_id;
            option.textContent = station.station_name;
            fromDropdown.appendChild(option);
        })

        data.forEach(station => {
            const option = document.createElement('option');
            option.value = station.station_id;
            option.textContent = station.station_name;
            toDropdown.appendChild(option);
        })

    }
    populateDropdowns();

    const isValidSearch= ()=>{}

    function searchTrains() {
        const to = toDropdown.value;
        const currentDate = new Date();
        const from = fromDropdown.value;
        const date = new Date(travelDate.value);
      
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
          // Reset the error label if there are no errors
          errorLbl.style.display = "none";
      
          // Call the API to fetch data
          apiGet('/endpoint-for-trains') // Replace '/endpoint-for-trains' with the correct API endpoint
            .then(response => response.json())
            .then(data => {
              // Clear the existing rows from the table
              tbody.innerHTML = "";
      
              // Process and add new rows to the table
              data.forEach(train => {
                const row = document.createElement('tr');
      
                const trainNameCell = document.createElement('td');
                trainNameCell.textContent = train.trainName;
                row.appendChild(trainNameCell);
      
                const timeCell = document.createElement('td');
                timeCell.textContent = train.time;
                row.appendChild(timeCell);
      
                const costCell = document.createElement('td');
                costCell.textContent = train.cost;
                row.appendChild(costCell);
      
                const peakTimeCell = document.createElement('td');
                peakTimeCell.textContent = train.peakTime;
                row.appendChild(peakTimeCell);
      
                tbody.appendChild(row);
              });
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
