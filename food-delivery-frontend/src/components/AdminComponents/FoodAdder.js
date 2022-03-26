import {Button, Form} from "react-bootstrap";

function FoodAdder() {//make it a modal
    return (<div>
        <Form>
            <Form.Group className="mb-3">
                <Form.Label>Name</Form.Label>
                <Form.Control type="name" placeholder="Name"/>
            </Form.Group>

            <Form.Group className="mb-3">
                <Form.Label>Description</Form.Label>
                <Form.Control type="description" placeholder="Description"/>
            </Form.Group>

            <Form.Group className="mb-3">
                <Form.Label>Price</Form.Label>
                <Form.Control type="price" placeholder="Price"/>
            </Form.Group>

            <Form.Select aria-label="Default select example">
                <option>Category</option>
                <option value="breakfast">Breakfast</option>
                <option value="lunch">Lunch</option>
                <option value="dessert">Dessert</option>
                <option value="beverage">Beverage</option>
            </Form.Select>

            <Button variant="primary" type="submit">
                Add
            </Button>

            <Button variant="primary" type="submit">
                Register
            </Button>
        </Form>
    </div>);
}

export default FoodAdder;