import { Route, Routes, Navigate } from "react-router-dom";
import { useState } from "react";
import "./App.css";
import Home from "./Screens/Home";
import Sidebar from "./Components/Sidebar";
import { ToastContainer } from "react-toastify";
import MessRegistration from "./Screens/MessRegistration";
import MessDashboard from "./Screens/MessDashboard";
import AdminDashboard from "./Components/admin_components/AdminDashboard";
import Login from "./Screens/Login";
import Registration from "./Screens/Registration";
import ManageOrders from "./Screens/ManageOrders";
import ManageMenu from "./Screens/ManageMenu";
import MessProfile from "./Screens/MessProfile";
import OrderDetails from "./Screens/OrderDetails";
import SubscriptionPlans from "./Screens/SubscriptionPlans";

function App() {
  // Authentication state
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  // Function to handle login
  const handleLogin = () => {
    setIsLoggedIn(true);
  };

  // Function to handle logout
  const handleLogout = () => {
    setIsLoggedIn(false);
  };

  return (
    <div className="container-fluid" style={{ textAlign: "center" }}>
      <ToastContainer />

      <Routes>
        {/* Public Routes */}
        <Route path="/" element={<Login onLogin={handleLogin} />} />
        <Route path="login" element={<Login onLogin={handleLogin} />} />

        <Route path="register"  element={<Registration/>}></Route>

        {/* <Route path="register" element={<AdminRegistration />} /> */}
        <Route path="home" element={<Home />} />
        <Route path="messregister" element={<MessRegistration/>}></Route>
        <Route path="/mess-owner-dashboard" element={<MessDashboard/>}></Route>
        <Route path="/manage-menu" element={<ManageMenu/>}></Route>

        <Route path="/manage-orders" element={<ManageOrders/>}></Route>
        <Route path="/manage-plans" element={<SubscriptionPlans/>}></Route>

        <Route path="/orders/:orderId" element={<OrderDetails/>} /> {/* Add this route */}

        <Route path="/mess-profile" element={<MessProfile/>}   ></Route>




        {/* Protected Routes */}

      </Routes>
    </div>
  );
}

export default App;