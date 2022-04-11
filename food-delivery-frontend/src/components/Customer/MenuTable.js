import {Button, Table} from "react-bootstrap";
import {menu} from "../../api/customerAPI";

function MenuTable() {
    return (
        <Table>
            <thead>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th/>
            </tr>
            </thead>
            <tbody>
            {menu.map((item, index) => {
                return (
                    <tr key={index}>
                        <td>{item.name}</td>
                        <td>{item.description}</td>
                        <td>{item.price}</td>
                        <td>
                            <Button onClick={() => console.log(item.name)}>
                                <span className="material-icons">add</span>
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
