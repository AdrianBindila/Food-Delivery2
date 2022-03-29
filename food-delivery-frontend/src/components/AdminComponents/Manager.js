import { Button, Modal } from "react-bootstrap";
import { Tab } from "bootstrap";
import { Table, Tabs } from "react-bootstrap";
import MenuTable from "./MenuTable";
import { useState } from "react";
import FoodModal from "./FoodModal";

function Manager() {
  var menu = {
    breakfast: "",
    lunch: "",
    dinner: "",
    beverage: "",
  };

  return (
    <div>
      <FoodModal />
      <Modal></Modal>
      <Tabs defaultActiveKey="breakfast" className="mb-3">
        <Tab eventKey="breakfast" title="Breakfast">
          <MenuTable data={menu.breakfast} />
        </Tab>
        <Tab eventKey="lunch" title="Lunch">
          <MenuTable data={menu.lunch} />
        </Tab>
        <Tab eventKey="dinner" title="Dinner">
          <MenuTable data={menu.dinner} />
        </Tab>
        <Tab eventKey="beverage" title="Beverage">
          <MenuTable data={menu.beverage} />
        </Tab>
      </Tabs>
    </div>
  );
}

export default Manager;
