import React from "react";
import ReactDOM from "react-dom";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Admin from "./components/Admin";
import App from "./components/App";
import Customer from "./components/Customer";
import Login from "./components/Login";
import Register from "./components/Register";
import Restaurants from "./components/Restaurants";
import NewRestaurant from "./components/AdminComponents/NewRestaurant";
import Orders from "./components/AdminComponents/Orders";
import Manager from "./components/AdminComponents/Manager";

ReactDOM.render(
    <BrowserRouter>
        <Routes>
            <Route path="/" element={<App/>}>
                <Route path="login" element={<Login/>}/>
                <Route path="register" element={<Register/>}/>
                <Route path="customer/*" element={<Customer/>}/>
                <Route path="restaurants" element={<Restaurants/>}/>
                <Route path="admin/*" element={<Admin/>}/>
            </Route>
        </Routes>
    </BrowserRouter>,
    document.getElementById("root")
);
