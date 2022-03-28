import axios from "axios";

const adminUsername = "qwer";

function sendRestaurant(restaurant) {
  console.log(restaurant);
  axios
    .post("http://localhost:8080/api/admin/addRestaurant", restaurant, {
      params: {
        username: adminUsername,
      },
    })
    .then((res) => console.log(res))
    .then((err) => console.log(err));
}

export { sendRestaurant };
