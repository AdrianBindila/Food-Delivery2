import {
  Button,
  Form,
  FormControl,
  FormGroup,
  InputGroup,
} from "react-bootstrap";
import { useState } from "react";

function RestaurantSearch(props) {
  function handleChange(event) {
    const value = event.target.value;
    props.setSearch(value);
  }

  return (
    <Form className="d-flex input-group w-auto" onSubmit={props.handleSubmit}>
      <FormGroup>
        <FormControl
          type="search"
          className="form-control"
          placeholder="Type query"
          name="search"
          aria-label="Search"
          value={props.search}
          onChange={handleChange}
        />
      </FormGroup>
      <Button color="primary" type="submit">
        Search
      </Button>
    </Form>
  );
}

export default RestaurantSearch;
