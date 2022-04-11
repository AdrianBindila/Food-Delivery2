import {Button, Form} from "react-bootstrap";
import {useState} from "react";
import {useNavigate} from "react-router";
import {sendRestaurant} from "../../../api/adminAPI";

function RestaurantForm() {
    const navigate = useNavigate();
    const [restaurant, setRestaurant] = useState({
        name: "",
        address: "",
        deliveryZones: "",
    });

    function handleChange(event) {
        const {name, value} = event.target;
        setRestaurant((prevState) => {
            return {
                ...prevState,
                [name]: value,
            };
        });
    }

    function handleSubmit(event) {
        sendRestaurant(restaurant).then(() => {
                setRestaurant({
                    name: "",
                    address: "",
                    deliveryZones: "",
                });
                navigate("/admin/manage-restaurant");
                event.preventDefault();
            }
        )
    }

    return (
        <Form onSubmit={handleSubmit}>
            <Form.Group className="mb-3">
                <Form.Label>Name</Form.Label>
                <Form.Control
                    type="name"
                    placeholder="Name"
                    name="name"
                    value={restaurant.name}
                    onChange={handleChange}
                />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Address</Form.Label>
                <Form.Control
                    type="address"
                    placeholder="Address"
                    name="address"
                    value={restaurant.address}
                    onChange={handleChange}
                />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Delivery Zones</Form.Label>
                <Form.Control
                    type="deliveryZone"
                    placeholder="Delivery Zones"
                    name="deliveryZones"
                    value={restaurant.deliveryZones}
                    onChange={handleChange}
                />
            </Form.Group>
            <Button variant="primary" type="submit">
                Add
            </Button>
        </Form>
    );
}

export default RestaurantForm;
