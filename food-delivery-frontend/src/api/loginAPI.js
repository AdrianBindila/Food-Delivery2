import axios from "axios";

class Admin {
  constructor(id, username, password, restaurant) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.restaurant = restaurant;
  }
}

let user = undefined;
let isAdmin = undefined;

async function sendLogin(login) {
  await axios
    .get("http://localhost:8080/api/login", {
      params: login,
    })
    .then((res) => {
      user = res.data;
      console.log(user);
      isAdmin = user.firstName === undefined;
    })
    .catch((err) => console.log(err));
  return isAdmin;
}

export { sendLogin, user };
