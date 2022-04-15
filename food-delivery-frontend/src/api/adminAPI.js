import axios from "axios";

async function sendRestaurant(restaurant) {
  let user = JSON.parse(sessionStorage.getItem("user"));
  await axios
    .post("/admin/addRestaurant", restaurant, {
      params: {
        username: user.username,
      },
    })
    .then((res) => {
      user = JSON.parse(sessionStorage.getItem("user"));
      user.restaurant = res;
      sessionStorage.setItem("user", JSON.stringify(user));
    })
    .then((err) => console.log(err));
}

async function sendFood(food) {
  let user = JSON.parse(sessionStorage.getItem("user"));
  await axios
    .post("/restaurant/food", food, {
      params: {
        restaurantName: user.restaurant.name,
      },
    })
    .then((res) => console.log(res))
    .then((err) => console.log(err));
}

async function getMenu() {
  let user = JSON.parse(sessionStorage.getItem("user"));
  await axios
    .get("/restaurant/food", {
      params: {
        restaurantName: user.restaurant.name,
      },
    })
    .then((res) => {
      sessionStorage.setItem("menu", JSON.stringify(res.data));
    })
    .catch((err) => console.log(err));
}

async function getOrders() {//need order id in order DTO
  let user = JSON.parse(sessionStorage.getItem("user"));
  await axios
    .get("/order/restaurant", {
      params: {
        restaurantName: user.restaurant.name,
      },
    })
    .then((res) => {
      sessionStorage.setItem("restaurantOrders", JSON.stringify(res.data));
    })
    .catch((err) => console.log(err));
}

async function updateOrder(order){//update by id, since it's the only unique field
    await axios
        .put("/order/restaurant",{
            params:{

            }
        })
}

export { sendRestaurant, sendFood, getMenu, getOrders, updateOrder };
