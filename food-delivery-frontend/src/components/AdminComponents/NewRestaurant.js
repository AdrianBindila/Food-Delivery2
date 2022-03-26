import {Button, Card, Form} from "react-bootstrap";

function NewRestaurant() {
    //after entering the restaurant, go to its menu
    return (

            <Form>
                <Form.Group className="mb-3">
                    <Form.Label>Name</Form.Label>
                    <Form.Control type="name" placeholder="Name"/>
                </Form.Group>

                <Form.Group className="mb-3">
                    <Form.Label>Address</Form.Label>
                    <Form.Control type="address" placeholder="Address"/>
                </Form.Group>

                <Form.Group className="mb-3">
                    <Form.Label>Delivery Zones</Form.Label>
                    <Form.Control type="deliveryZone" placeholder="Delivery Zones"/>
                </Form.Group>

                <Button variant="primary" type="submit">
                    Add
                </Button>
            </Form>

    );
}

export default NewRestaurant;