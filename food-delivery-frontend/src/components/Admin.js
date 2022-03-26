import {Route, Routes} from "react-router-dom";
import NewRestaurant from "./AdminComponents/NewRestaurant";
import Orders from "./AdminComponents/Orders";
import Manager from "./AdminComponents/Manager";
import React from "react";
import Menu from "./AdminComponents/Menu";

function Admin() {
    return (
        <div>
            <Routes>
                <Route index element={<Menu/>}/>
                <Route path="add-restaurant" element={<NewRestaurant/>}/>
                <Route path="view-orders" element={<Orders/>}/>
                <Route path="manage-restaurant" element={<Manager/>}/>
            </Routes>
        </div>
    );
}

export default Admin;
