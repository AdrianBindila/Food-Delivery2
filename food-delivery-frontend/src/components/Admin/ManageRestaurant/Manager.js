import { Tab } from "bootstrap";
import { Tabs } from "react-bootstrap";
import Menu from "./Menu";
import FoodModal from "./FoodModal";
import { useState } from "react";
import { menu } from "../../../api/adminAPI";

function Manager() {
  const [menuFood, setMenu] = useState(menu);
  function onAdd(item) {
    setMenu((prevMenu) => [...prevMenu, item]);
  }
  return (
    <div>
      <FoodModal onAdd={onAdd} />
      <Tabs defaultActiveKey="breakfast" className="mb-3">
        <Tab eventKey="breakfast" title="Breakfast">
          <Menu category="breakfast" menu={menuFood} />
        </Tab>
        <Tab eventKey="lunch" title="Lunch">
          <Menu category="lunch" menu={menuFood} />
        </Tab>
        <Tab eventKey="dessert" title="Dessert">
          <Menu category="dessert" menu={menuFood} />
        </Tab>
        <Tab eventKey="beverage" title="Beverage">
          <Menu category="beverage" menu={menuFood} />
        </Tab>
      </Tabs>
    </div>
  );
}

export default Manager;
