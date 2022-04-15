import {useEffect, useState} from "react";
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
import {updateOrder} from "../../../api/adminAPI";

function Orders() {
    const [show, setShow] = useState(false);
    const [orderList, setOrderList] = useState([]);
    const [orders, setOrders] = useState(JSON.parse(sessionStorage.getItem("restaurantOrders")));
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

    function accept(order, index) {
        setOrders((prevOrders) => {
            prevOrders[index].status=status.accepted;
            return [...prevOrders];
        });
    }

    function decline(order,index) {

    }
    const changeStatus = (order,index,stat) => {
        setOrders((prevOrders) => {
            prevOrders[index].status=stat;
            return [...prevOrders];
        });
        order.status=stat;
        updateOrder(order);
    }
    function updateStatus(order,index) {
        switch (order.status) {
            case status.pending:
                changeStatus(order,index,status.accepted);
                break;
            case status.accepted:
                changeStatus(order,index,status.in_delivery);
                break;
            case status.in_delivery:
                changeStatus(order,index,status.delivered);
                break;
            case status.delivered:
                break;
            case status.declined:
                break;
        }
    }

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
                    <th/>
                    <th/>
                </tr>
                </thead>
                <tbody>
                {orders &&
                    orders.map((order, index) => {
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
                                    {order.status === status.pending ? (
                                        <>
                                            <Button onClick={() => changeStatus(order, index,status.accepted)}>
                                                <span className="material-icons">done</span>
                                            </Button>
                                            <Button onClick={() => changeStatus(order,index,status.declined)}>
                                                <span className="material-icons">close</span>
                                            </Button>
                                        </>
                                    ) : (
                                        (order.status !== status.delivered && order.status!==status.declined) && (
                                            <Button onClick={() => updateStatus(order,index)}>
                                              <span className="material-icons">
                                                arrow_forward_ios
                                              </span>
                                            </Button>
                                        )
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
