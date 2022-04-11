import {useState} from "react";
import {Button, Modal} from "react-bootstrap";
import {sendFood} from "../../../api/adminAPI";
import AddFood from "./AddFood";

function FoodModal(props) {
    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    function handleAdd(food) {
        sendFood(food);
        props.onAdd(food);
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
                    <AddFood show={show} setShow={setShow} sendFood={handleAdd}/>
                </Modal.Body>
            </Modal>
        </>
    );
}

export default FoodModal;
