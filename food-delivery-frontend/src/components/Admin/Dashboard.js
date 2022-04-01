import { Button } from "react-bootstrap";
import React from "react";
import { useNavigate } from "react-router";
import { user } from "../../api/loginAPI";
import { menu } from "../../api/adminAPI";

function Dashboard(props) {
  let admin = user;

  const navigate = useNavigate();

  function handleClick(path) {
    navigate(path);
  }

  function viewOrders() {
    //load restaurant's orders
    navigate("view-orders");
  }

  function viewMenu() {
    props.getMenu().then((data) => {
      navigate("manage-restaurant");
    });
  }

  return (
    <div>
      {admin.restaurant ? (
        <div>
          <Button variant="primary" onClick={viewOrders}>
            View Orders
          </Button>
          <Button variant="primary" onClick={viewMenu}>
            Manage Restaurant
          </Button>
        </div>
      ) : (
        <Button variant="primary" onClick={() => handleClick("add-restaurant")}>
          Add Restaurant
        </Button>
      )}
    </div>
  );
}

export default Dashboard;
