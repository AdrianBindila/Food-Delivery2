import { Route, Routes } from "react-router-dom";
import RestaurantForm from "./Admin/AddRestaurant/RestaurantForm";
import Orders from "./Admin/ViewOrders/Orders";
import Manager from "./Admin/ManageRestaurant/Manager";
import React from "react";
import Dashboard from "./Admin/Dashboard";
import {
  getMenu,
  getOrders,
  menu,
  sendFood,
  sendRestaurant,
} from "../api/adminAPI";
import { user } from "../api/loginAPI";

function Admin() {
  return (
    <div>
      <Routes>
        <Route
          index
          element={<Dashboard getMenu={getMenu} loadOrders={getOrders} />}
        />
        <Route
          path="add-restaurant"
          element={<RestaurantForm onAdd={sendRestaurant} />}
        />
        <Route path="view-orders" element={<Orders />} />
        <Route path="manage-restaurant" element={<Manager />} />
      </Routes>
    </div>
  );
}

export default Admin;
