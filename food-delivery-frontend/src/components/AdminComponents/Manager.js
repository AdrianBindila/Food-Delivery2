import { Tab } from "bootstrap";
import { Tabs } from "react-bootstrap";
import Menu from "./Menu";
import FoodModal from "./FoodModal";

function Manager(props) {
  const menu = {
    breakfast: "",
    lunch: "",
    dinner: "",
    beverage: "",
  };

  return (
    <div>
      <FoodModal onAdd={props.onAdd} />
      <Tabs defaultActiveKey="breakfast" className="mb-3">
        <Tab eventKey="breakfast" title="Breakfast">
          <Menu data={menu.breakfast} />
        </Tab>
        <Tab eventKey="lunch" title="Lunch">
          <Menu data={menu.lunch} />
        </Tab>
        <Tab eventKey="dinner" title="Dinner">
          <Menu data={menu.dinner} />
        </Tab>
        <Tab eventKey="beverage" title="Beverage">
          <Menu data={menu.beverage} />
        </Tab>
      </Tabs>
    </div>
  );
}

export default Manager;
