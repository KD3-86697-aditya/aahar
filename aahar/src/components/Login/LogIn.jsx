import React from "react";
import { useNavigate } from "react-router-dom";
import images from "../../constants/images";
import "./LogIn.css"

const Login = () => {
  const navigate = useNavigate();

  const handleLogin = (role) => {
    console.log(`${role} Login`);
  };

  return (
    <div className="">
      <div className="absolute top-4 left-4">
        <img
          src={images.aahar} 
          alt="Aahar Logo"
          className="w-16 h-auto"
        />
      </div>

      <div>
        <div class="container">
            <button onClick={() => navigate("/AdminLogin")} class="button" >ADMIN</button>
        </div>
        <div class="container">
            <button onClick={() => navigate("/MessOwnerLogin")} class="button" >MESS-OWNER</button>
        </div>
      </div>

      <div>
        <div class="container">
            <button onClick={() => navigate("/UserLogin")} class="button" >USER</button>
        </div>
      </div>
    </div>
  );
};



export default Login;
