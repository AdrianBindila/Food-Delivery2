import {Button, Form} from "react-bootstrap";
import {useState} from "react";
import {useNavigate} from "react-router";
import {sendRegistration} from "../api/registerAPI";

function Register() {
    const navigate = useNavigate();
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

    function handleChange(event) {
        const {name, value} = event.target;
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
        navigate("/login");
        event.preventDefault();
    }

    return (
        <Form onSubmit={handleSubmit}>
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

            <Button variant="primary" type="submit">
                Register
            </Button>
            <Button variant="primary" onClick={() => navigate("/login")}>
                Cancel
            </Button>
        </Form>
    );
}

export default Register;
