import {Route, Routes} from "react-router-dom";
import RestaurantForm from "./AdminComponents/RestaurantForm";
import Orders from "./AdminComponents/Orders";
import Manager from "./AdminComponents/Manager";
import React from "react";
import Dashboard from "./AdminComponents/Menu";
import {sendRestaurant} from "../api/adminAPI";

function Admin() {
    return (
        <div>
            <Routes>
                <Route index element={<Dashboard/>}/>
                <Route path="add-restaurant" element={<RestaurantForm onAdd={sendRestaurant}/>}/>
                <Route path="view-orders" element={<Orders/>}/>
                <Route path="manage-restaurant" element={<Manager/>}/>
            </Routes>
        </div>
    );
}

export default Admin;
