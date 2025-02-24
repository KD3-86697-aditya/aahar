import React, { useEffect, useState } from "react";
import axios from "axios";
import { Card, Table } from "flowbite-react"; // Flowbite components

const TodaysMenu = () => {
  const [todayMenuItems, setTodayMenuItems] = useState([]);

  useEffect(() => {
    // Fetch today's menu items
    axios.get("http://localhost:8080/messes/todaysMenu")
      .then(response => setTodayMenuItems(response.data))
      .catch(error => console.error("Error fetching today's menu:", error));
  }, []);

  return (
    <div className="todays-menu-container p-4">
      <h2 className="text-2xl font-semibold mb-4">Today's Menu</h2>
      <Card className="bg-white shadow-lg p-4">
        {todayMenuItems.length ? (
          <Table>
            <Table.Head>
              <Table.HeadCell>Dish Name</Table.HeadCell>
              <Table.HeadCell>Price</Table.HeadCell>
              <Table.HeadCell>Meal Type</Table.HeadCell>
            </Table.Head>
            <Table.Body>
              {todayMenuItems.map((item, index) => (
                <Table.Row key={index}>
                  <Table.Cell>{item.dish}</Table.Cell>
                  <Table.Cell>{item.price}</Table.Cell>
                  <Table.Cell>{item.mealType}</Table.Cell>
                </Table.Row>
              ))}
            </Table.Body>
          </Table>
        ) : (
          <p>No menu items for today.</p>
        )}
      </Card>
    </div>
  );
};

export default TodaysMenu;
