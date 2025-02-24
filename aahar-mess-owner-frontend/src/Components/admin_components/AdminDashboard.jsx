import React from "react";

const AdminDashboard = () => {
  const styles = {
    dashboardContainer: {
      display: "flex",
      height: "100vh",
      fontFamily: "Arial, sans-serif",
    },
    sidebar: {
      backgroundColor: "#d6d6f5", // Light purple
      width: "20%",
      padding: "20px",
    },
    sidebarHeading: {
      marginBottom: "20px",
    },
    sidebarList: {
      listStyle: "none",
      padding: "0",
    },
    sidebarListItem: {
      marginBottom: "15px",
      cursor: "pointer",
    },
    mainContent: {
      width: "80%",
      padding: "20px",
      display: "flex",
      flexDirection: "column",
    },
    header: {
      display: "flex",
      justifyContent: "flex-end",
    },
    logo: {
      width: "100px",
      height: "auto",
    },
    cardsContainer: {
      display: "grid",
      gridTemplateColumns: "repeat(2, 1fr)",
      gap: "20px",
      marginTop: "20px",
    },
    card: {
      backgroundColor: "#f9f9f9",
      border: "1px solid #ccc",
      textAlign: "center",
      padding: "20px",
      boxShadow: "2px 2px 8px rgba(0, 0, 0, 0.1)",
      cursor: "pointer",
    },
  };

  return (
    <div style={styles.dashboardContainer}>
      {/* Sidebar */}
      <div style={styles.sidebar}>
        <h2 style={styles.sidebarHeading}>Dashboard</h2>
        <ul style={styles.sidebarList}>
          <li style={styles.sidebarListItem}>Manage Orders</li>
          <li style={styles.sidebarListItem}><a href="/manageorders">Manage Delivery</a> </li>
          <li style={styles.sidebarListItem}>Profile</li>
          <li style={styles.sidebarListItem}>Logout</li>
        </ul>
      </div>

      {/* Main Content */}
      <div style={styles.mainContent}>
        {/* Header */}
        <div style={styles.header}>
          <img
            src="path-to-logo" // Replace with the logo's path
            alt="Logo"
            style={styles.logo}
          />
        </div>

        {/* Cards */}
        <div style={styles.cardsContainer}>
          <div style={styles.card}><a href="/manage-staff">Manage Staff</a></div>
          <div style={styles.card}>Manage Location</div>
          <div style={styles.card}>Manage Mess</div>
          <div style={styles.card}>Manage Users</div>
        </div>
      </div>
    </div>
  );
};

export default AdminDashboard;