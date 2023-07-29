// Check if the email is present in localStorage
const email = localStorage.getItem('email');

// Get references to the button and h2 elements
const loginButton = document.getElementById('loginButton');
const emailElement = document.getElementById('loggedinEmail');

if (email) {
    // If the email exists, hide the button and show the h2
    loginButton.style.display = 'none';
    emailElement.style.display = 'block';
} else {
    // If the email does not exist, show the button and hide the h2
    loginButton.style.display = 'block';
    emailElement.style.display = 'none';
}
