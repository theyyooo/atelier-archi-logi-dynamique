function generate(){

    const GET_CHUCK_URL="https://api.chucknorris.io/jokes/random"; 
    let context =   {
                        method: 'GET'
                    };
        
    fetch(GET_CHUCK_URL,context)
        .then(response => response.json())
            .then(response => callback(response))
            .catch(error => err_callback(error));
}

function callback(response){
    document.getElementById("txtChuck").innerHTML = response.value;
}

function callbackUsers(userList){
    let template = document.querySelector("#selectedUsers");
    for(const user of userList){
        let clone = document.importNode(template.content, true);
    
        newContent= clone.firstElementChild.innerHTML
                    .replace(/{{login}}/g, user.login)
                    .replace(/{{pwd}}/g, user.pwd)
                    .replace(/{{account}}/g, user.account)
                    .replace(/{{surName}}/g, user.surName)
                    .replace(/{{lastName}}/g, user.lastName)
        clone.firstElementChild.innerHTML= newContent;
    
        let cardContainer= document.querySelector("#userContainer");
        cardContainer.appendChild(clone);
    }
}

function err_callback(error){
    console.log(error);
}

function getUsers(){
    const GET_USERS_URL="https://asi2-backend-market.herokuapp.com/users";
    let context =   {
        method: 'GET'
    };
    fetch(GET_USERS_URL,context)
        .then(response => response.json())
            .then(response => callbackUsers(response))
            .catch(error => err_callback(error));
}

