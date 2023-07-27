
document.addEventListener('DOMContentLoaded', () => {
    const data = [
        {
            "station_id": 1,
            "station_name": "Hatfield"
        },
        {
            "station_id": 2,
            "station_name": "Pretoria"
        },
        {
            "station_id": 3,
            "station_name": "Centurion"
        },
        {
            "station_id": 4,
            "station_name": "Midrand"
        },
        {
            "station_id": 5,
            "station_name": "Marlboro"
        },
        {
            "station_id": 6,
            "station_name": "Sandton"
        },
        {
            "station_id": 7,
            "station_name": "Rosebank"
        },
        {
            "station_id": 8,
            "station_name": "Park"
        },
        {
            "station_id": 9,
            "station_name": "Rhodesfield"
        },
        {
            "station_id": 10,
            "station_name": "O.R. Tambo"
        }
    ]

    const toDropdown = document.getElementById('toDropdown');
    const fromDropdown = document.getElementById('fromDropdown');
    const searchBtn = document.getElementById('search-btn');
    const errorLbl = document.getElementById('error-lbl');
    const travelDate = document.getElementById('travel-date');
    const tbody = document.getElementById('tbody');

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
    }
    searchBtn.addEventListener('click', ()=>{
        searchTrains();
    });
});
