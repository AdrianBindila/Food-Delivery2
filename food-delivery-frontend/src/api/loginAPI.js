import axios from "axios";

class Admin {
  constructor(id, username, password, restaurant) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.restaurant = restaurant;
  }
}
var user = undefined;
var isAdmin = undefined;

async function sendLogin(login) {
  await axios
    .get("http://localhost:8080/api/login", {
      params: login,
    })
    .then((res) => {
      user = res.data;
      if (user.firstName === undefined) {
        //very hacky, but I couldn't think of a better way
        console.log("Hello Admin");
        isAdmin = true;
      } else {
        console.log("Hello Customer");
        isAdmin = false;
      }
    })
    .catch((err) => console.log(err));
  return isAdmin;
}

export { sendLogin, user };
