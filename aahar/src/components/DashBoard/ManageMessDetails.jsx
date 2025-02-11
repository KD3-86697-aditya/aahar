import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const ManageMessDetails = () => {
    const navigate = useNavigate();
    const [menuItems, setMenuItems] = useState([]);

    // ✅ Retrieve messId from localStorage
    const messId = localStorage.getItem("selectedMessId");

    useEffect(() => {
        if (!messId) {
            console.error("No messId found in localStorage");
            return;
        }

        console.log("Fetching menu for messId:", messId); // ✅ Debugging
        axios.get(`http://localhost:8080/menu/by-mess/${messId}`)
            .then(response => {
                console.log("Menu items:", response.data); // ✅ Debugging
                setMenuItems(response.data);
            })
            .catch(error => {
                console.error("Error fetching menu items:", error);
            });
    }, [messId]);

    const deleteMenuItem = (itemId) => {
        axios.delete(`http://localhost:8080/menu/delete/${itemId}`)
            .then(() => {
                setMenuItems(menuItems.filter(item => item.id !== itemId));
                console.log(`Deleted menu item ${itemId}`);
            })
            .catch(error => {
                console.error("Error deleting menu item:", error);
            });
    };

    const deleteMess = () => {
        axios.delete(`http://localhost:8080/mess/delete/${messId}`)
            .then(() => {
                console.log(`Deleted mess ${messId}`);
                localStorage.removeItem("selectedMessId"); // ✅ Remove stored messId
                navigate("/ManageMessList");
            })
            .catch(error => {
                console.error("Error deleting mess:", error);
            });
    };

    return (
        <div>
            <h2>Mess Items</h2>
            <button onClick={deleteMess} style={{ backgroundColor: "red", color: "white" }}>
                ❌ Delete Entire Mess
            </button>
            {menuItems.length > 0 ? (
                <table>
                    <thead>
                        <tr>
                            <th>Dish Name</th>
                            <th>Price</th>
                            <th>Availability</th>
                            <th>Meal Type</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        {menuItems.map(item => (
                            <tr key={item.id}>
                                <td>{item.dishName}</td>
                                <td>{item.price}</td>
                                <td>{item.isAvailable ? "Yes" : "No"}</td>
                                <td>{item.mealType}</td>
                                <td>
                                    <button onClick={() => deleteMenuItem(item.id)}>
                                        ❌ Delete
                                    </button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            ) : (
                <p>No menu items available.</p>
            )}
        </div>
    );
};

export default ManageMessDetails;
