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
