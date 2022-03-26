import {Route, Routes} from "react-router-dom";
import RestaurantList from "./CustomerComponents/RestaurantList";
import Cart from "./CustomerComponents/Cart";
import CurrentOrder from "./CustomerComponents/CurrentOrder";
import OrderHistory from "./CustomerComponents/OrderHistory";

function Customer() {
    return (
        <div>
            <Routes>
                <Route index element={<RestaurantList/>}/>
                <Route path="cart" element={<Cart/>}/>
                <Route path="current-order" element={<CurrentOrder/>}/>
                <Route path="order-history" element={<OrderHistory/>}/>
            </Routes>
        </div>
    );
}

export default Customer;
