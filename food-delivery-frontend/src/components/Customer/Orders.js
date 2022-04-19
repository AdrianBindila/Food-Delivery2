import { useState } from "react";
import {
  Button,
  ListGroup,
  ListGroupItem,
  Modal,
  ModalBody,
  ModalHeader,
  ModalTitle,
  Table,
} from "react-bootstrap";

function Orders(props) {
  const [show, setShow] = useState(false);
  const [orderList, setOrderList] = useState([]);

  const handleClose = () => {
    setShow(false);
  };
  const handleShow = (items) => {
    setOrderList(items);
    setShow(true);
  };

  return (
    <>
      <Table>
        <thead>
          <tr>
            <th>Customer</th>
            <th>Date</th>
            <th>Delivery Address</th>
            <th>Status</th>
            <th>Total</th>
          </tr>
        </thead>
        <tbody>
          {props.orders &&
            props.orders.map((order, index) => {
              return (
                <tr key={index}>
                  <td>{order.customerFullName}</td>
                  <td>
                    {order.date[0] +
                      ".0" +
                      order.date[1] +
                      ".0" +
                      order.date[2]}
                  </td>
                  <td>{order.deliveryAddress}</td>
                  <td>{order.status}</td>
                  <td>{order.totalPrice}</td>
                  <td>
                    <Button onClick={() => handleShow(order.items)}>
                      <span className="material-icons">visibility</span>
                    </Button>
                  </td>
                </tr>
              );
            })}
        </tbody>
      </Table>

      <Modal show={show} onHide={handleClose}>
        <ModalHeader closeButton>
          <ModalTitle>Ordered items:</ModalTitle>
        </ModalHeader>
        <ModalBody>
          <Table>
            <thead>
              <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
              </tr>
            </thead>
            <tbody>
              {orderList.map((item, index) => {
                item.id = index;
                return (
                  <tr key={index}>
                    <td>{item.name}</td>
                    <td>{item.description}</td>
                    <td>{item.price}</td>
                  </tr>
                );
              })}
            </tbody>
          </Table>
        </ModalBody>
      </Modal>
    </>
  );
}

export default Orders;
