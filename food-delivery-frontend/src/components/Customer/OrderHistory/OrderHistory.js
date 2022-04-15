import Orders from "../Orders"
import {getOrdersHistory} from "../../../api/customerAPI";
import {useEffect, useState} from "react";

function OrderHistory() {
    const [orders,setOrders] = useState([]);
    let user = JSON.parse(sessionStorage.getItem("user"));//not the cleanest approach
    getOrdersHistory(user.username);

    useEffect(() => {
        setOrders(JSON.parse(sessionStorage.getItem("customerOrderHistory")));
    }, []);

    return (<div>
        <Orders orders={orders}/>
    </div>);
}

export default OrderHistory;