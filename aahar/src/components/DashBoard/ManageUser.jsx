import React, { useEffect, useState } from "react";
import axios from "axios";
import { images } from "../../constants";

const ManageUser = () => {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    fetchUsers();
  }, []);

  const fetchUsers = async () => {
    try {
      const response = await axios.get("http://localhost:8080/users");
      setUsers(response.data);
    } catch (error) {
      console.error("Error fetching users", error);
    }
  };

  const deleteUser = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/users/${id}`);
      setUsers(users.filter(user => user.id !== id));
    } catch (error) {
      console.error("Error deleting user", error);
    }
  };

  return (
    <div className="p-4">
      <div className="flex items-center mb-4">
        <img src={images.aahar} alt="Logo" className="w-12 h-12 mr-4" />
        <h1 className="text-2xl font-bold">Manage Users</h1>
      </div>
      <table className="min-w-full bg-white border border-gray-200">
        <thead>
          <tr className="bg-gray-100">
            <th className="border px-4 py-2">ID</th>
            <th className="border px-4 py-2">Username</th>
            <th className="border px-4 py-2">Email</th>
            <th className="border px-4 py-2">First Name</th>
            <th className="border px-4 py-2">Last Name</th>
            <th className="border px-4 py-2">Phone Number</th>
            <th className="border px-4 py-2">Actions</th>
          </tr>
        </thead>
        <tbody>
          {users.map((user) => (
            <tr key={user.id} className="text-center">
              <td className="border px-4 py-2">{user.id}</td>
              <td className="border px-4 py-2">{user.username}</td>
              <td className="border px-4 py-2">{user.email}</td>
              <td className="border px-4 py-2">{user.firstName}</td>
              <td className="border px-4 py-2">{user.lastName}</td>
              <td className="border px-4 py-2">{user.phoneNumber}</td>
              <td className="border px-4 py-2">
                <button
                  className="bg-red-500 text-white px-4 py-1 rounded"
                  onClick={() => deleteUser(user.id)}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ManageUser;
