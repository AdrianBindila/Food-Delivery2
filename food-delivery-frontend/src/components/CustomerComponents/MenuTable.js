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
          <th></th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>1</td>
          <td>2</td>
          <td>3</td>
          <td>
            <Button>
              <span class="material-icons">add</span>
            </Button>
          </td>
        </tr>
      </tbody>
    </Table>
  );
}
export default MenuTable;
