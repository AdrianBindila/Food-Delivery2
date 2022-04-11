import { useState } from "react";
import { Button, Table } from "react-bootstrap";
import { getMenu } from "../../api/customerAPI";
import OrderModal from "./OrderModal";

function RestaurantList() {
  const [restaurant, setRestaurant] = useState("");
  const [menu, setMenu] = useState([]);
  const [show, setShow] = useState(false);
  function order(item) {
    setRestaurant(item.name);
    getMenu(item.name).then(() => {
      setMenu(JSON.parse(sessionStorage.getItem("menu")));
      setShow(true);
    });
  }

  const restaurantList = JSON.parse(sessionStorage.getItem("restaurantList"));

  return (
    <>
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
