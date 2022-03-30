import { useState } from "react";
import { Button, Modal } from "react-bootstrap";
import AddFood from "./AddFood";

function FoodModal(props) {
  const [show, setShow] = useState(false);

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);
  function sendFood(food) {
    //console.log(food);
    props.onAdd(food);

    //send food to request - use a prop
  }
  return (
    <>
      <Button variant="primary" onClick={handleShow}>
        AddFood
      </Button>

      <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Add Food</Modal.Title>
        </Modal.Header>

        <Modal.Body>
          <AddFood show={show} setShow={setShow} sendFood={sendFood} />
        </Modal.Body>
      </Modal>
    </>
  );
}
export default FoodModal;
