import { useState, useEffect } from "react";
import { Button, Table } from "react-bootstrap";
import { sendOrder } from "../../api/customerAPI";

function Cart(props) {
  function makeOrder(cart) {
    const order = {
      status: "PENDING",
      date: new Date().toISOString().substring(0, 10),
      totalPrice: cart.reduce((total, item) => total + item.price, 0),
      items: cart,
    };
    return order;
  }

  function deleteItem(item) {
    props.setCart((prevCart) => {
      return prevCart.filter((current) => {
        return current !== item; //currently deletes all identical items, so multiple beers are gone with one click
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
            <th></th>
          </tr>
        </thead>
        <tbody>
          {props.cart.map((item, index) => {
            return (
              <tr key={index}>
                <td>{item.name}</td>
                <td>{item.description}</td>
                <td>{item.price}</td>
                <td>
                  <Button
                    onClick={() => {
                      deleteItem(item);
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
      <Button
        size="lg"
        onClick={() => {
          let order = makeOrder(props.cart);
          sendOrder(order, props.restaurant);
        }}
      >
        Finish order
      </Button>
    </>
  );
}
export default Cart;
