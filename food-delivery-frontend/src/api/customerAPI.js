import axios from "axios";

async function getRestaurantList() {
    await axios
        .get("/restaurant")
        .then((res) => {
            sessionStorage.setItem("restaurantList", JSON.stringify(res.data));
        })
        .catch((err) => console.log(err));
}

async function getMenu(restaurantName) {
    await axios
        .get("/restaurant/food", {
            params: {
                restaurantName: restaurantName,
            },
        })
        .then((res) => {
            sessionStorage.setItem("menu", JSON.stringify(res.data));
        })
        .catch((err) => console.log(err));
}

async function getOrdersHistory(username) {
    await axios
        .get("/customer/order", {
            params: {
                username: username
            }
        })
        .then((res) => {
            sessionStorage.setItem("customerOrderHistory", JSON.stringify(res.data));
        })
        .catch((err) => console.log(err));
}

async function getPendingOrders(username) {
    await axios
        .get("/customer/order/pending", {
            params: {
                username: username
            }
        })
        .then((res) => {
            sessionStorage.setItem("customerPendingOrders", JSON.stringify(res.data));
        })
        .catch((err) => console.log(err));
}

async function sendOrder(order, restaurantName) {
    let user = JSON.parse(sessionStorage.getItem("user"));
    await axios
        .post("/order", order, {
            params: {
                username: user.username,
                restaurantName: restaurantName,
            },
        }) //TODO: update the list of orders
        .catch((err) => console.log(err));
}

export {getRestaurantList, getMenu, sendOrder, getOrdersHistory, getPendingOrders};
