import {Button, Form, Row} from "react-bootstrap";
import {useEffect, useState} from "react";
import {useNavigate} from "react-router";
import {getRestaurantList} from "../api/customerAPI";
import styles from "./styles.module.css";
import {sendLogin} from "../api/loginAPI";

function Login() {
    const [isAdmin,setAdmin]=useState();
    useEffect(()=>{
        sessionStorage.setItem("isAdmin",JSON.stringify(isAdmin));
    },[isAdmin]);
    const navigate = useNavigate();
    const [login, setLogin] = useState({
        username: "",
        password: "",
    });

    function handleChange(event) {
        const {name, value} = event.target;
        setLogin((prevLogin) => {
            return {
                ...prevLogin,
                [name]: value,
            };
        });
    }

    function handleSubmit(event) {
        login.username.length > 0 && login.password.length > 0 ?
            sendLogin(login).then((isAdmin) => {
                setLogin({
                    username: "",
                    password: "",
                });
                sessionStorage.setItem("isAdmin", JSON.stringify(isAdmin));
                isAdmin
                    ? navigate("/admin")
                    : getRestaurantList().then(() => navigate("/customer"));
            }) : document.getElementById('submit').blur();
        event.preventDefault();
    }

    return (
        <div className={styles.container}>
            <div className={styles.loginForm}>
                <Form onSubmit={handleSubmit}>
                    <>
                        <Row>
                            <div className={styles.title}>Login</div>
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
                        </Row>
                        <Row>
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
                        </Row>
                        <div style={{marginTop: 10}}>
                            <Button variant="primary" type="submit" name="submit" className={styles["primary-button"]}
                                    style={{marginRight: 10}}>
                                Log in
                            </Button>

                            <Button variant="primary" onClick={() => navigate("/register")}
                                    className={styles["secondary-button"]}>
                                Register
                            </Button>
                        </div>
                    </>
                </Form>
            </div>
        </div>
    );
}

export default Login;
