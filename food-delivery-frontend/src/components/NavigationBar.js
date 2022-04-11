import { Container, Nav, Navbar } from "react-bootstrap";
import { Outlet } from "react-router-dom";

function NavigationBar() {
  return (
    <>
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
              <Nav.Link href="/login" onClick={() => sessionStorage.clear()}>
                Logout
              </Nav.Link>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
      <Outlet />
    </>
  );
}

export default NavigationBar;
