import { Button, Table } from "react-bootstrap";
function Orders() {
  return (
    <Table>
      <thead>
        <tr>
          <th>Restaurant</th>
          <th>Price</th>
          <th>Date</th>
          <th>Status</th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>Bellagio</td>
          <td>25</td>
          <td>3.12.2022</td>
          <td></td>
          <td>Pending</td>
          <td>
            {/* if status is pending */}
            <Button>
              <span className="material-icons">done</span>
            </Button>
            <Button>
              <span className="material-icons">close</span>
            </Button>
            {/* otherwise */}
            <Button>
              <span class="material-icons">arrow_forward_ios</span>
            </Button>
          </td>
        </tr>
      </tbody>
    </Table>
  );
}

export default Orders;
