import { useEffect, useState } from "react";
import { Button, Table } from "react-bootstrap";
import { getMenu } from "../../api/customerAPI";
import OrderModal from "./OrderModal";
import RestaurantSearch from "./RestaurantList/RestaurantSearch";

function RestaurantList() {
  const [restaurant, setRestaurant] = useState("");
  const [menu, setMenu] = useState([]);
  const [show, setShow] = useState(false);
  const [search, setSearch] = useState("");
  const [restaurantList, setRestaurantList] = useState(
    JSON.parse(sessionStorage.getItem("restaurantList"))
  );

  function order(item) {
    setRestaurant(item.name);
    getMenu(item.name).then(() => {
      setMenu(JSON.parse(sessionStorage.getItem("menu")));
      setShow(true);
    });
  }
  function searchRestaurants(event) {
    const restaurants = JSON.parse(sessionStorage.getItem("restaurantList"));
    const filteredRestaurants = restaurants.filter((restaurant) => {
      return restaurant.name.includes(search);
    });
    setRestaurantList(filteredRestaurants);
    event.preventDefault();
  }

  return (
    <>
      <RestaurantSearch
        search={search}
        setSearch={setSearch}
        handleSubmit={searchRestaurants}
      />
      <Table hover>
        <thead>
          <tr>
            <th>Name</th>
            <th>Address</th>
            <th>Delivery Zones</th>
            <th />
          </tr>
        </thead>
        <tbody>
          {restaurantList.map((item, index) => {
            return (
              <tr key={index}>
                <td>{item.name}</td>
                <td>{item.address}</td>
                <td>{item.deliveryZones}</td>
                <td>
                  <Button onClick={() => order(item)}>Order now!</Button>
                </td>
              </tr>
            );
          })}
        </tbody>
      </Table>

      <OrderModal
        restaurant={restaurant}
        setShow={setShow}
        show={show}
        menu={menu}
      />
    </>
  );
}

export default RestaurantList;
