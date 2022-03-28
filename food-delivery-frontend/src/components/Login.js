import { Button, Form } from "react-bootstrap";
import { useState } from "react";
import { useNavigate } from "react-router";

function Login(props) {
  const [login, setLogin] = useState({
    username: "",
    password: "",
  });

  const navigate = useNavigate();
  function register() {
    navigate("/register");
  }

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
      console.log(isAdmin);
      setLogin({
        username: "",
        password: "",
      });
      isAdmin ? navigate("/admin") : navigate("/customer");
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
      <Button variant="primary" onClick={register}>
        Register
      </Button>
    </Form>
  );
}

export default Login;
