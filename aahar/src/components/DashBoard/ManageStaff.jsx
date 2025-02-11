import React, { useState, useEffect } from "react";

const ManageStaff = () => {
  const [staffList, setStaffList] = useState([]);
  const [formData, setFormData] = useState({
    name: "",
    address: "",
    dob: "",
    gender: "",
    mobileNo: "",
    role: "",
  });

  // ✅ Fetch staff members on page load
  useEffect(() => {
    fetch("http://localhost:8080/staff")
      .then((res) => res.json())
      .then((data) => setStaffList(data))
      .catch((err) => console.error("Error fetching staff:", err));
  }, []);

  // ✅ Handle input change
  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  // ✅ Handle form submit (Add Staff)
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch("http://localhost:8080/staff", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(formData),
      });

      if (!response.ok) throw new Error("Failed to add staff");
      alert("Staff added successfully!");

      // Refresh staff list after adding
      const updatedList = await fetch("http://localhost:8080/staff").then((res) => res.json());
      setStaffList(updatedList);
    } catch (err) {
      console.error("Error adding staff:", err);
    }
  };

  return (
    <div className="staff-manager">
      <h2>MANAGER STAFF</h2>
      
      {/* ✅ Add Staff Form */}
      <form onSubmit={handleSubmit}>
        <input type="text" name="name" placeholder="Name" onChange={handleChange} required />
        <input type="text" name="address" placeholder="Address" onChange={handleChange} required />
        <input type="date" name="dob" onChange={handleChange} required />
        <select name="gender" onChange={handleChange} required>
          <option value="">Select Gender</option>
          <option value="Male">Male</option>
          <option value="Female">Female</option>
        </select>
        <input type="text" name="mobileNo" placeholder="Mobile No" onChange={handleChange} required />
        <input type="text" name="role" placeholder="Role" onChange={handleChange} required />
        <button type="submit">Add Staff</button>
      </form>

      {/* ✅ Staff Table */}
      <table>
        <thead>
          <tr>
            <th>NAME</th>
            <th>ADDRESS</th>
            <th>DOB</th>
            <th>GENDER</th>
            <th>MOBILE NO</th>
            <th>ROLE</th>
          </tr>
        </thead>
        <tbody>
          {staffList.map((staff, index) => (
            <tr key={index}>
              <td>{staff.name}</td>
              <td>{staff.address}</td>
              <td>{staff.dob}</td>
              <td>{staff.gender}</td>
              <td>{staff.mobileNo}</td>
              <td>{staff.role}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ManageStaff;
