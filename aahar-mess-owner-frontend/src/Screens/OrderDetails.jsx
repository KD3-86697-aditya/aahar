import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import MessDashboardNavbar from "../Components/messowner_components/MessDashBoardNavbar";
import axios from "axios";

const OrderDetails = () => {
  const { orderId } = useParams();
  const navigate = useNavigate();
  const [order, setOrder] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchOrder = async () => {
      try {
        const { data } = await axios.get(`http://localhost:8080/orders/${orderId}`);
        setOrder(data);
      } catch (err) {
        console.error("Error fetching order:", err);
        setError(err.message || "Failed to load order details.");
      } finally {
        setLoading(false);
      }
    };

    fetchOrder();
  }, [orderId]);

  const handleStatusUpdate = async (newStatus) => {
    try {
      setLoading(true);
      await axios.put(`http://localhost:8080/orders/${orderId}/status?status=${newStatus}`);

      // Redirect back to Manage Orders after update
      navigate("/manage-orders");
    } catch (error) {
      setError("Error updating order status. Please try again.");
      console.error("Error updating order status:", error);
    } finally {
      setLoading(false);
    }
  };

  if (loading) return <p className="text-blue-500">Loading order details...</p>;
  if (error) return <p className="text-red-500">{error}</p>;
  if (!order) return <p className="text-red-500">Order not found.</p>;

  return (
    <div>
      <MessDashboardNavbar />
      <div className="max-w-3xl mx-auto mt-6 p-6 border rounded-lg shadow-lg">
        <h2 className="text-2xl font-bold mb-4">Order Details</h2>

        <p><strong>Order ID:</strong> {order.orderId}</p>
        <p><strong>User:</strong> {order.username}</p>
        <p><strong>Order Date:</strong> {new Date(order.orderPlacedAt).toLocaleString()}</p>
        <p><strong>Status:</strong> {order.orderStatus}</p>

        <h3 className="text-xl font-semibold mt-4">Ordered Items</h3>
        <table className="w-full border-collapse border border-gray-300 mt-2">
          <thead>
            <tr className="bg-gray-200">
              <th className="border p-2">Dish Name</th>
              <th className="border p-2">Quantity</th>
              <th className="border p-2">Price (₹)</th>
              <th className="border p-2">Total (₹)</th>
            </tr>
          </thead>
          <tbody>
            {order.orderItems?.length > 0 ? (
              order.orderItems.map((item, index) => (
                <tr key={index} className="text-center">
                  <td className="border p-2">{item.dishName}</td>
                  <td className="border p-2">{item.quantity}</td>
                  <td className="border p-2">{item.price}</td>
                  <td className="border p-2">{(item.quantity * item.price).toFixed(2)}</td>
                </tr>
              ))
            ) : (
              <tr>
                <td colSpan="4" className="border p-2 text-center text-gray-500">
                  No items found
                </td>
              </tr>
            )}
          </tbody>
        </table>

        <p className="mt-4"><strong>Total Items:</strong> {order.orderItems?.length || 0}</p>
        <p><strong>Total Price:</strong> ₹{order.orderItems?.reduce((total, item) => total + (item.quantity * item.price), 0).toFixed(2) || 0}</p>

        <div className="mt-4">
          {order.orderStatus === "PENDING" && (
            <button
              onClick={() => handleStatusUpdate("CONFIRMED")}
              className="bg-green-500 text-white px-4 py-2 rounded mr-2"
            >
              Confirm Order
            </button>
          )}
          {order.orderStatus === "CONFIRMED" && (
            <button
              onClick={() => handleStatusUpdate("DELIVERED")}
              className="bg-blue-500 text-white px-4 py-2 rounded"
            >
              Mark as Delivered
            </button>
          )}
          {order.orderStatus === "DELIVERED" && (
            <p className="text-green-500 font-semibold mt-2">Order Delivered</p>
          )}
          <button
            onClick={() => navigate("/manage-orders")}
            className="bg-gray-500 text-white px-4 py-2 rounded ml-2"
          >
            Back to Orders
          </button>
        </div>
      </div>
    </div>
  );
};

export default OrderDetails;
