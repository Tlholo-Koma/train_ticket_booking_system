const allaboard_url = 'http://localhost:5000';

async function apiGet(endpoint) {
    return await fetch(allaboard_url + endpoint, {
        method: "GET",
        headers: {
            'Content-type': 'application/json; charset=UTF-8',
            'Authorization': 'Bearer ' + localStorage.getItem('token'),
        }
    })
    .catch(error => {
        console.log("error");
        console.log(error)
        return new Error(error.message);
    })
    ;
}

async function apiPost(endpoint, body) {
    return await fetch(allaboard_url + endpoint, {
        method: "POST",
        body: JSON.stringify(body),
        headers: {
            'Content-type': 'application/json; charset=UTF-8',
            'Authorization': 'Bearer ' + localStorage.getItem('token'),
        }
    })
    .catch(error => {
        console.log("error");
        console.log(error);
        return new Error(error.message);
    });
}

function setActiveStep0(index) {
    const steps = document.querySelectorAll('.step');
    const stepContents = document.querySelectorAll('.step-content-item');

    steps.forEach((step, i) => {
      if (i === index) {
        step.classList.add('active');
      } else {
        step.classList.remove('active');
      }
    });

    stepContents.forEach((content, i) => {
      if (i === index) {
        content.style.display = 'block';
      } else {
        content.style.display = 'none';
      }
    });
}


function setActiveStep(stepIndex) {
    const steps = document.querySelectorAll('.step');
    const stepContents = document.querySelectorAll('.step-content-item');
    
    for (let i = 0; i < steps.length; i++) {
        if (i === stepIndex) {  // current step 
            steps[i].classList.add('active');

            const stepCircle = steps[i].querySelector('.step-circle');
            stepCircle.classList.remove('greyed');
            stepCircle.classList.remove('step-tick');
            stepCircle.textContent = i + 1;
            stepCircle.removeAttribute("disabled");
        } 
        else if (i < stepIndex) {  // previous steps 
            steps[i].classList.add('active');
            
            // Replace number with tick
            const stepCircle = steps[i].querySelector('.step-circle');

            stepCircle.classList.remove('greyed');
            stepCircle.classList.remove('step-tick');
            stepCircle.textContent = i + 1;

            stepCircle.classList.add('step-tick');
            stepCircle.textContent = "\u2713";
            stepCircle.removeAttribute("disabled");
        } 
        else {  // next steps 
            // Set the steps after the current step as greyed out
            steps[i].classList.remove('active');

            const stepCircle = steps[i].querySelector('.step-circle');
            stepCircle.classList.remove('step-tick');
            stepCircle.textContent = i + 1;
            stepCircle.classList.add('greyed');
            stepCircle.setAttribute('disabled', 'disabled');
        }
    }

    stepContents.forEach((content, i) => {
        if (i === stepIndex) {
          content.style.display = 'block';
        } else {
          content.style.display = 'none';
        }
    });
}

setActiveStep(0);
  

