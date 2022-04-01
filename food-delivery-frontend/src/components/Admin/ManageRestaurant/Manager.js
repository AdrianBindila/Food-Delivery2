import { Tab } from "bootstrap";
import { Tabs } from "react-bootstrap";
import Menu from "./Menu";
import FoodModal from "./FoodModal";

function Manager(props) {
  return (
    <div>
      <FoodModal onAdd={props.onAdd} />
      <Tabs defaultActiveKey="breakfast" className="mb-3">
        <Tab eventKey="breakfast" title="Breakfast">
          <Menu category="breakfast" />
        </Tab>
        <Tab eventKey="lunch" title="Lunch">
          <Menu category="lunch" />
        </Tab>
        <Tab eventKey="dinner" title="Dinner">
          <Menu category="dinner" />
        </Tab>
        <Tab eventKey="beverage" title="Beverage">
          <Menu category="beverage" />
        </Tab>
      </Tabs>
    </div>
  );
}

export default Manager;
