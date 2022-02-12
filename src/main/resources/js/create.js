function createUser(){
    const CREATE_USER_URL="https://asi2-backend-market.herokuapp.com/user";
    let context = {
        method: 'POST',
        headers:{
            Accept: 'application/json'
        },
        body: JSON.stringify({
            'login': document.getElementsByName("login")[0].value,
            'pwd': document.getElementsByName("pwd")[0].value,
            'account': document.getElementsByName("account")[0].value,
            'surName': document.getElementsByName("surName")[0].value,
            'lastName': document.getElementsByName("lastName")[0].value
        }),    
    };
    fetch(CREATE_USER_URL, context)
        .then(response => response.json())
            .then(response => callbackUser(response))
            .catch(error => err_callback(error));
}

function callbackUser(response){
    console.log(response)
}

function err_callback(error){
    console.log(error);
}
