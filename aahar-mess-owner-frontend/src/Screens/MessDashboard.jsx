import React, { useEffect, useState } from "react";
import axios from "axios"; // For making API calls
import MessDashBoardNavbar from "../Components/messowner_components/MessDashBoardNavbar";  // Import the Navbar component
import { Card, Table, Badge } from "flowbite-react"; // Flowbite components

const MessDashBoard = () => {
  const [todayMenuItems, setTodayMenuItems] = useState([]);
  const [todayOrders, setTodayOrders] = useState([]);
  const [overviewData, setOverviewData] = useState({
    totalOrdersToday: 0,
    pendingOrders: 0,
    totalRevenueToday: 0,
    activeSubscriptions: 0,
  });

  useEffect(() => {
    // Fetch overview data
    axios.get("http://localhost:8080/api/mess/dashboard/1/overview")  // Updated URL for the overview data
      .then(response => setOverviewData(response.data))
      .catch(error => console.error("Error fetching overview data:", error));

    // Fetch today's menu items
    axios.get("http://localhost:8080/api/mess/dashboard/today-menu/1")  // Updated URL for today's menu
      .then(response => setTodayMenuItems(response.data))
      .catch(error => console.error("Error fetching today's menu:", error));

    // Fetch today's orders
    axios.get("http://localhost:8080/api/mess/dashboard/today/1")  // Updated URL for today's orders
      .then(response => setTodayOrders(response.data))
      .catch(error => console.error("Error fetching today's orders:", error));
  }, []);

  return (
    <div className="dashboard-container">
      <MessDashBoardNavbar />
      
      <main className="p-4">
        {/* Overview Cards */}
        <section className="mb-8 grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-6">
          {/* Total Orders Today */}
          <Card className="bg-white shadow-lg rounded-lg p-4  hover:bg-gray-100 dark:hover:bg-gray-700 transition-all">
            <h3 className="text-lg font-medium text-gray-600">Total Orders Today</h3>
            <p className="text-3xl font-bold text-center text-blue-500">{overviewData.totalOrdersToday}</p>
          </Card>
          
          {/* Pending Orders */}
          <Card className="bg-white shadow-lg rounded-lg p-4  hover:bg-gray-100 dark:hover:bg-gray-700 transition-all">
            <h3 className="text-lg font-medium text-gray-600">Pending Orders</h3>
            <p className="text-3xl font-bold text-center text-yellow-500">{overviewData.pendingOrders}</p>
          </Card>

          {/* Total Revenue Today */}
          <Card className="bg-white shadow-lg rounded-lg p-4 hover:bg-gray-100 dark:hover:bg-gray-700 transition-all">
            <h3 className="text-lg font-medium text-gray-600">Total Revenue Today</h3>
            <p className="text-3xl font-bold text-center text-green-500">₹{overviewData.totalRevenueToday}</p>
          </Card>

          {/* Active Subscriptions */}
          <Card className="bg-white shadow-lg rounded-lg p-4  hover:bg-gray-100 dark:hover:bg-gray-700 transition-all">
            <h3 className="text-lg font-medium text-gray-600">Active Subscriptions</h3>
            <p className="text-3xl font-bold text-center text-purple-500">{overviewData.activeSubscriptions}</p>
          </Card>
        </section>

        {/* Today's Menu */}
        <section className="mb-8">
          <h2 className="text-2xl font-semibold mb-4 text-center">Today's Menu</h2>
          <Card className="bg-white shadow-lg p-4 max-w-5xl mx-auto">
            {todayMenuItems.length ? (
              <Table>
                <Table.Head>
                  <Table.HeadCell>Dish Name</Table.HeadCell>
                  <Table.HeadCell>Price</Table.HeadCell>
                  <Table.HeadCell>Meal Type</Table.HeadCell>
                </Table.Head>
                <Table.Body>
                  {todayMenuItems.map((item, index) => (
                    <Table.Row key={index} className="hover:bg-gray-100 dark:hover:bg-gray-700 transition-all">
                      <Table.Cell>{item.dishName}</Table.Cell>
                      <Table.Cell>₹{item.price}</Table.Cell>
                      <Table.Cell>{item.mealType}</Table.Cell>
                    </Table.Row>
                  ))}
                </Table.Body>
              </Table>
            ) : (
              <p>No menu items for today.</p>
            )}
          </Card>
        </section>

        {/* Today's Orders */}
        <section>
          <h2 className="text-2xl font-semibold mb-4 text-center">Today's Orders</h2>
          <Card className="bg-white shadow-lg p-4 max-w-5xl mx-auto">
            {todayOrders.length ? (
              <Table>
                <Table.Head>
                  <Table.HeadCell>Customer</Table.HeadCell>
                  <Table.HeadCell>Status</Table.HeadCell>
                  <Table.HeadCell>Order Details</Table.HeadCell>
                </Table.Head>
                <Table.Body>
                  {todayOrders.map((order, index) => (
                    <Table.Row key={index} className="hover:bg-gray-100 dark:hover:bg-gray-700 transition-all">
                      <Table.Cell>{order.userName}</Table.Cell>
                      <Table.Cell>
                        <Badge color={order.orderStatus === "PENDING" ? "warning" : order.orderStatus === "CONFIRMED" ? "info" : "success"}>
                          {order.orderStatus}
                        </Badge>
                      </Table.Cell>
                      <Table.Cell>
                        <ul>
                          {order.orderItems.map((item, itemIdx) => (
                            <li key={itemIdx}>
                              {item.dishName} x {item.quantity} - ₹{item.price * item.quantity}
                            </li>
                          ))}
                        </ul>
                      </Table.Cell>
                    </Table.Row>
                  ))}
                </Table.Body>
              </Table>
            ) : (
              <p>No orders for today.</p>
            )}
          </Card>
        </section>
      </main>
    </div>
  );
};

export default MessDashBoard;
