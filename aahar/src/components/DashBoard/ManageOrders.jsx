import React, { useEffect, useState } from "react";
import axios from "axios";

const ManageOrders = () => {
  const [orders, setOrders] = useState([]);
  const [staffMembers, setStaffMembers] = useState([]);
  const [assignedStaff, setAssignedStaff] = useState({});

  useEffect(() => {
    fetchOrders();
    fetchStaffMembers();
  }, []);

  const fetchOrders = async () => {
    try {
      const response = await axios.get("http://localhost:8080/orders");
      setOrders(response.data);
    } catch (error) {
      console.error("Error fetching orders", error);
    }
  };

  const fetchStaffMembers = async () => {
    try {
      const response = await axios.get("http://localhost:8080/staff");
      setStaffMembers(response.data);
    } catch (error) {
      console.error("Error fetching staff members", error);
    }
  };

  const assignStaff = (orderId, staffId) => {
    setAssignedStaff({ ...assignedStaff, [orderId]: staffId });
  };

  const deleteOrder = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/orders/${id}`);
      setOrders(orders.filter(order => order.id !== id));
    } catch (error) {
      console.error("Error deleting order", error);
    }
  };

  return (
    <div className="p-4">
      <div className="flex items-center mb-4">
        <img src="/logo.png" alt="Logo" className="w-12 h-12 mr-4" />
        <h1 className="text-2xl font-bold">Manage Orders</h1>
      </div>
      <table className="min-w-full bg-white border border-gray-200">
        <thead>
          <tr className="bg-gray-100">
            <th className="border px-4 py-2">ID</th>
            <th className="border px-4 py-2">User</th>
            <th className="border px-4 py-2">Mess</th>
            <th className="border px-4 py-2">Order Placed At</th>
            <th className="border px-4 py-2">Delivery Time</th>
            <th className="border px-4 py-2">Status</th>
            <th className="border px-4 py-2">Assign Staff</th>
            <th className="border px-4 py-2">Actions</th>
          </tr>
        </thead>
        <tbody>
          {orders.map((order) => (
            <tr key={order.id} className="text-center">
              <td className="border px-4 py-2">{order.id}</td>
              <td className="border px-4 py-2">{order.user.name}</td>
              <td className="border px-4 py-2">{order.mess.name}</td>
              <td className="border px-4 py-2">{order.orderPlacedAt}</td>
              <td className="border px-4 py-2">{order.deliveryDeliveredAt || "Pending"}</td>
              <td className="border px-4 py-2">{order.orderStatus}</td>
              <td className="border px-4 py-2">
                <select
                  className="border p-1"
                  onChange={(e) => assignStaff(order.id, e.target.value)}
                  value={assignedStaff[order.id] || ""}
                >
                  <option value="">Select Staff</option>
                  {staffMembers.map((staff) => (
                    <option key={staff.id} value={staff.id}>{staff.name}</option>
                  ))}
                </select>
              </td>
              <td className="border px-4 py-2">
                <button
                  className="bg-red-500 text-white px-4 py-1 rounded"
                  onClick={() => deleteOrder(order.id)}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ManageOrders;
