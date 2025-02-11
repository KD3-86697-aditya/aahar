import React, { useState, useEffect } from "react";

const ManageLocation = () => {
  const [city, setCity] = useState("");
  const [locations, setLocations] = useState([]);
  const [error, setError] = useState("");

  // Fetch all locations when component loads
  useEffect(() => {
    fetchLocations();
  }, []);

  // Fetch locations from backend
  const fetchLocations = async () => {
    try {
      const response = await fetch("http://localhost:8080/location/all");
      const data = await response.json();
      setLocations(data);
    } catch (error) {
      console.error("Error fetching locations:", error);
    }
  };

  // Handle adding a new location
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch("http://localhost:8080/location/add", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ city }),
      });

      if (response.ok) {
        alert("Location added successfully!");
        fetchLocations(); // Refresh the table
        setCity(""); // Reset input field
      } else {
        setError("Failed to add location. Try again.");
      }
    } catch (error) {
      console.error("Error adding location:", error);
      setError("Server error. Try again later.");
    }
  };

  // Handle deleting a location
  const handleDelete = async (id) => {
    try {
      const response = await fetch(`http://localhost:8080/location/delete/${id}`, {
        method: "DELETE",
      });

      if (response.ok) {
        alert("Location deleted successfully!");
        fetchLocations(); // Refresh the table
      } else {
        setError("Failed to delete location.");
      }
    } catch (error) {
      console.error("Error deleting location:", error);
      setError("Server error. Try again later.");
    }
  };

  return (
    <div className="manage-location">
      <h2 className="title">MANAGER LOCATION</h2>

      {/* Form to Add Location */}
      <form onSubmit={handleSubmit} className="location-form">
        <input
          type="text"
          name="city"
          placeholder="Enter City"
          value={city}
          onChange={(e) => setCity(e.target.value)}
          required
        />
        <button type="submit" className="add-button">Add Location</button>
      </form>

      {/* Error Message */}
      {error && <p className="error-message">{error}</p>}

      {/* Table to Display Locations */}
      <table className="location-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>City</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {locations.map((loc) => (
            <tr key={loc.id}>
              <td>{loc.id}</td>
              <td>{loc.city}</td>
              <td>
                <button onClick={() => handleDelete(loc.id)} className="delete-button">Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ManageLocation;
