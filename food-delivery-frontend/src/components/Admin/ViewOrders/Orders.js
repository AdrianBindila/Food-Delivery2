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

function Orders() {
  const [show, setShow] = useState(false);
  const [orderList, setOrderList] = useState([]);
  const status = {
    pending: "PENDING",
    accepted: "ACCEPTED",
    in_delivery: "IN_DELIVERY",
    delivered: "DELIVERED",
    declined: "DECLINED",
  };

  const handleClose = () => {
    setShow(false);
  };
  const handleShow = (items) => {
    setOrderList(items);
    setShow(true);
  };

  const orders = JSON.parse(sessionStorage.getItem("restaurantOrders"));
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
            <th />
            <th />
          </tr>
        </thead>
        <tbody>
          {orders &&
            orders.map((order, index) => {
              return (
                <tr key={index}>
                  <td>{order.customerFullName}</td>
                  <td>
                    {/* TODO: fix this date */}
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
                    {order.status === status.pending ? (
                      <>
                        <Button>
                          <span className="material-icons">done</span>
                        </Button>
                        <Button>
                          <span className="material-icons">close</span>
                        </Button>
                      </>
                    ) : (
                      <Button>
                        <span className="material-icons">
                          arrow_forward_ios
                        </span>
                      </Button>
                    )}
                  </td>
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
          <ModalTitle>This client wants:</ModalTitle>
        </ModalHeader>
        <ModalBody>
          <ListGroup>
            {orderList.map((item) => {
              return <ListGroupItem>{item.name}</ListGroupItem>;
            })}
          </ListGroup>
        </ModalBody>
      </Modal>
    </>
  );
}

export default Orders;
