import React, {useEffect} from "react";
import {BrowserRouter, Redirect, Route, Routes} from "react-router-dom";
import Admin from "./components/Admin";
import NavigationBar from "./components/NavigationBar";
import Customer from "./components/Customer";
import Login from "./components/Login";
import Register from "./components/Register";
import {Navigate, useNavigate} from "react-router";

function App() {
    const loggedIn = false;
    const isAdmin = false;

    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<NavigationBar/>}>
                    <Route path="login" element={<Login/>}/>
                    <Route path="register" element={<Register/>}/>
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
