import React, { useState } from "react";
import { Navigate, useNavigate } from "react-router-dom";

function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const handleLogin = (e) => {
    e.preventDefault();
    console.log("Email:", email);
    console.log("Password:", password);
    navigate("/home");
  };

  return (
    <div className="bg-gradient-to-r from-purple-200 via-purple-400 to-purple-500 pt-[130px] pb-[220px]">
      <h1 className="text-center text-3xl font-serif font-bold mt-10">
        Welcome to User Login
      </h1>

      <form className="max-w-sm mx-auto mt-10">
        <label
          htmlFor="email"
          className="block mb-2 text-sm font-bold text-gray-900 dark:text-white"
        >
          Your email
        </label>
        <input
          type="email"
          id="email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          aria-describedby="helper-text-explanation"
          className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-purple-500 focus:border-purple-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-purple-600 dark:focus:border-purple-500"
          placeholder="user@domain.com"
        />

        <label
          htmlFor="password"
          className="block mb-2 text-sm font-bold text-gray-900 dark:text-white"
        >
          Your password
        </label>
        <input
          type="password"
          id="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          aria-describedby="helper-text-explanation"
          className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-purple-500 focus:border-purple-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-purple-500 dark:focus:border-purple-500"
          placeholder="********"
        />

        <p
          id="helper-text-explanation"
          className="mt-2 text-sm text-gray-100 dark:text-gray-400"
        >
          New to Aahar? Click here to register as a user{" "}
          <a
            href="/register"
            className="font-medium text-purple-700 hover:underline dark:text-purple-500"
          >
            signup
          </a>
          .
        </p>
      </form>
      <div className="text-center mt-12">
        <button
          type="button"
          onClick={handleLogin}
          className="w-32 text-white bg-gradient-to-r from-purple-500 via-purple-600 to-purple-700 hover:bg-gradient-to-br focus:ring-4 focus:outline-none focus:ring-purple-300 dark:focus:ring-purple-800 shadow-lg shadow-purple-500/50 dark:shadow-lg dark:shadow-purple-800/80 font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 mb-2"
        >
          Login
        </button>
      </div>
    </div>
  );
}

export default Login;
