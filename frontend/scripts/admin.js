let mainTag = (document.getElementsByTagName('main'));

async function fetchStations() {
  
  let results = await (await apiGet('/station/stations')).json();
  
  let stations = results.data;
  let tab = document.createElement('nav');
  const input = document.getElementsByClassName("destStation");
  stations.forEach((station) => {

    const option = document.createElement("option");

    option.value = station.station_name;

    option.textContent = station.station_name;

    input[0].appendChild(option);

  });

  tab.className = 'tab';
  for (let i = 0; i < stations.length; i++ ) {
    let stationName = stations[i].station_name;
    let navButton = document.createElement('button');
    navButton.id = stationName;
    navButton.textContent = stationName;
    navButton.addEventListener('click', function(e) {
      openStation(stationName);
    });
    // navButton.onclick = openStation(stationName);
    navButton.className = 'tablinks';
    tab.appendChild(navButton);
  }
  mainTag[0].appendChild(tab);
}

fetchStations();

async function openStation(stationName) {
  let results = await (await apiGet('/train/getTrainsBasedOnStation?from='+stationName)).json();
  let trains = results.data;

  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  let stationSection = document.createElement('section');
  stationSection.className = 'tabcontent';
  stationSection.id = stationName


  let container = document.createElement('section');
  container.className = 'train-container';

  let addButton = document.createElement('button');
  addButton.id = 'add-train';

  function openModal() {
    let modal = document.getElementById("myModal");
    modal.style.display = "block";
}

addButton.addEventListener("click", openModal);
  addButton.textContent = 'Add train'; 
  stationSection.appendChild(addButton);

  let selectElement = document.createElement('select');
  selectElement.className = 'train-list';
  selectElement.multiple = 'multiple';

  for (let i = 0; i < trains.length; i++) {
    let optionElement = document.createElement('option');
    optionElement.textContent = trains[i].train_name;
    optionElement.addEventListener('click', function() {
      populateTrainInfo(container, trains[i]);
    })
    selectElement.appendChild(optionElement);
  }
  container.appendChild(selectElement);
  stationSection.appendChild(container);
  mainTag[0].appendChild(stationSection);
    
}

formElements = {
  'Train Name': 'label',
  'train_name': 'input',
  'Destination station': 'label',
  'destination_station': 'input',
  'Departure time': 'label',
  'departure_time': 'input'
}

function populateTrainInfo(tabContent, trainObject) {
  tabcontent = document.getElementsByClassName("train-info");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  let trainInfo = document.createElement('article');
  trainInfo.className = 'train-info';

  for (const key in formElements) {
    let value = formElements[key];
    let element = document.createElement(value);
    if (key === 'destination_station') {
      element.id = key;
      element.value = trainObject[key]['station_name'];
    }else if (value === 'label') 
      element.textContent = key;
    else{
      element.id = key;
      element.value = trainObject[key];
    }
    trainInfo.appendChild(element);
  }
  tabContent.appendChild(trainInfo);
  
}
// Function to close the modal
function closeModal() {
  let modal = document.getElementById("myModal");
    modal.style.display = "none";
}

async function postTrain() {
  let trainName = document.getElementsByClassName("trainName");
  let destName = document.getElementsByClassName("destStation");
  let departTime = document.getElementsByClassName("departTime");
  let sourceName = document.getElementsByClassName("tabcontent");
  body = {
    train_name: trainName[0].value,
    "source_station": {
      "station_name": sourceName[0].id
    },
    "destination_station": {
      "station_name": destName[0].value
    },
    departure_time: departTime[0].value,
    "train_classes": [
      {
        "base_price": 100.30,
        "capacity": 2,
        "class_type": {
          "class_type_name": "Economy"
        }
      },
      {
        "base_price": 200.30,
        "capacity": 2,
        "class_type": {
          "class_type_name": "Business"
        }
      },
      {
        "base_price": 300.30,
        "capacity": 2,
        "class_type": {
          "class_type_name": "Sleeper"
        }
      }
    ],
    "travel_date": "2023-07-25"
  } 

  let results = await (await apiPost('/train/train', body)).json();

}

// Function to open the modal
