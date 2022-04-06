import { useState } from "react";
import {
  Button,
  Modal,
  ModalBody,
  ModalHeader,
  ModalTitle,
  Tab,
  Table,
  Tabs,
} from "react-bootstrap";
import { getMenu, restaurantList } from "../../api/customerAPI";
import Menu from "../Admin/ManageRestaurant/Menu";
import { menu } from "../../api/customerAPI";
import Cart from "./Cart";

function RestaurantList() {
  const [show, setShow] = useState(false);
  const [cart, setCart] = useState([]);
  const [restaurant, setRestaurant] = useState("");
  const handleClose = () => {
    setShow(false);
    setCart([]);
  };
  const handleShow = () => setShow(true);
  function order(item) {
    setRestaurant(item.name);
    getMenu(item.name).then((data) => {
      handleShow();
    });
  }
  return (
    <>
      <Table hover>
        <thead>
          <tr>
            <th>Name</th>
            <th>Address</th>
            <th>Delivery Zones</th>
            <th></th>
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

      <Modal show={show} onHide={handleClose}>
        <ModalHeader closeButton>
          <ModalTitle>Order your food!</ModalTitle>
        </ModalHeader>
        <ModalBody>
          <Tabs defaultActiveKey="breakfast" className="mb-3">
            <Tab eventKey="breakfast" title="Breakfast">
              <Menu
                category="breakfast"
                menu={menu}
                isOrder={true}
                cart={cart}
                setCart={setCart}
              />
            </Tab>
            <Tab eventKey="lunch" title="Lunch">
              <Menu
                category="lunch"
                menu={menu}
                isOrder={true}
                cart={cart}
                setCart={setCart}
              />
            </Tab>
            <Tab eventKey="dessert" title="Dessert">
              <Menu
                category="dessert"
                menu={menu}
                isOrder={true}
                cart={cart}
                setCart={setCart}
              />
            </Tab>
            <Tab eventKey="beverage" title="Beverage">
              <Menu
                category="beverage"
                menu={menu}
                isOrder={true}
                cart={cart}
                setCart={setCart}
              />
            </Tab>
            <Tab eventKey="cart" title="Cart">
              <Cart cart={cart} setCart={setCart} restaurant={restaurant} />
            </Tab>
          </Tabs>
        </ModalBody>
      </Modal>
    </>
  );
}
export default RestaurantList;
