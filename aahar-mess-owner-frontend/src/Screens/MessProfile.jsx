import React, { useEffect, useState } from "react";
import axios from "axios";
import MessDashboardNavbar from "../Components/messowner_components/MessDashBoardNavbar";

const MessProfile = () => {
  const messId = 1; // Replace with dynamic ID if needed
  const [messDetails, setMessDetails] = useState({
    messName: "",
    firstName: "",
    lastName: "",
    ownerPhone: "",
    ownerEmail: "",
    address: "",  // Added missing address field
    location: {
      city: "",
      state: "",
      pincode: "",
    },
  });

  const [loading, setLoading] = useState(true);
  const [isEditing, setIsEditing] = useState(false);
  const [message, setMessage] = useState("");

  // Fetch mess details
  useEffect(() => {
    axios
      .get(`http://localhost:8080/messes/${messId}`)
      .then((response) => {
        const data = response.data;
        setMessDetails({
          messName: data.messName || "",
          firstName: data.firstName || "",
          lastName: data.lastName || "",
          ownerPhone: data.ownerPhone || "",
          ownerEmail: data.ownerEmail || "",
          address: data.address || "",
          location: {
            city: data.location?.city || "",
            state: data.location?.state || "",
            pincode: data.location?.pincode || "",
          },
        });
        setLoading(false);
      })
      .catch((error) => {
        console.error("Error fetching mess details:", error);
        setLoading(false);
      });
  }, []);

  // Handle input changes
  const handleChange = (e) => {
    const { name, value } = e.target;
    if (name === "city" || name === "state" || name === "pincode") {
      setMessDetails({
        ...messDetails,
        location: {
          ...messDetails.location,
          [name]: value,
        },
      });
    } else {
      setMessDetails({ ...messDetails, [name]: value });
    }
  };

  // Handle update submission
  const handleUpdate = (e) => {
    e.preventDefault();
    setMessage(""); // Clear previous messages

    const updatedData = {
      messName: messDetails.messName,
      firstName: messDetails.firstName,
      lastName: messDetails.lastName,
      ownerPhone: messDetails.ownerPhone,
      ownerEmail: messDetails.ownerEmail,
      address: messDetails.address,
      location: {
        city: messDetails.location.city,
        state: messDetails.location.state,
        pincode: messDetails.location.pincode,
      },
    };

    axios
      .put(`http://localhost:8080/messes/${messId}`, updatedData)
      .then((response) => {
        setMessage("Mess details updated successfully!");
        setIsEditing(false);

        // Update state with latest response data
        setMessDetails(response.data);
      })
      .catch((error) => {
        console.error("Error updating mess details:", error);
        setMessage("Failed to update mess details.");
      });
  };

  return (
    <div className="min-h-screen bg-gray-100">
      <MessDashboardNavbar />
      <div className="max-w-3xl mx-auto mt-8 p-6 bg-white shadow-lg rounded-lg">
        <h2 className="text-3xl font-bold text-center text-gray-800 mb-6">
          Mess Profile
        </h2>

        {loading ? (
          <p className="text-center text-gray-500">Loading...</p>
        ) : (
          <form onSubmit={handleUpdate} className="space-y-4 text-gray-700">
            {message && (
              <p className={`text-center ${message.includes("successfully") ? "text-green-500" : "text-red-500"}`}>
                {message}
              </p>
            )}

            <div className="flex justify-between border-b pb-2">
              <span className="font-semibold">Mess Name:</span>
              {isEditing ? (
                <input
                  type="text"
                  name="messName"
                  value={messDetails.messName}
                  onChange={handleChange}
                  className="border px-2 py-1 rounded"
                />
              ) : (
                <span>{messDetails.messName || "N/A"}</span>
              )}
            </div>

            <div className="flex justify-between border-b pb-2">
              <span className="font-semibold">Owner Name:</span>
              {isEditing ? (
                <>
                  <input
                    type="text"
                    name="firstName"
                    value={messDetails.firstName}
                    onChange={handleChange}
                    className="border px-2 py-1 rounded mr-2"
                  />
                  <input
                    type="text"
                    name="lastName"
                    value={messDetails.lastName}
                    onChange={handleChange}
                    className="border px-2 py-1 rounded"
                  />
                </>
              ) : (
                <span>{`${messDetails.firstName || "N/A"} ${messDetails.lastName || "N/A"}`}</span>
              )}
            </div>

            <div className="flex justify-between border-b pb-2">
              <span className="font-semibold">Owner Contact:</span>
              {isEditing ? (
                <input
                  type="text"
                  name="ownerPhone"
                  value={messDetails.ownerPhone}
                  onChange={handleChange}
                  className="border px-2 py-1 rounded"
                />
              ) : (
                <span>{messDetails.ownerPhone || "N/A"}</span>
              )}
            </div>

            <div className="flex justify-between border-b pb-2">
              <span className="font-semibold">Owner Email:</span>
              {isEditing ? (
                <input
                  type="email"
                  name="ownerEmail"
                  value={messDetails.ownerEmail}
                  onChange={handleChange}
                  className="border px-2 py-1 rounded"
                />
              ) : (
                <span>{messDetails.ownerEmail || "N/A"}</span>
              )}
            </div>

            <div className="flex justify-between border-b pb-2">
              <span className="font-semibold">City:</span>
              {isEditing ? (
                <input
                  type="text"
                  name="city"
                  value={messDetails.location.city}
                  onChange={handleChange}
                  className="border px-2 py-1 rounded"
                />
              ) : (
                <span>{messDetails.location.city || "N/A"}</span>
              )}
            </div>
            <div className="flex justify-between border-b pb-2">
              <span className="font-semibold">State:</span>
              {isEditing ? (
                <input
                  type="text"
                  name="state"
                  value={messDetails.location.state}
                  onChange={handleChange}
                  className="border px-2 py-1 rounded"
                />
              ) : (
                <span>{messDetails.location.state || "N/A"}</span>
              )}
            </div>

            <div className="flex justify-between border-b pb-2">
              <span className="font-semibold">Pincode:</span>
              {isEditing ? (
                <input
                  type="text"
                  name="pincode"
                  value={messDetails.location.pincode}
                  onChange={handleChange}
                  className="border px-2 py-1 rounded"
                />
              ) : (
                <span>{messDetails.location.pincode || "N/A"}</span>
              )}
            </div>

            {/* Buttons */}
            <div className="flex justify-center space-x-4 mt-4">
              {isEditing ? (
                <>
                  <button
                    type="submit"
                    className="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600"
                  >
                    Save Changes
                  </button>
                  <button
                    type="button"
                    onClick={() => setIsEditing(false)}
                    className="bg-gray-400 text-white px-4 py-2 rounded hover:bg-gray-500"
                  >
                    Cancel
                  </button>
                </>
              ) : (
                <button
                  type="button"
                  onClick={() => setIsEditing(true)}
                  className="bg-green-500 text-white px-4 py-2 rounded hover:bg-green-600"
                >
                  Edit Profile
                </button>
              )}
            </div>
          </form>
        )}
      </div>
    </div>
  );
};

export default MessProfile;