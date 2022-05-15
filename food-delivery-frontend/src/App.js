import React, {useEffect, useState} from "react";
import {BrowserRouter, Redirect, Route, Routes} from "react-router-dom";
import Admin from "./components/Admin";
import NavigationBar from "./components/NavigationBar";
import Customer from "./components/Customer";
import Login from "./components/Login";
import Register from "./components/Register";
import {Navigate, useNavigate} from "react-router";

function App() {
    const [loggedIn,setLoggedIn] = useState(true);
    const [isAdmin,setAdmin] = useState(true);

    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<NavigationBar/>}>
                    <Route path="login" element={<Login loggedIn={loggedIn} setLoggedIn={setLoggedIn} isAdmin={isAdmin} setAdmin={setAdmin}/>}/>
                    <Route path="register" element={<Register loggedIn={loggedIn} setLoggedIn={setLoggedIn}/>}/>
                    <Route
                        path="customer/*"
                        element={loggedIn ? <Customer/> :
                            <Navigate to="/login"/>
                        }/>
                    <Route
                        path="admin/*"
                        element={isAdmin ? <Admin/> :
                            <Navigate to="/login"/>
                    }/>
                </Route>
            </Routes>
        </BrowserRouter>
    );
}

export default App;
