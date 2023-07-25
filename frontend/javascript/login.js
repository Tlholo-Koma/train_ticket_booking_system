

//temp method for logging in
function showSearchPage() {
    
    window.location.replace("../trainsearch.html");
}


async function loginUser() {

    function showLoader() {
        document.getElementById("loader").style.display = "block";
    }


    function hideLoader() {
        document.getElementById("loader").style.display = "none";
    }

    function login() {
        let user = document.getElementById("username").value;
        let userPassword = document.getElementById("password").value;

        if (user.length == 0 || userPassword.length == 0) {
            document.getElementById("feedback").innerText = "Fields can not be empty!";
            document.getElementById("feedback").style.color = "red";
        } else {
            document.getElementById("feedback").innerText = "";
            showLoader();

            let xhttp = new XMLHttpRequest();


            let data = JSON.stringify({
                "IDNumber": user,
                "Password": userPassword
            })

            fetch("/login", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: data,
            }).then(r => r.json())
                .then(d => {
                    window.location.replace("../trainsearch.html");
                }).catch(e => {
                    document.getElementById('feedback').innerText = 'Login credentionals are incorrect';
                    document.getElementById('feedback').style.color = 'red';
                }).finally(() => {
                    hideLoader();
                })
        }
    }
}