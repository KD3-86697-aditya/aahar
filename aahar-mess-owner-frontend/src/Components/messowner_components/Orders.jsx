import React, { useEffect, useState } from "react";
import axios from "axios";
import { Card, Table } from "flowbite-react";

const Orders = () => {
  const [allOrders, setAllOrders] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/messes/allOrders")
      .then(response => setAllOrders(response.data))
      .catch(error => console.error("Error fetching all orders:", error));
  }, []);

  return (
    <div className="all-orders-container p-4">
      <h2 className="text-2xl font-semibold mb-4">All Orders</h2>
      <Card className="bg-white shadow-lg p-4">
        {allOrders.length ? (
          <Table>
            <Table.Head>
              <Table.HeadCell>Order ID</Table.HeadCell>
              <Table.HeadCell>Customer</Table.HeadCell>
              <Table.HeadCell>Status</Table.HeadCell>
              <Table.HeadCell>Date</Table.HeadCell>
            </Table.Head>
            <Table.Body>
              {allOrders.map((order, index) => (
                <Table.Row key={index}>
                  <Table.Cell>{order.orderId}</Table.Cell>
                  <Table.Cell>{order.customer}</Table.Cell>
                  <Table.Cell>{order.status}</Table.Cell>
                  <Table.Cell>{new Date(order.date).toLocaleDateString()}</Table.Cell>
                </Table.Row>
              ))}
            </Table.Body>
          </Table>
        ) : (
          <p>No orders found.</p>
        )}
      </Card>
    </div>
  );
};

export default Orders;
