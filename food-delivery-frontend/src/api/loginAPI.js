import axios from "axios";
//TODO: use state to change global variables
class Admin {
  constructor(username, password, restaurant) {
    this.username = username;
    this.password = password;
    this.restaurant = restaurant;
  }
}
class Restaurant {
  constructor(name, address, deliveryZones) {
    this.name = name;
    this.address = address;
    this.deliveryZones = deliveryZones;
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
      isAdmin = user.firstName === undefined;
      // sessionStorage.setItem("isAdmin", JSON.stringify(isAdmin));
    })
    .catch((err) => console.log(err));
  return isAdmin;
}

export { sendLogin, user };
