import React from "react";
import { Link } from "react-router-dom";

function Sidebar() {
  return (
    <div className="sidebar bg-purple-200 h-full p-4">
      <h2 className="text-lg font-bold mb-6">DASHBOARD</h2>
      <ul className="space-y-4">
        <li><Link to="/manage-orders" className="link">Manage Orders</Link></li>
        <li><Link to="/manage-delivery" className="link">Manage Delivery</Link></li>
        <li><Link to="/manage-staff" className="link">Manage Staff</Link></li>
        <li><Link to="/manage-location" className="link">Manage Location</Link></li>
        <li><Link to="/manage-users" className="link">Manage Users</Link></li>
        <li><Link to="/profile" className="link">Profile</Link></li>
        <li><Link to="/login" className="link">Logout</Link></li>
      </ul>
    </div>
  );
}

export default Sidebar;