import { Route, Routes } from "react-router-dom";
import RestaurantList from "./Customer/RestaurantList";
import Cart from "./Customer/Cart";
import PendingOrders from "./Customer/PendingOrders";
import OrderHistory from "./Customer/OrderHistory";
import {getOrdersHistory} from "../api/customerAPI";

function Customer() {
  return (
    <>
      <Routes>
        <Route index element={<RestaurantList />} />
        <Route path="cart" element={<Cart />} />
        <Route path="current-order" element={<PendingOrders />} />
        <Route path="order-history" element={<OrderHistory />} />
      </Routes>
    </>
  );
}

export default Customer;
