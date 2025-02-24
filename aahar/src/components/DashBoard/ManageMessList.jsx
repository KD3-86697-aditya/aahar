import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const ManageMessList = () => {
    const [messes, setMesses] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        axios.get("http://localhost:8080/mess")
            .then(response => {
                setMesses(response.data);
            })
            .catch(error => {
                console.error("Error fetching mess list:", error);
            });
    }, []);

    const handleEditClick = (messId) => {
        localStorage.setItem("selectedMessId", messId); // ✅ Store messId in localStorage
        navigate("/ManageMessDetails"); // ✅ Navigate to the second page
    };

    return (
        <div>
            <h2>Manage Mess Listing</h2>
            <table>
                <thead>
                    <tr>
                        <th>Mess Name</th>
                        <th>Owner</th>
                        <th>Mobile No</th>
                        <th>City</th>
                        <th>Address</th>
                        <th>Edit</th>
                    </tr>
                </thead>
                <tbody>
                    {messes.map(mess => (
                        <tr key={mess.messOwnerId}>
                            <td>{mess.messName}</td>
                            <td>{mess.messOwnerId}</td>
                            <td>{mess.contactNumber}</td>
                            <td>{mess.locationId}</td>
                            <td>{mess.address}</td>
                            <td>
                                <button onClick={() => handleEditClick(mess.messOwnerId)}>
                                    ✏️ Edit
                                </button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default ManageMessList;
