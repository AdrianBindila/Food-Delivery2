import React from "react";
import { useNavigate } from "react-router";
import { Button } from "react-bootstrap";
import { getMenu, getOrders } from "../../api/adminAPI";

function Dashboard() {
  const admin = JSON.parse(sessionStorage.getItem("user"));
  const navigate = useNavigate();

  function viewOrders() {
    getOrders().then(() => navigate("view-orders"));
  }

  function viewMenu() {
    getMenu().then(() => navigate("manage-restaurant"));
  }

  return (
    <>
      {admin.restaurant ? (
        <>
          <h1>{admin.restaurant.name}</h1>
          <Button variant="primary" onClick={viewOrders}>
            View Orders
          </Button>
          <Button variant="primary" onClick={viewMenu}>
            Manage Restaurant
          </Button>
        </>
      ) : (
        <Button variant="primary" onClick={() => navigate("add-restaurant")}>
          Add Restaurant
        </Button>
      )}
    </>
  );
}

export default Dashboard;
