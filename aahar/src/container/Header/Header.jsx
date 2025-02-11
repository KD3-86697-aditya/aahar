import React from "react";

import { SubHeading } from "../../components";
import { images } from "../../constants";
import "./Header.css";

const Header = () => (
  <div className="app__header app__wrapper app__bg section__padding" id="home">
    <div className="app__wrapper_info">
      <SubHeading title="Home Far From Home" />
      <h1 className="app__header-h1">Where Flavour Meets Home</h1>
      <p className="p__opensans" style={{ margin: "2rem 0" }}>
  At Aahar, we connect you to wholesome meals from nearby messes, blending convenience with quality.
</p>
<p className="p__opensans">
  Whether it’s a daily craving or a long-term plan, we bring you flavors that feel like home.
</p>
<p className="p__opensans" style={{ textAlign: "center" }}>
  Your taste, your choice – delivered with care.
</p>

      
    </div>

    <div className="app__wrapper_img">
      <img src={images.welcome} alt="header_img" />
    </div>
  </div>
);

export default Header;
