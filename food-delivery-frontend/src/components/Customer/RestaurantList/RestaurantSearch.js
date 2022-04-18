import {
  Button,
  Form,
  FormControl,
  FormGroup,
  InputGroup,
} from "react-bootstrap";
import { useState } from "react";

function RestaurantSearch() {
  const [search, setSearch] = useState("");

  function handleChange(event) {
    const value = event.target.value;
    setSearch(value);
  }

  function handleSubmit() {
    //search in the array of restaurants
    const restaurants = JSON.parse(sessionStorage.getItem("restaurantList"));
    restaurants.filter((restaurant) => {
      return restaurant.name.includes(search);
    });
  }

  return (
    <Form className="d-flex input-group w-auto">
      <FormGroup>
        <FormControl
          type="search"
          className="form-control"
          placeholder="Type query"
          name="search"
          aria-label="Search"
          value={search}
          onChange={handleChange}
        />
      </FormGroup>
      <Button color="primary">Search</Button>
    </Form>
  );
}

export default RestaurantSearch;
