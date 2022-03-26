import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Admin from "./components/Admin";
import App from "./components/App";
import Customer from "./components/Customer";
import Login from "./components/Login";
import Register from "./components/Register";
import Restaurants from "./components/Restaurants";

ReactDOM.render(
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<App />}>
        <Route path="login" element={<Login />} />
        <Route path="register" element={<Register />} />
      </Route>
      <Route path="customer" element={<Customer />} />
      <Route path="restaurants" element={<Restaurants />} />
      <Route path="admin" element={<Admin />} />
    </Routes>
  </BrowserRouter>,
  document.getElementById("root")
);
