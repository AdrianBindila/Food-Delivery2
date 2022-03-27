import axios from "axios";

function sendRegistration(registration) {
    console.log(registration);
    axios
        .post("http://localhost:8080/api/customer",registration)
        .then(res => console.log(res))
        .catch(err => console.log(err));

}
export {sendRegistration};