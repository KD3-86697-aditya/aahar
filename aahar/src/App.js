import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./App.css";
import Login from "./screens/user_screens/Login";
import Registration from "./screens/user_screens/Registration";
import Home from "./screens/user_screens/Home";
import FoodVendor from "./screens/user_screens/FoodVendor";
import Contact from "./screens/user_screens/Contact";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Registration />} />
        <Route path="/user-home" element={<Home />}></Route>
        <Route path="/user-home/vendors" element={<FoodVendor />} />
        {/* // <Route path="/user-home/vendors/:id" element={<MessDetails />} /> */}
        <Route path="/user-home/contact" element={<Contact />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
