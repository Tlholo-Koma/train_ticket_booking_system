
document.addEventListener('DOMContentLoaded', () => {
    const trainClassData = [
        {
            "class_type_id": 1,
            "class_type_name": "Economy"
        },
        {
            "class_type_id": 2,
            "class_type_name": "Business"
        },
        {
            "class_type_id": 3,
            "class_type_name": "Sleeper"
        }
    ];

    const seatTypeData = [
        {
            "seat_type_id": 1,
            "seat_type_name": "Window Seat"
        },
        {
            "seat_type_id": 2,
            "seat_type_name": "Aisle Seat"
        },
        {
            "seat_type_id": 3,
            "seat_type_name": "Middle Seat"
        }
    ];

    const fullname = document.getElementById('name');
    const age = document.getElementById('age');
    const seatType = document.getElementById('seat-type-dropdown');
    const trainClass = document.getElementById('train-class-dropdown');
    const nextBtn = document.getElementById('book-btn');
    const errorLbl = document.getElementById('error-lbl')


    function populateDropdowns(){
        seatTypeData.forEach(seat => {
            const option = document.createElement('option');
            option.value = seat.seat_type_id;
            option.textContent = seat.seat_type_name;
            seatType.appendChild(option);
        });

        trainClassData.forEach(classType =>{
            const option = document.createElement('option');
            option.value = classType.class_type_id;
            option.textContent = classType.class_type_name;
            trainClass.appendChild(option);
        })
    }
    populateDropdowns();

});




