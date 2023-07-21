async function signIn() {
    const config = {
        auth: {
            clientId: 'b5a0f0e5-e9be-4880-9eaa-f9eb9397b818',
            authority: 'https://login.microsoftonline.com/consumers/',
            redirectUri: 'http://localhost:8080'
        }
    };

    var client = new Msal.UserAgentApplication(config);

    var request = {
        scopes: [ 'user.read' ]
    };
    let loginResponse = await client.loginPopup(request);
    console.log('Login Response', loginResponse);

    let tokenResponse = await client.acquireTokenSilent(request); //This gets the token
    console.log('Token', tokenResponse);
}