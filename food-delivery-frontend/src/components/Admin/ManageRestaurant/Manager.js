import { Tab } from "bootstrap";
import { Tabs } from "react-bootstrap";
import Menu from "./Menu";
import FoodModal from "./FoodModal";
import { useState } from "react";
import _ from "lodash";
import PDFExportButton from "./PDFExportButton";

function Manager() {
  const [menu, setMenu] = useState(JSON.parse(sessionStorage.getItem("menu")));

  function onAdd(item) {
    setMenu((prevMenu) => [...prevMenu, item]);
  }
  const categories = ["breakfast", "lunch", "dessert", "beverage"];

  return (
    <>
      <PDFExportButton menu={menu} />
      <FoodModal onAdd={onAdd} />
      <Tabs defaultActiveKey={categories[0]} className="mb-3">
        {categories.map((category) => {
          return (
            <Tab eventKey={category} title={_.startCase(category)}>
              <Menu
                menu={
                  menu &&
                  menu.filter((item) => {
                    return item.category.toLowerCase() === category;
                  })
                }
              />
            </Tab>
          );
        })}
      </Tabs>
    </>
  );
}

export default Manager;
