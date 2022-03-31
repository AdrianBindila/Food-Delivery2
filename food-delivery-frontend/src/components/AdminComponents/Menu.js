import { useState } from "react";
import { Button, Table } from "react-bootstrap";
import {getMenu} from "../../api/adminAPI";

function Menu() {
  const [items, setItems] = useState();
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
        <tr>
          <td>Pasta</td>
          <td>Delicious pasta</td>
          <td>35</td>
        </tr>
      </tbody>
    </Table>
  );
}
export default Menu;
