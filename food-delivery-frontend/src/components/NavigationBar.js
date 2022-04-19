import {
  Button,
  Container,
  Nav,
  Navbar,
  NavbarBrand,
  NavLink,
} from "react-bootstrap";
import { Outlet } from "react-router-dom";
import { getOrdersHistory } from "../api/customerAPI";
import { useLocation, useNavigate } from "react-router";
import NavbarToggle from "react-bootstrap/esm/NavbarToggle";
import NavbarCollapse from "react-bootstrap/esm/NavbarCollapse";
import { useEffect, useState } from "react";
import RestaurantSearch from "./Customer/RestaurantList/RestaurantSearch";

function NavigationBar() {
  const [isAdmin, setAdmin] = useState(false);
  const location = useLocation();
  return (
    <>
      <Navbar bg="light" expand="lg">
        <Container>
          <NavbarBrand href="/login">Food Panda</NavbarBrand>
          <NavbarToggle aria-controls="basic-navbar-nav" />
          <NavbarCollapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <NavLink href="/login">Login</NavLink>
              <NavLink href="/register">Register</NavLink>
              {isAdmin && <NavLink href="/admin">Admin</NavLink>}
              {!isAdmin && (
                <>
                  <NavLink href="/customer">Customer</NavLink>
                  <NavLink href="/customer/current-order">
                    Current Order
                  </NavLink>
                  <NavLink href="/customer/order-history">
                    Order History
                  </NavLink>
                  {/* {location.pathname === "/customer" && <RestaurantSearch />} */}
                </>
              )}
              <NavLink href="/login" onClick={() => sessionStorage.clear()}>
                Logout
              </NavLink>
            </Nav>
          </NavbarCollapse>
        </Container>
      </Navbar>
      <Outlet />
    </>
  );
}

export default NavigationBar;
