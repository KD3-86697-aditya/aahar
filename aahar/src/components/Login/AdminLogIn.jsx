import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./CommonLogin.css";

const AdminLoginPage = () => {
  const [adminname, setAdminname] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const navigate = useNavigate(); 

  const handleLogin = async (e) => {
    e.preventDefault();
    setError(""); // Clear previous errors

    try {
      const response = await fetch("http://localhost:8080/admin/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ adminname, password }), // ✅ Match DTO field names
      });

      const data = await response.json(); // ✅ Properly handle JSON response

      if (response.ok) {
        alert("Login Successful");
        navigate("/dashboard"); // ✅ Redirect after successful login
      } else {
        setError(data.error || "Invalid Credentials"); // ✅ Display backend error messages
      }
    } catch (error) {
      setError("Server error. Please try again later.");
    }
  };

  return (
    <div className="admin-login">
      <div className="form-container">
        <h2 className="form-title">ADMIN LOGIN</h2>
        {error && <p className="error-message">{error}</p>} {/* ✅ Show error messages */}
        <form onSubmit={handleLogin}>
          <div className="form-group">
            <label htmlFor="adminname" className="form-label">Admin Name</label>
            <input
              type="text"
              id="adminname"
              name="adminname"
              className="form-input"
              placeholder="Enter admin name"
              value={adminname}
              onChange={(e) => setAdminname(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="password" className="form-label">Password</label>
            <input
              type="password"
              id="password"
              name="password"
              className="form-input"
              placeholder="Enter your password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>
          <div className="form-actions">
            <button type="submit" className="form-button">Login</button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default AdminLoginPage;
