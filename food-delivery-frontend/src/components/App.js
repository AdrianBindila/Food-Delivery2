import { Link, Outlet } from "react-router-dom";
import Admin from "./Admin";
import Customer from "./Customer";
import Login from "./Login";
import Register from "./Register";
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
        <Link to="/login">Login </Link>
        <Link to="/register">Register </Link>
        <Link to="/admin">Admin </Link>
        <Link to="/customer">Customer </Link>
        <Link to="/restaurants">Restaurants </Link>
      </nav>
      <Outlet />
    </div>
  );
}

export default App;
