import { Button, Col, Container, Form, Row } from "react-bootstrap";
import { useState } from "react";
import { useNavigate } from "react-router";
import { sendRegistration } from "../api/registerAPI";
import styles from "./styles.module.css";

function Register(props) {
  const [register, setRegister] = useState({
    firstName: "",
    lastName: "",
    email: "",
    address: "",
    phone: "",
    username: "",
    password: "",
    confirmedPassword: "",
  });
  const navigate = useNavigate();

  function cancel() {
    navigate("/login");
  }

  function handleChange(event) {
    const { name, value } = event.target;
    setRegister((prevRegister) => {
      return {
        ...prevRegister,
        [name]: value,
      };
    });
  }

  function handleSubmit(event) {
    sendRegistration(register);
    setRegister({
      firstName: "",
      lastName: "",
      email: "",
      address: "",
      phone: "",
      username: "",
      password: "",
      confirmedPassword: "",
    });
    props.
    navigate("/login");
    event.preventDefault();
  }

  return (
    <div className={styles.container}>
      <div className={styles.registerForm}>
        <Form onSubmit={handleSubmit}>
          <Container fluid>
            <Row>
              <div className={styles.title}>Register</div>
            </Row>
            <Row>
              <Col sm={12} md={6} lg={6}>
                <Form.Group className="mb-3">
                  <Form.Label>First Name</Form.Label>
                  <Form.Control
                    type="firstname"
                    placeholder="First Name"
                    name="firstName"
                    value={register.firstName}
                    onChange={handleChange}
                  />
                </Form.Group>
              </Col>
              <Col sm={12} md={6} lg={6}>
                <Form.Group className="mb-3">
                  <Form.Label>Last Name</Form.Label>
                  <Form.Control
                    type="lastname"
                    placeholder="Last Name"
                    name="lastName"
                    value={register.lastName}
                    onChange={handleChange}
                  />
                </Form.Group>
              </Col>
            </Row>
            <Row>
              <Col sm={12} md={6} lg={6}>
                <Form.Group className="mb-3">
                  <Form.Label>Address</Form.Label>
                  <Form.Control
                    type="address"
                    placeholder="Address"
                    name="address"
                    value={register.address}
                    onChange={handleChange}
                  />
                </Form.Group>
              </Col>
              <Col sm={12} md={6} lg={6}>
                <Form.Group className="mb-3">
                  <Form.Label>Phone</Form.Label>
                  <Form.Control
                    type="phone"
                    placeholder="Phone"
                    name="phone"
                    value={register.phone}
                    onChange={handleChange}
                  />
                </Form.Group>
              </Col>
            </Row>
            <Row>
              <Col sm={12} md={6} lg={6}>
                <Form.Group className="mb-3">
                  <Form.Label>Username</Form.Label>
                  <Form.Control
                    type="username"
                    placeholder="Username"
                    name="username"
                    value={register.username}
                    onChange={handleChange}
                  />
                </Form.Group>
              </Col>
              <Col sm={12} md={6} lg={6}>
                <Form.Group className="mb-3">
                  <Form.Label>Email</Form.Label>
                  <Form.Control
                    type="email"
                    placeholder="Email"
                    name="email"
                    value={register.email}
                    onChange={handleChange}
                  />
                </Form.Group>
              </Col>
            </Row>
            <Row>
              <Col sm={12} md={6} lg={6}>
                <Form.Group className="mb-3">
                  <Form.Label>Password</Form.Label>
                  <Form.Control
                    type="password"
                    placeholder="Password"
                    name="password"
                    value={register.password}
                    onChange={handleChange}
                  />
                </Form.Group>
              </Col>
              <Col sm={12} md={6} lg={6}>
                <Form.Group className="mb-3">
                  <Form.Label>Confirm Password</Form.Label>
                  <Form.Control
                    type="password"
                    placeholder="Confirm Password"
                    name="confirmedPassword"
                    value={register.confirmedPassword}
                    onChange={handleChange}
                  />
                </Form.Group>
              </Col>
            </Row>

            <div style={{ marginTop: 10 }}>
              <Button
                type="submit"
                className={styles["secondary-button"]}
                style={{ marginRight: 10 }}
              >
                Register
              </Button>
              <Button onClick={cancel} className={styles["danger-button"]}>
                Cancel
              </Button>
            </div>
          </Container>
        </Form>
      </div>
    </div>
  );
}

export default Register;
