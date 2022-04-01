import axios from "axios";
import { user } from "./loginAPI";

async function sendRestaurant(restaurant) {
  await axios
    .post("http://localhost:8080/api/admin/addRestaurant", restaurant, {
      params: {
        username: user.username,
      },
    })
    .then((res) => {
      user.restaurant = res;
      return res;
    })
    .then((err) => console.log(err));
}

async function sendFood(food) {
  await axios
    .post("http://localhost:8080/api/restaurant/food", food, {
      params: {
        restaurantName: user.restaurant.name,
      },
    })
    .then((res) => console.log(res))
    .then((err) => console.log(err));
}

let menu = undefined;

async function getMenu() {
  await axios
    .get("http://localhost:8080/api/restaurant/food", {
      params: {
        restaurantName: user.restaurant.name,
      },
    })
    .then((res) => {
      menu = res.data;
    })
    .catch((err) => console.log(err));
  return menu;
}

async function getOrders(restaurant) {
  await axios.get("");
}

export { sendRestaurant, sendFood, getMenu, getOrders, menu };
