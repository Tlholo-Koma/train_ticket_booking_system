
allaboard_url = "https://allaboard.bbdgrad.com";

async function apiGet(endpoint) {
  return await fetch(allaboard_url + endpoint, {
    method: "GET",
    headers: {
      'Content-type': 'application/json; charset=UTF-8',
      'Authorization': 'Bearer ' + localStorage.getItem('token'),
    }
  });
}

async function apiPost(endpoint, body) {
  return await fetch(allaboard_url + endpoint, {
    method: "POST",
    body: body,
    headers: {
      'Content-type': 'application/json; charset=UTF-8',
      'Authorization': 'Bearer ' + localStorage.getItem('token'),
    }
  });
}

const slidePage = document.querySelector(".slide-page");
const nextBtnFirst = document.querySelector(".firstNext");
const prevBtnSec = document.querySelector(".prev-1");
const nextBtnSec = document.querySelector(".next-1");
const prevBtnThird = document.querySelector(".prev-2");
const nextBtnThird = document.querySelector(".next-2");
const prevBtnFourth = document.querySelector(".prev-3");
const submitBtn = document.querySelector(".submit");
const progressText = document.querySelectorAll(".step p");
const progressCheck = document.querySelectorAll(".step .check");
const bullet = document.querySelectorAll(".step .bullet");
const errorLbl = document.getElementById('book-error-lbl')
const fullname = document.getElementById('name');
const age = document.getElementById('age');
const seatType = document.getElementById('seat-type-dropdown');
const trainClass = document.getElementById('train-class-dropdown');

let current = 1;

nextBtnFirst.addEventListener("click", function (event) {
  event.preventDefault();
  slidePage.style.marginLeft = "-25%";
  bullet[current - 1].classList.add("active");
  progressCheck[current - 1].classList.add("active");
  progressText[current - 1].classList.add("active");
  current += 1;
});
nextBtnSec.addEventListener("click", async function (event) {

  event.preventDefault();
  slidePage.style.marginLeft = "-50%";
  bullet[current - 1].classList.add("active");
  progressCheck[current - 1].classList.add("active");
  progressText[current - 1].classList.add("active");
  current += 1;
});
nextBtnThird.addEventListener("click", function (event) {
  event.preventDefault();

  if (age.value === "" || fullname.value === "") {
    errorLbl.style.display = "block";
    errorLbl.textContent = "please fill in your fullname and age";
    localStorage.setItem('fullname', fullname.value);
    console.log(localStorage.getItem(fullname))
  }
  else if (seatType.value === "disabled selected" || trainClass.value === "disabled selected") {
    errorLbl.style.display = "block";
    errorLbl.textContent = "please select seat type and train class"
  } else {
    let data = JSON.stringify({
      "user_email": localStorage.getItem('mail'),
      "train_class": 'Economy',
      "train_id": localStorage.getItem("train_id"),
      "passengers": [{
        "age": age.value,
        "passenger_name": fullname.value
      }]
    });

    localStorage.setItem('fullname', fullname.value);
    localStorage.setItem('age', age.value);
    localStorage.setItem('seatType', seatType.value);
    localStorage.setItem('trainClass', trainClass.value);

    console.log(localStorage.getItem(fullname))

     apiPost('/booking/booking', data)

    slidePage.style.marginLeft = "-75%";
    bullet[current - 1].classList.add("active");
    progressCheck[current - 1].classList.add("active");
    progressText[current - 1].classList.add("active");
    current += 1;
  }


});
submitBtn.addEventListener("click", function () {
  bullet[current - 1].classList.add("active");
  progressCheck[current - 1].classList.add("active");
  progressText[current - 1].classList.add("active");
  current += 1;
  setTimeout(function () {
    alert("You have booked successfully");
    localStorage.clear();
    location.reload();
  }, 800);
});

prevBtnSec.addEventListener("click", function (event) {
  event.preventDefault();
  slidePage.style.marginLeft = "0%";
  bullet[current - 2].classList.remove("active");
  progressCheck[current - 2].classList.remove("active");
  progressText[current - 2].classList.remove("active");
  current -= 1;
});
prevBtnThird.addEventListener("click", function (event) {
  event.preventDefault();
  slidePage.style.marginLeft = "-25%";
  bullet[current - 2].classList.remove("active");
  progressCheck[current - 2].classList.remove("active");
  progressText[current - 2].classList.remove("active");
  current -= 1;
});
prevBtnFourth.addEventListener("click", function (event) {
  event.preventDefault();
  slidePage.style.marginLeft = "-50%";
  bullet[current - 2].classList.remove("active");
  progressCheck[current - 2].classList.remove("active");
  progressText[current - 2].classList.remove("active");
  current -= 1;
});

