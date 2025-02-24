import React, { useEffect, useState, useRef } from "react";
import axios from "axios";
import MessDashboardNavbar from "../Components/messowner_components/MessDashBoardNavbar";

const ManageMenu = () => {
  const [weeklyMenu, setWeeklyMenu] = useState({});
  const [loading, setLoading] = useState(true);
  const [newDish, setNewDish] = useState({
    dishName: "",
    price: "",
    dayOfWeek: "MONDAY",
    mealType: "LUNCH",
  });

  const [editingItem, setEditingItem] = useState(null);
  const messOwnerId = 1; // Replace with dynamic ID if needed
  const formRef = useRef(null); // Reference for scrolling to form

  useEffect(() => {
    fetchMenu();
  }, []);

  const fetchMenu = () => {
    axios
      .get(`http://localhost:8080/api/menu/weekly/${messOwnerId}`)
      .then((response) => {
        const groupedMenu = response.data.reduce((acc, item) => {
          const day = item.dayOfWeek;
          acc[day] = acc[day] || [];
          acc[day].push(item);
          return acc;
        }, {});
        setWeeklyMenu(groupedMenu);
        setLoading(false);
      })
      .catch((error) => {
        console.error("Error fetching menu items:", error);
        setLoading(false);
      });
  };

  const handleAdd = (e) => {
    e.preventDefault();
    const formData = new URLSearchParams();
    formData.append("messOwnerId", messOwnerId);
    formData.append("dishName", newDish.dishName);
    formData.append("price", newDish.price);
    formData.append("dayOfWeek", newDish.dayOfWeek);
    formData.append("mealType", newDish.mealType);

    axios
      .post("http://localhost:8080/api/menu/add", formData, {
        headers: { "Content-Type": "application/x-www-form-urlencoded" },
      })
      .then(() => {
        fetchMenu();
        resetForm();
      })
      .catch((error) => console.error("Error adding menu item:", error));
  };

  const handleEditClick = (item) => {
    setEditingItem(item);
    setNewDish({
      dishName: item.dishName,
      price: item.price.toString(),
      dayOfWeek: item.dayOfWeek,
      mealType: item.mealType || "LUNCH",
    });

    // Scroll to form when clicking Edit
    if (formRef.current) {
      formRef.current.scrollIntoView({ behavior: "smooth", block: "start" });
    }
  };

  const handleUpdate = (e) => {
    e.preventDefault();
    if (!editingItem) return;

    axios
      .put("http://localhost:8080/api/menu/update", {
        id: editingItem.id,
        dishName: newDish.dishName,
        price: Number(newDish.price),
        dayOfWeek: newDish.dayOfWeek.toUpperCase(),
        mealType: newDish.mealType.toUpperCase(),
      })
      .then(() => {
        fetchMenu();
        resetForm();
      })
      .catch((error) => console.error("Error updating menu item:", error));
  };

  const handleDelete = (menuItemId) => {
    axios
      .delete(`http://localhost:8080/api/menu/delete/${menuItemId}`)
      .then(() => fetchMenu())
      .catch((error) => console.error("Error deleting menu item:", error));
  };

  const resetForm = () => {
    setNewDish({ dishName: "", price: "", dayOfWeek: "MONDAY", mealType: "LUNCH" });
    setEditingItem(null);
  };

  return (
    <div >
      <MessDashboardNavbar />
      <div className="max-w-6xl mx-auto p-4">


      <h2 className="text-2xl font-bold mb-4">Manage Weekly Menu</h2>

      {/* ADD/EDIT MENU ITEM FORM */}
      <form
        ref={formRef}
        onSubmit={editingItem ? handleUpdate : handleAdd}
        className="mb-6 p-4 border rounded bg-gray-100"
      >
        <h3 className="text-lg font-semibold mb-2">{editingItem ? "Edit Menu Item" : "Add Menu Item"}</h3>
        <div className="mb-2">
          <label className="block">Dish Name:</label>
          <input
            type="text"
            value={newDish.dishName}
            onChange={(e) => setNewDish({ ...newDish, dishName: e.target.value })}
            className="border p-2 w-full"
            required
          />
        </div>
        <div className="mb-2">
          <label className="block">Price:</label>
          <input
            type="number"
            value={newDish.price}
            onChange={(e) => setNewDish({ ...newDish, price: e.target.value })}
            className="border p-2 w-full"
            required
          />
        </div>
        <div className="mb-2">
          <label className="block">Day of the Week:</label>
          <select
            value={newDish.dayOfWeek}
            onChange={(e) => setNewDish({ ...newDish, dayOfWeek: e.target.value })}
            className="border p-2 w-full"
          >
            {["MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"].map((day) => (
              <option key={day} value={day}>
                {day}
              </option>
            ))}
          </select>
        </div>
        <div className="mb-2">
          <label className="block">Meal Type:</label>
          <select
            value={newDish.mealType || "LUNCH"}
            onChange={(e) => setNewDish({ ...newDish, mealType: e.target.value })}
            className="border p-2 w-full"
          >
            {["BREAKFAST", "LUNCH", "DINNER"].map((type) => (
              <option key={type} value={type}>
                {type}
              </option>
            ))}
          </select>
        </div>
        <button type="submit" className="bg-green-500 text-white px-4 py-2 rounded mt-2">
          {editingItem ? "Update Dish" : "Add Dish"}
        </button>
        {editingItem && (
          <button type="button" onClick={resetForm} className="bg-gray-500 text-white px-4 py-2 rounded mt-2 ml-2">
            Cancel
          </button>
        )}
      </form>

      {loading ? (
        <p>Loading...</p>
      ) : Object.keys(weeklyMenu).length === 0 ? (
        <p>No menu items available.</p>
      ) : (
        Object.keys(weeklyMenu).map((day) => (
          <div key={day} className="mb-6">
            <h3 className="text-xl font-semibold mb-2">{day}</h3>
            <table className="w-full border-collapse border border-gray-300">
              <thead>
                <tr className="bg-gray-200">
                  <th className="border p-2">Dish Name</th>
                  <th className="border p-2">Price</th>
                  <th className="border p-2">Available</th>
                  <th className="border p-2">Actions</th>
                </tr>
              </thead>
              <tbody>
                {weeklyMenu[day].map((item) => (
                  <tr key={item.id} className="text-center">
                    <td className="border p-2">{item.dishName}</td>
                    <td className="border p-2">₹{item.price}</td>
                    <td className="border p-2">{item.isAvailable ? "Yes" : "No"}</td>
                    <td className="border p-2">
                      <button onClick={() => handleEditClick(item)} className="bg-blue-500 text-white px-4 py-1 rounded">
                        Edit
                      </button>
                      <button onClick={() => handleDelete(item.id)} className="bg-red-500 text-white px-4 py-1 rounded mx-2">
                        Delete
                      </button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        ))
      )}
      </div>
    </div>
  );
};

export default ManageMenu;
