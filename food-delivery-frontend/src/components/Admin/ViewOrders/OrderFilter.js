import { useState } from "react";
import { Dropdown, DropdownButton } from "react-bootstrap";
import DropdownItem from "react-bootstrap/esm/DropdownItem";

function OrderFilter(props) {
  return (
    <DropdownButton id="dropdown-basic-button" title="Filter Orders By Status">
      <DropdownItem
        as="button"
        onClick={() => props.filter(props.status.pending)}
      >
        Pending
      </DropdownItem>
      <DropdownItem
        as="button"
        onClick={() => props.filter(props.status.accepted)}
      >
        Accepted
      </DropdownItem>
      <DropdownItem
        as="button"
        onClick={() => props.filter(props.status.in_delivery)}
      >
        In Delivery
      </DropdownItem>
      <DropdownItem
        as="button"
        onClick={() => props.filter(props.status.delivered)}
      >
        Delivered
      </DropdownItem>
      <DropdownItem
        as="button"
        onClick={() => props.filter(props.status.declined)}
      >
        Declined
      </DropdownItem>
    </DropdownButton>
  );
}
export default OrderFilter;
