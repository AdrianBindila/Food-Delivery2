import {Button} from "react-bootstrap";
import React from "react";
import {useNavigate} from "react-router";


function Menu() {
    const navigate = useNavigate();
    function handleClick(path) {
        navigate(path);
    }
    return(<div>
        <Button variant="primary" onClick={() => handleClick("add-restaurant")}>
            Add Restaurant
        </Button>
        <Button variant="primary" onClick={() => handleClick("view-orders")}>
            View Orders
        </Button>
        <Button variant="primary" onClick={() => handleClick("manage-restaurant")}>
            Manage Restaurant
        </Button>
    </div>);
}
export default Menu;