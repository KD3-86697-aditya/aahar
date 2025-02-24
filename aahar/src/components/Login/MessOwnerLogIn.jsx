import React from "react";
import "./CommonLogin.css"

const MessOwnerLoginPage = () => {
  return (
    <div className="admin-login">
      <div className="form-container">
        <h2 className="form-title">MESS-OWNER LOGIN</h2>
        <form>
          <div className="form-group">
            <label htmlFor="username" className="form-label">
              Username
            </label>
            <input
              type="text"
              id="username"
              name="username"
              className="form-input"
              placeholder="Enter your username"
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="password" className="form-label">
              Password
            </label>
            <input
              type="password"
              id="password"
              name="password"
              className="form-input"
              placeholder="Enter your password"
              required
            />
          </div>
          <div className="form-actions">
            <button type="submit" className="form-button">
              Login
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default MessOwnerLoginPage;
