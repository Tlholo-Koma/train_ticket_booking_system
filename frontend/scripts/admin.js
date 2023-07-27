
async function fetchStations() {
  let mainTag = document.getElementsByTagName('main');
  let results = await (await apiGet('/station/stations')).json();
  
  let stations = results.data;
  console.log(stations);
  let tab = document.createElement('nav');
  
  tab.className = 'tab';
  for (let i = 0; i < stations.length; i++ ) {
    let navButton = document.createElement('button');
    navButton.id = stations[i].station_name;
    navButton.textContent = stations[i].station_name;
    // navButton.onclick = openStation();
    navButton.className = 'tablinks';
    tab.appendChild(navButton);
  }
  console.log(mainTag[0]);
  mainTag[0].appendChild(tab);
}

fetchStations();

function openStation(evt, cityName) {
    // Declare all variables
    var i, tabcontent, tablinks;
  
    // Get all elements with class="tabcontent" and hide them
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
      tabcontent[i].style.display = "none";
    }
  
    // Get all elements with class="tablinks" and remove the class "active"
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
      tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
  
    // Show the current tab, and add an "active" class to the button that opened the tab
    document.getElementById(cityName).style.display = "flex";
    evt.currentTarget.className += " active";
  }

  function edit() {
    console.log('Editing');
    document.getElementById('submit-button').style.visibility = 'visible';
    document.getElementById('cancel-button').style.visibility = 'visible';
    document.getElementById('edit-button').style.visibility = 'hidden';
}

function exitEdit() {
    document.getElementById('submit-button').style.visibility = 'hidden';
    document.getElementById('cancel-button').style.visibility = 'hidden';
    document.getElementById('edit-button').style.visibility = 'visible';
}