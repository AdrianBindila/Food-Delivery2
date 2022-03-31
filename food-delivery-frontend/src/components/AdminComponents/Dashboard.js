import {Button} from "react-bootstrap";
import React from "react";
import {useNavigate} from "react-router";
import {user} from "../../api/loginAPI";

function Dashboard() {
    let admin=user;

    let hasRestaurant = false;


    const navigate = useNavigate();

    function handleClick(path) {
        navigate(path);
    }

    function viewOrders() {
        navigate("view-orders");
    }

    function viewMenu() {
        navigate("manage-restaurant");
    }

    return (
        <div>
            {!admin.restaurant && <Button variant="primary" onClick={() => handleClick("add-restaurant")}>
                Add Restaurant
            </Button>}
            <Button variant="primary" onClick={viewOrders}>
                View Orders
            </Button>
            <Button
                variant="primary"
                onClick={viewMenu}
            >
                Manage Restaurant
            </Button>
        </div>
    );
}

export default Dashboard;
