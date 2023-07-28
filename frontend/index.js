const config = {
    auth: {
        clientId: 'b5a0f0e5-e9be-4880-9eaa-f9eb9397b818',
        authority: 'https://login.microsoftonline.com/consumers/',
        redirectUri: 'https://pzsmddzkdt.eu-west-1.awsapprunner.com/index.html', 
        postLogoutRedirectUri: 'https://pzsmddzkdt.eu-west-1.awsapprunner.com/login.html' 
    },
    cache: {
        cacheLocation: 'localStorage',
      }
};

const client = new Msal.UserAgentApplication(config);

const request = {
    scopes: [ 'user.read' ]
};
async function signIn() {
    
    let loginResponse = await client.loginPopup(request);
    if(loginResponse){
        localStorage.setItem('mail', loginResponse.idToken.preferredName);
        localStorage.setItem('token', loginResponse.idToken.rawIdToken);
        location.href = "https://pzsmddzkdt.eu-west-1.awsapprunner.com/index";
    }
    
}

async function signOut(){
    client.logout();
}

function checkToken(){
    let token = localStorage.getItem('token');
    if (!token){
        location.href = "https://pzsmddzkdt.eu-west-1.awsapprunner.com/login";
    }
}