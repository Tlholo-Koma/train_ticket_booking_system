function populateDropDownId(data, id) {
    const input = document.getElementById(id);
  
    data.forEach((station) => {
      const option = document.createElement("option");
      option.value = station.station_name;
      option.textContent = station.station_name;
      input.appendChild(option);
    });
}

async function populateStations() {
    try {
      const response = await apiGet("/station/stations");
      const data = await response.json();
  
      populateDropDownId(data.data, "sourceInput");
      populateDropDownId(data.data, "destinationInput");
    } 
    catch (error) {
      console.error("Error fetching stations:", error);
    }
}

populateStations();


const searchButton = document.getElementById("searchBtn");
searchButton.addEventListener("click", handleSearch);

async function handleSearch (event) {
    event.preventDefault();

    const from = document.getElementById("sourceInput").value;
    const to = document.getElementById("destinationInput").value;
    const date = document.getElementById("travelDate").value;

    console.log(from);
    console.log(to);
    console.log(date);

    if (from !== "" && from == to) {
        console.log("You cannot select source and destination to be the same");
        return;
    }
    else {
        let apiUrl = "/train/getTrainsBasedOnStation";
        if (from !== "" || to !== "" || date != "") {
            apiUrl += "?";

            if (from !== "") {
                apiUrl += "from=" + from;
                if (to !== "" || date !== "") { apiUrl += "&"; }
            }

            if (to !== "") {
                apiUrl += "to=" + to;
                if (date !== "") { apiUrl += "&"; }
            }

            if (date !== "") {
                apiUrl += "date=" + date;
            }
        }

        console.log(apiUrl);
        
        const response = await apiGet(apiUrl);
        const data = await response.json();
        console.log(data);
    }
}


