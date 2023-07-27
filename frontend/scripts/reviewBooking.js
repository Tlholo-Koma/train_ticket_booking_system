document.addEventListener('DOMContentLoaded',()=>{
const fullname = document.getElementById('review-fullname');
const age = document.getElementById('review-age');
const seatType = document.getElementById('review-seat-type');
const trainClass = document.getElementById('review-train-class');
const location = document.getElementById('review-location');
const destination = document.getElementById('review-destination');
const travelDate = document.getElementById('review-travel-date');

const toDropdown = document.getElementById('toDropdown');
const fromDropdown = document.getElementById('fromDropdown');
const seatTypev = document.getElementById('seat-type-dropdown');
const trainClassv = document.getElementById('train-class-dropdown');
const fullnamev = document.getElementById('name');
const agev = document.getElementById('age');
const travelDatev = document.getElementById('travel-date');

fullname.value = fullnamev.value;
age.value = agev.value;
seatType.value = seatTypev.value;
trainClass.value = trainClassv.value;
location.value = fromDropdown.value;
destination.value = toDropdown.value;
travelDate.value = travelDatev.value;

});
