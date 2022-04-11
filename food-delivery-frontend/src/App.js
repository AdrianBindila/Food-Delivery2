import React from "react";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Admin from "./components/Admin";
import NavigationBar from "./components/NavigationBar";
import Customer from "./components/Customer";
import Login from "./components/Login";
import Register from "./components/Register";
import {sendLogin} from "./api/loginAPI";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<NavigationBar/>}>
                    <Route path="login" element={<Login onLogin={sendLogin}/>}/>
                    <Route path="register" element={<Register/>}/>
                    <Route path="customer/*" element={<Customer/>}/>
                    <Route path="admin/*" element={<Admin/>}/>
                </Route>
            </Routes>
        </BrowserRouter>
    );
}

export default App;
