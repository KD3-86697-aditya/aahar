import { useEffect, useState } from "react";
import axios from "axios";
import MessDashboardNavbar from "../Components/messowner_components/MessDashBoardNavbar";

const ManagePlans = () => {
  const messId = 1; // Replace with actual messId from auth context or props
  const [plans, setPlans] = useState([]);
  const [form, setForm] = useState({
    id: null,
    name: "",
    price: "",
    duration: "",
    mealsPerDay: "",
    mealType: "BREAKFAST",
  });
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    fetchPlans();
  }, []);

  const fetchPlans = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/subscription-plans/${messId}`);
      setPlans(response.data);
      setLoading(false);
    } catch (err) {
      setError("Failed to fetch plans");
      setLoading(false);
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      if (form.id) {
        await axios.put(`http://localhost:8080/subscription-plans/${form.id}/update`, form);
      } else {
        await axios.post(`http://localhost:8080/subscription-plans/${messId}/add`, { ...form, messId });
      }
      fetchPlans();
      resetForm();
    } catch (err) {
      setError("Failed to save plan");
    }
  };

  const handleDelete = async (id) => {
    if (window.confirm("Are you sure you want to delete this plan?")) {
      try {
        await axios.delete(`http://localhost:8080/subscription-plans/${id}/delete`);
        fetchPlans();
      } catch (err) {
        setError("Failed to delete plan");
      }
    }
  };

  const resetForm = () => {
    setForm({ id: null, name: "", price: "", duration: "", mealsPerDay: "", mealType: "BREAKFAST" });
  };

  const handleEdit = (plan) => {
    setForm(plan);
  };

  return (
    <div className="min-h-screen bg-gray-100">
      <MessDashboardNavbar/>
      <div className="max-w-5xl mx-auto py-8 px-4">
        <h2 className="text-2xl font-semibold mb-4 text-gray-700">Manage Subscription Plans</h2>
        
        {error && <p className="text-red-500">{error}</p>}

        {/* Form for Adding/Editing Plans */}
        <form onSubmit={handleSubmit} className="bg-white p-4 shadow-md rounded-lg mb-6">
          <div className="grid grid-cols-2 gap-4">
            <input type="text" placeholder="Plan Name" value={form.name} onChange={(e) => setForm({ ...form, name: e.target.value })} className="input-field" required />
            <input type="number" placeholder="Price (₹)" value={form.price} onChange={(e) => setForm({ ...form, price: e.target.value })} className="input-field" required />
            <input type="number" placeholder="Duration (days)" value={form.duration} onChange={(e) => setForm({ ...form, duration: e.target.value })} className="input-field" required />
            <input type="number" placeholder="Meals Per Day" value={form.mealsPerDay} onChange={(e) => setForm({ ...form, mealsPerDay: e.target.value })} className="input-field" required />
            <select value={form.mealType} onChange={(e) => setForm({ ...form, mealType: e.target.value })} className="input-field">
              <option value="BREAKFAST">Breakfast</option>
              <option value="LUNCH">Lunch</option>
              <option value="DINNER">Dinner</option>
              <option value="ALL">All Meals</option>
            </select>
          </div>
          <button type="submit" className="bg-blue-500 text-white px-4 py-2 rounded-md mt-4">
            {form.id ? "Update Plan" : "Add Plan"}
          </button>
        </form>

        {/* Plans Table */}
        {loading ? (
          <p>Loading...</p>
        ) : plans.length === 0 ? (
          <p>No subscription plans available.</p>
        ) : (
          <div className="bg-white p-4 shadow-md rounded-lg">
            <table className="w-full border-collapse">
              <thead>
                <tr className="bg-gray-200">
                  <th className="p-2">Name</th>
                  <th className="p-2">Price</th>
                  <th className="p-2">Duration</th>
                  <th className="p-2">Meals/Day</th>
                  <th className="p-2">Meal Type</th>
                  <th className="p-2">Actions</th>
                </tr>
              </thead>
              <tbody>
                {plans.map((plan) => (
                  <tr key={plan.id} className="border-t">
                    <td className="p-2">{plan.name}</td>
                    <td className="p-2">₹{plan.price}</td>
                    <td className="p-2">{plan.duration} days</td>
                    <td className="p-2">{plan.mealsPerDay}</td>
                    <td className="p-2">{plan.mealType}</td>
                    <td className="p-2">
                      <button onClick={() => handleEdit(plan)} className="bg-yellow-500 text-white px-2 py-1 rounded-md mr-2">Edit</button>
                      <button onClick={() => handleDelete(plan.id)} className="bg-red-500 text-white px-2 py-1 rounded-md">Delete</button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        )}
      </div>
    </div>
  );
};

export default ManagePlans;
