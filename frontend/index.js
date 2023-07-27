const config = {
    auth: {
        clientId: 'b5a0f0e5-e9be-4880-9eaa-f9eb9397b818',
        authority: 'https://login.microsoftonline.com/consumers/',
        redirectUri: 'https://d1xb965e89guo1.cloudfront.net',
        postLogoutRedirectUri: 'https://d1xb965e89guo1.cloudfront.net'
    }
};

var client = new Msal.UserAgentApplication(config);

var request = {
    scopes: [ 'user.read' ]
};

async function signIn() {
    let loginResponse = await client.loginPopup(request);
    localStorage.setItem('mail', loginResponse.idToken.preferredName);
    localStorage.setItem('token', loginResponse.idToken.rawIdToken);
    
}

async function signOut(){
    client.logout();
}