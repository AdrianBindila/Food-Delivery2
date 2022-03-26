import { Button, Form } from "react-bootstrap";
function Register() {
  return (
    <Form>
      {/* <Form.Group className="mb-3" controlId="formBasicEmail"> */}
      {/* <Form.Label>First Name</Form.Label> */}
      <Form.Control type="firstname" placeholder="First Name" />
      {/* </Form.Group> */}

      <Form.Group className="mb-3" controlId="formBasicEmail">
        <Form.Label>Last Name</Form.Label>
        <Form.Control type="lastname" placeholder="Last Name" />
      </Form.Group>

      <Form.Group className="mb-3" controlId="formBasicEmail">
        <Form.Label>Address</Form.Label>
        <Form.Control type="address" placeholder="Address" />
      </Form.Group>

      <Form.Group className="mb-3" controlId="formBasicEmail">
        <Form.Label>Phone</Form.Label>
        <Form.Control type="phone" placeholder="Phone" />
      </Form.Group>

      <Form.Label>Username</Form.Label>
      <Form.Control type="username" placeholder="Username" />

      <Form.Group className="mb-3" controlId="formBasicPassword">
        <Form.Label>Password</Form.Label>
        <Form.Control type="password" placeholder="Password" />
      </Form.Group>
      <Form.Group className="mb-3" controlId="formBasicEmail">
        <Form.Label>Confirm Password</Form.Label>
        <Form.Control type="confpass" placeholder="Confirm Password" />
      </Form.Group>
      <Button variant="primary" type="submit">
        Log in
      </Button>
      <Button variant="primary" type="submit">
        Register
      </Button>
    </Form>
  );
}
export default Register;
