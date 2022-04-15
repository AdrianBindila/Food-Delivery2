import {useEffect, useState} from "react";
import {Button, Table} from "react-bootstrap";
import {sendOrder} from "../../../api/customerAPI";

function Cart(props) {
    const updateCart = props.cart.reduce((total, item) => total + item.price, 0);
    const [total, setTotal] = useState(updateCart);

    useEffect(() => {
        setTotal(updateCart)
    }, [props.cart]);

    function makeOrder(cart) {
        return {
            status: "PENDING",
            date: new Date().toISOString().substring(0, 10),
            totalPrice: total,
            items: cart,
        };
    }

    function deleteItem(id) {
        props.setCart((prevCart) => {
            return prevCart.filter((current,index) => {
                return index !== id;
            });
        });
    }

    return (
        <>
            <Table>
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th/>
                </tr>
                </thead>
                <tbody>
                {props.cart.map((item, index) => {
                    item.id=index;
                    return (
                        <tr key={index}>
                            <td>{item.name}</td>
                            <td>{item.description}</td>
                            <td>{item.price}</td>
                            <td>
                                <Button
                                    onClick={() => {
                                        deleteItem(index);
                                    }}
                                >
                                    X
                                </Button>
                            </td>
                        </tr>
                    );
                })}
                </tbody>
            </Table>
            <p>Total price: {total}</p>
            <Button
                disabled={props.cart.length===0}
                size="lg"
                onClick={() => {
                    let order = makeOrder(props.cart);
                    sendOrder(order, props.restaurant).then(
                        props.onOrder()
                    );
                }}
            >
                Finish order
            </Button>
        </>
    );
}

export default Cart;
