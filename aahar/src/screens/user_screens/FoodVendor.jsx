// App.js or the main component file
import React from "react";
import Card from "../../components/user_components/VendorCard";
import Navbar from "../../components/Navbar";
import Footer from "../../components/Footer";

const FoodVendor = () => {
  const cardsData = [
    {
      id: 1,
      imageSrc:
        "https://img.freepik.com/free-photo/high-angle-hands-cooking-japanese-street-food_23-2149410195.jpg",
      title: "Taste Buds Mess Services",
      description:
        "Taste Buds Mess Services is your go-to destination for home-cooked, nutritious meals that cater to both students and working professionals. We pride ourselves on using fresh, locally sourced ingredients to create a variety of delectable dishes that suit diverse palates and dietary requirements.",
    },
    {
      id: 2,
      imageSrc:
        "https://img.freepik.com/free-photo/high-angle-hands-cooking-japanese-street-food_23-2149410195.jpg",
      title: "Taste Buds Mess Services",
      description:
        "Taste Buds Mess Services is your go-to destination for home-cooked, nutritious meals that cater to both students and working professionals. We pride ourselves on using fresh, locally sourced ingredients to create a variety of delectable dishes that suit diverse palates and dietary requirements.",
    },
    {
      id: 3,
      imageSrc:
        "https://img.freepik.com/free-photo/high-angle-hands-cooking-japanese-street-food_23-2149410195.jpg",
      title: "Taste Buds Mess Services",
      description:
        "Taste Buds Mess Services is your go-to destination for home-cooked, nutritious meals that cater to both students and working professionals. We pride ourselves on using fresh, locally sourced ingredients to create a variety of delectable dishes that suit diverse palates and dietary requirements.",
    },
    {
      id: 4,
      imageSrc:
        "https://img.freepik.com/free-photo/high-angle-hands-cooking-japanese-street-food_23-2149410195.jpg",
      title: "Taste Buds Mess Services",
      description:
        "Taste Buds Mess Services is your go-to destination for home-cooked, nutritious meals that cater to both students and working professionals. We pride ourselves on using fresh, locally sourced ingredients to create a variety of delectable dishes that suit diverse palates and dietary requirements.",
    },
    {
      id: 5,
      imageSrc:
        "https://img.freepik.com/free-photo/high-angle-hands-cooking-japanese-street-food_23-2149410195.jpg",
      title: "Taste Buds Mess Services",
      description:
        "Taste Buds Mess Services is your go-to destination for home-cooked, nutritious meals that cater to both students and working professionals. We pride ourselves on using fresh, locally sourced ingredients to create a variety of delectable dishes that suit diverse palates and dietary requirements.",
    },
    {
      id: 6,
      imageSrc:
        "https://img.freepik.com/free-photo/high-angle-hands-cooking-japanese-street-food_23-2149410195.jpg",
      title: "Taste Buds Mess Services",
      description:
        "Taste Buds Mess Services is your go-to destination for home-cooked, nutritious meals that cater to both students and working professionals. We pride ourselves on using fresh, locally sourced ingredients to create a variety of delectable dishes that suit diverse palates and dietary requirements.",
    },
    {
      id: 7,
      imageSrc:
        "https://img.freepik.com/free-photo/high-angle-hands-cooking-japanese-street-food_23-2149410195.jpg",
      title: "Taste Buds Mess Services",
      description:
        "Taste Buds Mess Services is your go-to destination for home-cooked, nutritious meals that cater to both students and working professionals. We pride ourselves on using fresh, locally sourced ingredients to create a variety of delectable dishes that suit diverse palates and dietary requirements.",
    },
  ];

  return (
    <>
      <Navbar />
      <h1 className="text-center font-bold text-3xl m-5">
        Available Nearby Food Vendors
      </h1>
      <hr />
      <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6 p-6">
        {cardsData.map((card, index) => (
          <Card
            id={card.id}
            key={index}
            imageSrc={card.imageSrc}
            title={card.title}
            description={card.description}
          />
        ))}
      </div>

      <Footer />
    </>
  );
};

export default FoodVendor;
