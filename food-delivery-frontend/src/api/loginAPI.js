import axios from "axios";
import {useEffect} from "react";

let isAdmin = undefined;

axios.defaults.baseURL = "http://localhost:8080/api";

async function sendLogin(login) {
  await axios
    .get("/login", {
      params: login,
    })
    .then((res) => {
      let user = res.data;
      sessionStorage.setItem("user", JSON.stringify(user));
      isAdmin = user.firstName === undefined;
    })
    .catch((err) => console.log(err));
  return isAdmin;
}

export { sendLogin };
