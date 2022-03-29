import { useState } from "react";
import { Button, Table } from "react-bootstrap";

function MenuTable() {
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
export default MenuTable;
