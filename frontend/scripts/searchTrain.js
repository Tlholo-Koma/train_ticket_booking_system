
document.addEventListener('DOMContentLoaded', async() => {
   
    allaboard_url = "http://localhost:8080";

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
        body: body,
        headers: {
            'Content-type': 'application/json; charset=UTF-8',
            'Authorization': 'Bearer ' + localStorage.getItem('token'),
        }
    });
    }

    const results = apiGet('/')

    console.log(results);

    const toDropdown = document.getElementById('toDropdown');
    const fromDropdown = document.getElementById('fromDropdown');
    const searchBtn = document.getElementById('search-btn');
    const errorLbl = document.getElementById('error-lbl');
    const travelDate = document.getElementById('travel-date');
    const tbody = document.getElementById('trainTable').getElementsByTagName('tbody')[0];
    const data = [
        {
            "trainName": "Express Train",
            "time": "10:00 AM",
            "cost": "$50",
            "peakTime": "No"
          },
          {
            "trainName": "Fast Train",
            "time": "12:30 PM",
            "cost": "$60",
            "peakTime": "Yes"
          }
    ];

    function populateDropdowns() {

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

    function searchTrains(date,to,from){
        if(toDropdown.value ==="disabled selected" || fromDropdown.value==="disabled selected"){
            errorLbl.style.display="block";
            errorLbl.textContent="please select location and destination"
        }
        else if(toDropdown.value === fromDropdown.value){
            errorLbl.style.display="block";
            errorLbl.textContent="location and destination cannot be the same";
        }
        else{
            date = travelDate.value;
            const currentDate = new Date();    
            console.log(currentDate);
            console.log(date);
            
            if(date < currentDate){
                console.log('hello');
                errorLbl.style.display="block";
                errorLbl.textContent="please choose a different date from the future";
            }        
        }

        while(tbody.firstChild){
            tbody.remove(tbody.firstChild)
        }

        for(const train of data){
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
          }
    }
    searchBtn.addEventListener('click', ()=>{
        searchTrains();
    });
});
