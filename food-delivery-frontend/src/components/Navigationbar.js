import { Button } from "bootstrap";
import { Container, Nav, Navbar, NavDropdown, NavLink } from "react-bootstrap";
import { Link, Outlet } from "react-router-dom";

function Navigationbar() {
  return (
    <div>
      <Navbar bg="light" expand="lg">
        <Container>
          <Navbar.Brand href="/login">Food Panda</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <Nav.Link href="/login">Login</Nav.Link>
              <Nav.Link href="/register">Register</Nav.Link>
              <Nav.Link href="/admin">Admin</Nav.Link>
              <Nav.Link href="/customer">Customer</Nav.Link>
              <Nav.Link href="/customer/cart">Cart</Nav.Link>
              <Nav.Link href="/customer/current-order">Current Order</Nav.Link>
              <Nav.Link href="/customer/order-history">Order History</Nav.Link>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
      <Outlet />
    </div>
  );
}

export default Navigationbar;
