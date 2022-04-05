import { useState } from "react";
import { Button, Table } from "react-bootstrap";
import { menu } from "../../api/customerAPI";

function MenuTable() {
  const items = menu;
  return (
    <Table>
      <thead>
        <tr>
          <th>Name</th>
          <th>Description</th>
          <th>Price</th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        {items.map((item, index) => {
          return (
            <tr key={index}>
              <td>{item.name}</td>
              <td>{item.description}</td>
              <td>{item.price}</td>
              <td>
                <Button onClick={() => console.log(item.name)}>
                  <span class="material-icons">add</span>
                </Button>
              </td>
            </tr>
          );
        })}
      </tbody>
    </Table>
  );
}
export default MenuTable;
