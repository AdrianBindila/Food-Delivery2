import axios from "axios";

function sendRegistration(registration) {
    axios
        .post("/customer", registration)
        .then(res => console.log(res))
        .catch(err => console.log(err));

}

export {sendRegistration};