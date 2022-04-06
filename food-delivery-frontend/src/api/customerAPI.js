import axios from "axios";
import { user } from "./loginAPI";
let restaurantList = undefined;
async function getRestaurantList() {
  await axios
    .get("http://localhost:8080/api/restaurant")
    .then((res) => {
      restaurantList = res.data;
    })
    .catch((err) => console.log(err));
  return restaurantList;
}
let menu = undefined;
async function getMenu(restaurantName) {
  await axios
    .get("http://localhost:8080/api/restaurant/food", {
      params: {
        restaurantName: restaurantName,
      },
    })
    .then((res) => {
      menu = res.data;
    })
    .catch((err) => console.log(err));
  return menu;
}
async function getOrdersHistory() {
  await axios.get();
}
async function getPendingOrder() {}

async function sendOrder(order, restaurantName) {
  await axios
    .post("http://localhost:8080/api/order", order, {
      params: {
        username: user.username,
        restaurantName: restaurantName,
      },
    })
    .then((res) => {
      menu = res.data;
    })
    .catch((err) => console.log(err));
}
export { getRestaurantList, restaurantList, menu, getMenu, sendOrder };
