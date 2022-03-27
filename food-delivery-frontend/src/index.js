import React from "react";
import ReactDOM from "react-dom";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Admin from "./components/Admin";
import App from "./components/App";
import Customer from "./components/Customer";
import Login from "./components/Login";
import Register from "./components/Register";
import {sendLogin} from "./api/loginAPI";
import {sendRegistration} from "./api/registerAPI";

ReactDOM.render(
    <BrowserRouter>
        <Routes>
            <Route path="/" element={<App/>}>
                <Route path="login" element={<Login onLogin={sendLogin}/>}/>
                <Route path="register" element={<Register onRegister={sendRegistration}/>}/>
                <Route path="customer/*" element={<Customer/>}/>
                <Route path="admin/*" element={<Admin/>}/>
            </Route>
        </Routes>
    </BrowserRouter>,
    document.getElementById("root")
);
