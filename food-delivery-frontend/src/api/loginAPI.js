import axios from "axios";

function sendLogin(login) {
    axios
        .get("http://localhost:8080/api/customer", {
            params:login
        })
        .then(res => console.log(res.data))
        .catch(err => console.log(err));
}

export {sendLogin};