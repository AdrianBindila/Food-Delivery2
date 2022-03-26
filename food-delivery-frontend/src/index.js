import React from "react";
import ReactDOM from "react-dom";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Admin from "./components/Admin";
import App from "./components/App";
import Customer from "./components/Customer";
import Login from "./components/Login";
import Register from "./components/Register";

ReactDOM.render(
    <BrowserRouter>
        <Routes>
            <Route path="/" element={<App/>}>
                <Route path="login" element={<Login/>}/>
                <Route path="register" element={<Register/>}/>
                <Route path="customer/*" element={<Customer/>}/>
                <Route path="admin/*" element={<Admin/>}/>
            </Route>
        </Routes>
    </BrowserRouter>,
    document.getElementById("root")
);
