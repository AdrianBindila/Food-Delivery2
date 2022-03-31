import axios from "axios";

const adminUsername = "qwer";
const restaurantName = "Organizer";

async function sendRestaurant(restaurant) {
  await axios
    .post("http://localhost:8080/api/admin/addRestaurant", restaurant, {
      params: {
        username: adminUsername,
      },
    })
    .then((res) => {
      return res;
    })
    .then((err) => console.log(err));
}

async function getOrders(restaurant) {
  await axios.get("");
}

async function sendFood(food) {
  await axios
    .post("http://localhost:8080/api/restaurant/food", food, {
      params: {
        restaurantName: restaurantName,
      },
    })
    .then((res) => console.log(res))
    .then((err) => console.log(err));
}

async function getMenu() {
  await axios
    .get("http://localhost:8080/api/restaurant/food", {
      params: restaurantName,
    })
    .then((res) => console.log(res))
    .catch((err) => console.log(err));
}

export { sendRestaurant, sendFood, getMenu };
