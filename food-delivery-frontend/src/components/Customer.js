import { Route, Routes } from "react-router-dom";
import RestaurantList from "./Customer/RestaurantList";
import Cart from "./Customer/Cart";
import CurrentOrder from "./Customer/CurrentOrder";
import OrderHistory from "./Customer/OrderHistory";

function Customer() {
  return (
    <div>
      <Routes>
        <Route index element={<RestaurantList />} />
        <Route path="cart" element={<Cart />} />
        <Route path="current-order" element={<CurrentOrder />} />
        <Route path="order-history" element={<OrderHistory />} />
      </Routes>
    </div>
  );
}

export default Customer;
