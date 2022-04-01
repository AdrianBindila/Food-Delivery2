import { useState } from "react";
import { Table } from "react-bootstrap";
import { menu } from "../../../api/adminAPI";

function Menu(props) {
  return (
    <Table>
      <thead>
        <tr>
          <th>Name</th>
          <th>Description</th>
          <th>Price</th>
        </tr>
      </thead>
      <tbody>
        {menu
          .filter((item) => {
            return item.category.toLowerCase() === props.category;
          })
          .map((item) => {
            return (
              <tr key={item.index}>
                <td>{item.name}</td>
                <td>{item.description}</td>
                <td>{item.price}</td>
              </tr>
            );
          })}
      </tbody>
    </Table>
  );
}

export default Menu;
