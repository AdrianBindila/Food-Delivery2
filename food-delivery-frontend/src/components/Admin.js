import {useNavigate} from "react-router";
import {Outlet, Route, Routes} from "react-router-dom";
import NewRestaurant from "./NewRestaurant";
import AdminOrders from "./AdminOrders";
import RestaurantManager from "./RestaurantManager";
import React from "react";
import {Button} from "react-bootstrap";

function Admin() {
    const navigate = useNavigate();

    function handleClick(path) {
        navigate(path);
    }

    return (
        <div>
            <div>
                <Button variant="primary" onClick={() => handleClick("add-restaurant")}>
                    Add Restaurant
                </Button>
                <Button variant="primary" onClick={() => handleClick("view-orders")}>
                    View Orders
                </Button>
                <Button variant="primary" onClick={() => handleClick("manage-restaurant")}>
                    Manage Restaurant
                </Button>
                {/*<Outlet/>*/}
            </div>
            <Routes>
                <Route path="add-restaurant" element={<NewRestaurant/>}/>
                <Route path="view-orders" element={<AdminOrders/>}/>
                <Route path="manage-restaurant" element={<RestaurantManager/>}/>
            </Routes>
        </div>

    );
}

export default Admin;
