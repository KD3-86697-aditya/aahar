import React from "react";

import { images } from "../../constants";
import "./AboutUs.css";

const AboutUs = () => (
  <div
    className="app__aboutus app__bg flex__center section__padding"
    id="about"
  >
    <div className="app__aboutus-overlay flex__center">
      <img src={images.G} alt="G_overlay" />
    </div>

    <div className="app__aboutus-content flex__center">
      <div className="app__aboutus-content_about">
        <h1 className="headtext__cormorant">About Us</h1>
        <img src={images.spoon} alt="about_spoon" className="spoon__img" />
        <p className="p__opensans">
        At Aahar, we understand the challenges of finding affordable, hygienic, and convenient meal options, 
        especially for students and working professionals living away from home. Our platform bridges the gap 
        between you and nearby mess services, offering a streamlined solution to your daily dining needs. 
        Whether you’re searching for a monthly meal plan, a one-time meal, or nutritional transparency, 
        Aahar has got you covered. We strive to make every meal feel like home, providing you with diverse options, 
        flexible subscriptions, and the convenience of doorstep delivery.
        </p>
      </div>

      <div className="app__aboutus-content_knife flex__center">
        <img src={images.knife} alt="about_knife" />
      </div>

      <div className="app__aboutus-content_history">
        <h1 className="headtext__cormorant">Our Aim</h1>
        <img src={images.spoon} alt="about_spoon" className="spoon__img" />
        <p className="p__opensans">
  Our mission is to revolutionize how people access mess services by creating a platform that combines affordability, accessibility, and community-driven choices.
</p>
<ul>
  <li>Ease of Access</li>
  <li>Personalized Experience</li>
  <li>Community Connection</li>
</ul>
<p className="p__opensans">
  With Aahar, we aspire to make meal planning stress-free, ensuring that you never have to compromise on quality, convenience, or taste.
</p>

        
      </div>
    </div>
  </div>
);

export default AboutUs;
