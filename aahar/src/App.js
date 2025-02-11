import React from "react";
import { BrowserRouter as Router, Routes, Route, useNavigate, useLocation } from "react-router-dom";
import { AboutUs, FindUs, Header, Intro } from "./container";
import { Navbar, Login, AdminLoginPage, MessOwnerLoginPage, UserLoginPage, Dashboard  , ManageStaff , ManageLocation ,ManageUser ,ManageOrders , ManageMessList , ManageMessDetails} from "./components";
import "./App.css";

const ProtectedRoute = ({ children }) => {
  const navigate = useNavigate();
  const isAdminAuthenticated = localStorage.getItem("isAdminAuthenticated");

  if (!isAdminAuthenticated) {
    navigate("/AdminLogin"); // Redirect if not logged in
    return null;
  }

  return children;
};

const App = () => {
  const location = useLocation();

  return (
    <div>
      {location.pathname === "/" && <Navbar />}
      <Routes>
        <Route
          path="/"
          element={
            <>
              <Header />
              <AboutUs />
              <Intro />
              <FindUs />
            </>
          }
        />
        <Route path="/login" element={<Login />} />
        <Route path="/AdminLogin" element={<AdminLoginPage />} />
        <Route path="/MessOwnerLogin" element={<MessOwnerLoginPage />} />
        <Route path="/UserLogin" element={<UserLoginPage />} />
        <Route path="/dashboard" element={<Dashboard />} />
        <Route path="/ManageStaff" element={<ManageStaff />} />
        <Route path="/ManageLocation" element={<ManageLocation/>} />
        <Route path="/ManageUser" element={<ManageUser/>} />
        <Route path="/ManageOrders" element={<ManageOrders/>} />
        <Route path="/ManageMessList" element={<ManageMessList/>} />
        <Route path="/ManageMessDetails" element={<ManageMessDetails/>} />
      </Routes>
    </div>
  );
};

const AppWithRouter = () => (
  <Router>
    <App />
  </Router>
);

export default AppWithRouter;
