import { Table } from "react-bootstrap";
import { restaurantList } from "../../api/customerAPI";

function RestaurantList() {
  return (
    <div>
      <Table>
        <thead>
          <tr>
            <th>Name</th>
            <th>Address</th>
            <th>Delivery Zones</th>
          </tr>
        </thead>
        <tbody>
          {restaurantList.map((item, index) => {
            return (
              <tr key={index}>
                <td>{item.name}</td>
                <td>{item.address}</td>
                <td>{item.deliveryZones}</td>
              </tr>
            );
          })}
        </tbody>
      </Table>
    </div>
  );
}
export default RestaurantList;
