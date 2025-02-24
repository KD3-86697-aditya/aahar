import React, { useEffect, useState } from "react";
import axios from "axios";
import { Card, Table } from "flowbite-react"; // Flowbite components

const TodaysOrders = () => {
  const [todayOrders, setTodayOrders] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/messes/todaysOrders")
      .then(response => setTodayOrders(response.data))
      .catch(error => console.error("Error fetching today's orders:", error));
  }, []);

  return (
    <div className="todays-orders-container p-4">
      <h2 className="text-2xl font-semibold mb-4">Today's Orders</h2>
      <Card className="bg-white shadow-lg p-4">
        {todayOrders.length ? (
          <Table>
            <Table.Head>
              <Table.HeadCell>Order ID</Table.HeadCell>
              <Table.HeadCell>Customer</Table.HeadCell>
              <Table.HeadCell>Status</Table.HeadCell>
            </Table.Head>
            <Table.Body>
              {todayOrders.map((order, index) => (
                <Table.Row key={index}>
                  <Table.Cell>{order.orderId}</Table.Cell>
                  <Table.Cell>{order.customer}</Table.Cell>
                  <Table.Cell>{order.status}</Table.Cell>
                </Table.Row>
              ))}
            </Table.Body>
          </Table>
        ) : (
          <p>No orders for today.</p>
        )}
      </Card>
    </div>
  );
};

export default TodaysOrders;
