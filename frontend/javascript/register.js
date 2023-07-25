function showLoader() {
    document.getElementById("loader").style.display = "block";
}

function hideLoader() {
    document.getElementById("loader").style.display = "none";
}


function register() {
    let full_name = document.getElementById("name").value;
    let email = document.getElementById("email").value;
    let address = document.getElementById("address").value;
    let password = document.getElementById("password").value;
    let contact_no = document.getElementById("contact").value;
    let passwordConfirm = document.getElementById("passwordConfirm").value;

    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    const isValidEmail = emailRegex.test(email);

    if (full_name.length < 3) {
        document.getElementById("feedback").innerText = "Name should be at least 3 characters!";
    } 
    else if (contact_no.length !==10) {
        document.getElementById("feedback").innerText = "Contact number should be exactly 10 digits";
    } 
     else if (!isValidEmail) {
        document.getElementById("feedback").innerText = "Invalid Email!";
    } else if (address.length <=5) {
        document.getElementById("feedback").innerText = "Address should be at least 5 characters";
    } else if (password.length < 8) {
        document.getElementById("feedback").innerText = "Password should be greater than 8 characters!";
    } else if (password !== passwordConfirm) {
        document.getElementById("feedback").innerText = "Passwords don't match!";
    } else {
        showLoader();

        console.log("password: " + password);

        const data = JSON.stringify({
            "full_name": full_name,
            "email": email,
            "password": password,
            "contact_no": contact_no,
            "address" : address
        });

        fetch("http://localhost:8080/users", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: data,
        })
            .then((response) => {
                if (response.ok) {
                    hideLoader();
                    alert('You have successfully registered');
                    window.location.replace("../login.html");
                } else if (response.status === 409) {

                    return response.json();
                } else {
                    throw new Error("Network response was not ok");
                }
            })
            .then((data) => {
                if (data && data.message === "User already exists") {
                    document.getElementById('feedback').innerText = 'User already exists';
                    document.getElementById('feedback').style.color = 'red';
                }
            })
            .catch((error) => {
                console.error('Error:', error);
            });
    }
}
