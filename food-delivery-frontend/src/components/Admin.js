import {Route, Routes} from "react-router-dom";
import RestaurantForm from "./Admin/AddRestaurant/RestaurantForm";
import Orders from "./Admin/ViewOrders/Orders";
import Manager from "./Admin/ManageRestaurant/Manager";
import React from "react";
import Dashboard from "./Admin/Dashboard";

function Admin() {
    return (
        <>
            <Routes>
                <Route
                    index
                    element={<Dashboard/>}
                />
                <Route
                    path="add-restaurant"
                    element={<RestaurantForm/>}
                />
                <Route
                    path="view-orders"
                    element={<Orders/>}/>
                <Route
                    path="manage-restaurant"
                    element={<Manager/>}/>
            </Routes>
        </>
    );
}

export default Admin;
