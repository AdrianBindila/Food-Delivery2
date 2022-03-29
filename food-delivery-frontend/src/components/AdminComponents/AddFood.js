import { useState } from "react";
import { Button, Form } from "react-bootstrap";

function AddFood(props) {
  const [food, setFood] = useState({
    name: "",
    description: "",
    price: "",
    category: "",
  });

  function handleChange(event) {
    const { name, value } = event.target;
    setFood((prevFood) => {
      return {
        ...prevFood,
        [name]: value,
      };
    });
  }
  function handleSubmit(event) {
    props.setShow(false);
    props.sendFood(food);
    event.preventDefault();
  }
  return (
    <Form onSubmit={handleSubmit}>
      <Form.Group className="mb-3">
        <Form.Label>Name</Form.Label>
        <Form.Control
          placeholder="Name"
          name="name"
          value={food.name}
          onChange={handleChange}
        />
      </Form.Group>
      <Form.Group className="mb-3">
        <Form.Label>Description</Form.Label>
        <Form.Control
          placeholder="Description"
          name="description"
          value={food.description}
          onChange={handleChange}
        />
      </Form.Group>
      <Form.Group className="mb-3">
        <Form.Label>Price</Form.Label>
        <Form.Control
          placeholder="Price"
          name="price"
          value={food.price}
          onChange={handleChange}
        />
      </Form.Group>
      <Form.Group className="mb-3">
        <Form.Select
          aria-label="Default select example"
          name="category"
          value={food.category}
          onChange={handleChange}
        >
          <option>Category</option>
          <option value="breakfast">Breakfast</option>
          <option value="lunch">Lunch</option>
          <option value="dessert">Dessert</option>
          <option value="beverage">Beverage</option>
        </Form.Select>
      </Form.Group>
      <Button variant="secondary">Close</Button>
      <Button variant="primary" type="submit" onClick={handleSubmit}>
        Add
      </Button>
    </Form>
  );
}
export default AddFood;
