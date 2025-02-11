import React from "react";
import { useNavigate } from "react-router-dom";
import { images } from "../../constants";

const Dashboard = () => {
  const navigate = useNavigate();

  const handleLogout = () => {
    localStorage.removeItem("isAdminAuthenticated"); 
    navigate("/AdminLogin"); 
  };

  return (
    <div className="flex flex-col items-center justify-center min-h-screen bg-gray-100 p-4">
      <div className="relative w-full max-w-3xl bg-white p-6 shadow-lg rounded-lg">
        
        <div className="absolute top-4 right-4">
          <img src={images.aahar} alt="Logo" className="w-16 h-16" />
        </div>

        <h2 className="text-xl font-bold mb-6 text-center">Admin Dashboard</h2>

       
        <div className="grid grid-cols-3 gap-4">
          <button className="p-4 bg-gray-200 border border-black text-center rounded-lg hover:bg-gray-300"onClick={() => navigate("/ManageOrders")}>
            MANAGE ORDERS
          </button>
          <button className="p-4 bg-gray-200 border border-black text-center rounded-lg hover:bg-gray-300" onClick={() => navigate("/ManageStaff")} >
            MANAGE STAFF
          </button>
          <button className="p-4 bg-gray-200 border border-black text-center rounded-lg hover:bg-gray-300" onClick={() => navigate("/ManageLocation")} >
            MANAGE LOCATION
          </button>
          <button className="p-4 bg-gray-200 border border-black text-center rounded-lg hover:bg-gray-300 col-span-1" onClick={() => navigate("/ManageMessList")}>
            MANAGE MESS
          </button>
          <button className="p-4 bg-gray-200 border border-black text-center rounded-lg hover:bg-gray-300 col-span-1" onClick={() => navigate("/ManageUser")}>
            MANAGE USERS
          </button>
        </div>

        
        <button
          onClick={handleLogout}
          className="absolute bottom-4 right-4 text-red-600 font-semibold hover:underline"
        >
          LOGOUT
        </button>
      </div>
    </div>
  );
};

export default Dashboard;
