import axios from "axios";

const adminUsername = "qwer";

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

export { sendRestaurant };
