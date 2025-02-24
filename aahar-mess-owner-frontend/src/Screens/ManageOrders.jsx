import React, { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import MessDashboardNavbar from "../Components/messowner_components/MessDashBoardNavbar";

const ManageOrders = () => {
  const [orders, setOrders] = useState([]);
  const [loading, setLoading] = useState(true);
  const navigate = useNavigate();

  // Assuming messOwnerId is stored in localStorage after login
  const messOwnerId = 1;

  useEffect(() => {
    if (!messOwnerId) return;

    axios
      .get(`http://localhost:8080/orders/mess/${messOwnerId}`)
      .then((response) => {
        // Transform API response
        const transformedOrders = response.data.map((order) => ({
          id: order.orderId, // Change orderId to id
          userName: order.username, // Change username to userName
          orderDate: order.orderPlacedAt, // Change orderPlacedAt to orderDate
          status: order.orderStatus, // Change orderStatus to status
          totalItems: order.orderItems.reduce((sum, item) => sum + item.quantity, 0),
          totalPrice: order.orderItems.reduce((sum, item) => sum + item.quantity * item.price, 0),
          city: order.location.city, // Add city
          state: order.location.state, // Add state
          pincode: order.location.pincode, // Add pincode
        }));

        // Sort by pending first, then by date (descending)
        const sortedOrders = transformedOrders.sort((a, b) => {
          if (a.status === "PENDING" && b.status !== "PENDING") return -1;
          if (a.status !== "PENDING" && b.status === "PENDING") return 1;
          return new Date(b.orderDate) - new Date(a.orderDate);
        });

        setOrders(sortedOrders);
        setLoading(false);
      })
      .catch((error) => {
        console.error("Error fetching orders:", error);
        setLoading(false);
      });
  }, [messOwnerId]);

  const handleStatusUpdate = (orderId, newStatus) => {
    axios
      .put(`http://localhost:8080/orders/${orderId}/status`, { status: newStatus })
      .then(() => {
        setOrders((prevOrders) =>
          prevOrders.map((order) =>
            order.id === orderId ? { ...order, status: newStatus } : order
          )
        );
      })
      .catch((error) => console.error("Error updating order status:", error));
  };

  return (
    <div>
      <MessDashboardNavbar />
      <h2 className="text-2xl font-bold mb-4">Manage Orders</h2>

      {loading ? (
        <p>Loading...</p>
      ) : orders.length === 0 ? (
        <p>No orders found.</p>
      ) : (
        <table className="w-full border-collapse border border-gray-300">
          <thead>
            <tr className="bg-gray-200">
              <th className="border p-2">Order ID</th>
              <th className="border p-2">User</th>
              <th className="border p-2">Total Items</th>
              <th className="border p-2">Total Price</th>
              <th className="border p-2">Order Date</th>
              <th className="border p-2">City</th>
              <th className="border p-2">State</th>
              <th className="border p-2">Pincode</th>
              <th className="border p-2">Status</th>
              <th className="border p-2">Actions</th>
            </tr>
          </thead>
          <tbody>
            {orders.map((order) => (
              <tr key={order.id} className="text-center">
                <td className="border p-2">{order.id}</td>
                <td className="border p-2">{order.userName}</td>
                <td className="border p-2">{order.totalItems}</td>
                <td className="border p-2">₹{order.totalPrice}</td>
                <td className="border p-2">{new Date(order.orderDate).toLocaleDateString()}</td>
                <td className="border p-2">{order.city}</td>
                <td className="border p-2">{order.state}</td>
                <td className="border p-2">{order.pincode}</td>
                <td className="border p-2">{order.status}</td>
                <td className="border p-2">
                  {/* {order.status === "CONFIRMED" && (
                    <button
                      onClick={() => handleStatusUpdate(order.id, "DELIVERED")}
                      className="bg-blue-500 text-white px-3 py-1 rounded"
                    >
                      Deliver
                    </button>
                  )} */}
                  <button
                    onClick={() => navigate(`/orders/${order.id}`, { state: { order } })}
                    className="bg-gray-500 text-white px-3 py-1 rounded ml-2"
                  >
                    View Details
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
};

export default ManageOrders;
