import {useEffect, useState} from "react";
import {getOrdersHistory, getPendingOrders} from "../../api/customerAPI";
import Orders from "./Orders";

function PendingOrders() {
    const [orders,setOrders] = useState(JSON.parse(sessionStorage.getItem("customerPendingOrders")));
    let user = JSON.parse(sessionStorage.getItem("user"));//not the cleanest approach
    getPendingOrders(user.username);
    useEffect(()=>{
        setOrders(JSON.parse(sessionStorage.getItem("customerPendingOrders")));
    },[]);



    return (<div>
        <Orders orders={orders}/>
    </div>);
}

export default PendingOrders;