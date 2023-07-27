
document.addEventListener('DOMContentLoaded', () => {
    
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
    
    
    const fullname = document.getElementById('name');
    const age = document.getElementById('age');
    const seatType = document.getElementById('seat-type-dropdown');
    const trainClass = document.getElementById('train-class-dropdown');
    const nextBtn = document.getElementById('book-btn');
    const errorLbl = document.getElementById('error-lbl')


    async function populateDropdowns(){
        const seatTypeD = await (await apiGet('/seatType/seatTypes')).json();
        const seatTypeData = seatTypeD.data;
        seatTypeData.forEach(seat => {
            const option = document.createElement('option');
            option.value = seat.seat_type_id;
            option.textContent = seat.seat_type_name;
            seatType.appendChild(option);
        });
        
        const trainClassD = await (await apiGet('/trainClass/trainClasses')).json();
        const trainClassData = trainClassD.data;

        trainClassData.forEach(classType =>{
            const option = document.createElement('option');
            option.value = classType.class_type_id;
            option.textContent = classType.class_type_name;
            trainClass.appendChild(option);
        })
    }
    populateDropdowns();

});




