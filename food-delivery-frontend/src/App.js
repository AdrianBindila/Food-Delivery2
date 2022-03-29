import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Admin from "./components/Admin";
import Navbar from "./components/Navigationbar";
import Customer from "./components/Customer";
import Login from "./components/Login";
import Register from "./components/Register";
import { sendLogin, user } from "./api/loginAPI";
import { sendRegistration } from "./api/registerAPI";

function App() {
  //isAdmin;
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Navbar />}>
          <Route path="login" element={<Login onLogin={sendLogin} />} />
          <Route
            path="register"
            element={<Register onRegister={sendRegistration} />}
          />
          <Route
            path="customer/*"
            element={<Customer currentCustomer={user} />}
          />
          {/*currentCustomer*/}
          <Route path="admin/*" element={<Admin currentAdmin={user} />} />{" "}
          {/*currentAdmin*/}
        </Route>
      </Routes>
    </BrowserRouter>
  );
}
export default App;
