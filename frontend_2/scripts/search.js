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

        setActiveStep(1);
        
        const trains = data.data;
        if (trains.length > 0) {
            let searchResults = document.getElementById("searchResults");
            searchResults.style.display = "block";
            searchResults.innerHTML = "";

            trains.forEach((train) => {
                let article = document.createElement("article");
                article.classList.add("train-details");

                // adding train name 
                let train_name = document.createElement("h2");
                train_name.textContent = train.train_name;
                article.appendChild(train_name);

                // adding train details main 
                let train_details = document.createElement("section");
                train_details.classList.add("train-details-main");
                
                // adding source and destination 
                let source_destination = addTrainDetailWithIcon("directions_railway", train.source_station.station_name + " - " + train.destination_station.station_name);
                train_details.appendChild(source_destination);

                // adding travel date 
                let travel_date = addTrainDetailWithIcon("calendar_month", train.travel_date);
                train_details.appendChild(travel_date);

                // adding departure time 
                let departure_time = addTrainDetailWithIcon("schedule", train.departure_time);
                train_details.appendChild(departure_time);

                // add peak time
                if(train.peak_times[0].peak_time != null) {
                    let peak_time = addTrainDetailWithIcon("warning", train.peak_times[0].peak_time.price_increase_percentage);
                    train_details.appendChild(peak_time);
                }

                article.appendChild(train_details);
                
                if (train.train_classes.length > 0) {
                    // adding train class
                    let train_class = document.createElement("section");
                    train_class.classList.add("train-classes");

                    let ul = document.createElement("ul");

                    train.train_classes.forEach((train_class) => {
                        let li = document.createElement("li");
                        
                        // adding class name and price 
                        let class_name_price = document.createElement("span");
                        class_name_price.textContent = train_class.class_type.class_type_name + " (R " + train_class.base_price.toFixed(2) + ")";
                        li.appendChild(class_name_price);

                        // adding a button 
                        let class_btn = document.createElement("button");
                        class_btn.setAttribute("class", "button");
                        class_btn.type = "button";
                        class_btn.textContent = "Select";
                        class_btn.addEventListener("click", (event) => {
                            setActiveStep(2);
                            createBookingForm(train.train_id, train.train_name, train_class.class_type.class_type_name);
                        });
                        li.appendChild(class_btn);

                        ul.appendChild(li);
                    });

                    train_class.appendChild(ul);
                    train_details.appendChild(train_class);
                }

                searchResults.appendChild(article);
            });
        }
    }
}

function createMaterialIcon(icon_name) {
    let i = document.createElement("i");
    i.classList.add("material-icons");
    i.textContent = icon_name;
    return i;
}

function addTrainDetailWithIcon(icon_name, text) {
    let p = document.createElement("p");
    let icon = createMaterialIcon(icon_name);

    if (icon_name == "warning"){
        p.classList.add("tooltip");
    }

    let text_label;
    if (icon_name == "warning"){
        text_label = document.createTextNode("Travelling during peak times");
    }
    else {
        text_label = document.createTextNode(text);
    }

    p.appendChild(icon);
    p.appendChild(text_label);

    // create tooltip text 
    if (icon_name == "warning") {
        let span = document.createElement("span");
        span.classList.add("tooltip-text");
        span.textContent = (text * 100).toFixed(0) + "%" + " increase in price";
        p.appendChild(span);
    }

    return p;
}

function createBookingForm(train_id, train_name, class_id) {
    console.log("Booking for " + train_name + " " + train_id + " with class " + class_id);

    let createBooking = document.getElementById("createBooking");
    createBooking.style.display = "block";

    let selectedTrainId = document.getElementById("selectedTrainId");
    selectedTrainId.value = train_id;

    let selectedTrainName = document.getElementById("selectedTrainName");
    selectedTrainName.value = train_name;

    let selectedTrainClass = document.getElementById("selectedTrainClass");
    selectedTrainClass.value = class_id;
}

const addPassengerButton = document.querySelector('#addPassengerButton');
addPassengerButton.addEventListener('click', () => {
    const passengerContainer = document.querySelector('#passengerDetailsContainer');

    const passengerTemplate = document.getElementById("passengerDetailsTemplate").innerHTML;
    const passengerClone = document.createElement("div");
    passengerClone.innerHTML = passengerTemplate;
    
    
    const removeButton = passengerClone.querySelector('.removePassengerButton');
    removeButton.addEventListener('click', (event) => {
        const passengerElement = event.target.closest('.passengerDetails');
        
        passengerElement.remove();
        
        passengers = Array.from(document.querySelectorAll('.passengerDetails')).map((passengerElement) => {
          const passengerName = passengerElement.querySelector('.passengerName').value;
          const passengerAge = passengerElement.querySelector('.passengerAge').value;
          
          return {
            passengerName,
            passengerAge,
          };
        });
        
        const submitButton = document.querySelector('#bookTrain');
        submitButton.disabled = passengers.length <= 0;
    });

    passengerContainer.appendChild(passengerClone);
});

// Add event listener to the form submit button
const submitButton = document.getElementById("bookTrain");
submitButton.addEventListener("click", handleBookTrain);

async function handleBookTrain(event) {
    console.log("submit button pressed")
    event.preventDefault();
  
    // Get the passenger details from the form
    const passengerDetails = Array.from(document.querySelectorAll('.passengerDetails')).map((passengerElement) => {
        const passengerName = passengerElement.querySelector('.passengerName').value;
        const passengerAge = passengerElement.querySelector('.passengerAge').value;
        
        if (passengerName == "" || passengerAge == "") {
            return null;
        }
        else if (parseInt(passengerAge) < 1) {
            return null;
        }
  
        return {
            passenger_name: passengerName,
            passenger_age: passengerAge,
        };
    });

    const containsNull = passengerDetails.some((passenger) => passenger === null);
    if (containsNull) {
        console.log("Please fill in both passenger name and age, and ensure it is a valid age.");
        return;
    }

    const selectedTrainId = document.getElementById("selectedTrainId").value;
    const selectedTrainClass = document.getElementById("selectedTrainClass").value;

    console.log(passengerDetails);
    
    const requestBody = {
      passengers: passengerDetails,
      train_id: selectedTrainId,
      train_class: selectedTrainClass,
      user_email: "null"// localStorage.getItem("email")
    }
  
    console.log(requestBody);

    try {
        const response = await apiPost('/booking/booking', requestBody);
        const data = await response.json();

        console.log(data);

        if (data.status == 200) {
            console.log("Booking placed successfully");
            setActiveStep(3)
        }
        else {
            throw new Error(data.message);
        }

    }
    catch (error) {
        console.log("error placing booking");
        console.log(error.message);
    }
}

function confirmBooking() {

}
