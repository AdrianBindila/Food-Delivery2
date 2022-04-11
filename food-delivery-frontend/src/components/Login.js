import { Button, Form } from "react-bootstrap";
import { useState } from "react";
import { useNavigate } from "react-router";
import { getRestaurantList } from "../api/customerAPI";

function Login(props) {
  const navigate = useNavigate();
  const [login, setLogin] = useState({
    username: "",
    password: "",
  });

  function handleChange(event) {
    const { name, value } = event.target;
    setLogin((prevLogin) => {
      return {
        ...prevLogin,
        [name]: value,
      };
    });
  }

  function handleSubmit(event) {
    props.onLogin(login).then((isAdmin) => {
      setLogin({
        username: "",
        password: "",
      });
      isAdmin
        ? navigate("/admin")
        : getRestaurantList().then(() => navigate("/customer"));
    });
    event.preventDefault();
  }

  return (
    <Form onSubmit={handleSubmit}>
      <Form.Group className="mb-3">
        <Form.Label>Username</Form.Label>
        <Form.Control
          type="username"
          placeholder="Username"
          name="username"
          value={login.username}
          onChange={handleChange}
        />
      </Form.Group>

      <Form.Group className="mb-3">
        <Form.Label>Password</Form.Label>
        <Form.Control
          type="password"
          placeholder="Password"
          name="password"
          value={login.password}
          onChange={handleChange}
        />
      </Form.Group>

      <Button variant="primary" type="submit">
        Log in
      </Button>

      <Button variant="primary" onClick={() => navigate("/register")}>
        Register
      </Button>
    </Form>
  );
}

export default Login;
