import axios from "axios";

var adminUsername = "qwer";
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

async function getMenu(restaurant) {
  await axios.get("");
}

async function getOrders(restaurant) {
  await axios.get("");
}

var restaurantName = "Organizer";

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
export { sendRestaurant, sendFood };
