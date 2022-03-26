import {Link, Outlet} from "react-router-dom";

function App() {
    return (
        <div>
            <h1>Food panda</h1>
            <nav
                style={{
                    borderBottom: "solid 1px",
                    paddingBottom: "1rem",
                }}
            >
                <Link to="/login">Login |</Link>
                <Link to="/register">Register |</Link>
                <Link to="/admin">Admin |</Link>
                <Link to="/customer">Customer |</Link>
                <Link to="/customer/cart">Cart |</Link>
                <Link to="/customer/current-order">Current Order |</Link>
                <Link to="/customer/order-history">Order History </Link>
            </nav>
            <Outlet/>
        </div>
    );
}

export default App;
