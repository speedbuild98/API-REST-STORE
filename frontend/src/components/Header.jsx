import React, { useState } from 'react'
import { Link } from "react-router-dom";

import Logo from '../assets/Logo.png'
import Menu from '@iconscout/react-unicons/icons/uil-ellipsis-h'


const Header = () => {

      const [nav, setNav] = useState(false);
      const handleClick = () => setNav(!nav);

  return (
    <header className="header">
      <nav className="header__nav">
        <a className="header__nav-title" href="http://localhost:3000/">
          <img className="header__nav-img" src={Logo} alt="Logo SumTech Labs" />
        </a>
        <Menu
          onClick={handleClick}
          className={
            !nav
              ? "header__nav-icon"
              : "header__nav-icon header__nav-icon--open"
          }
        />
      </nav>
      <div
        className={
          !nav
            ? "header__menu header__menu--hidden"
            : "header__menu header__menu--show"
        }
      >
        <div
          className={
            !nav
              ? "header__menu__content header__menu-content--hidden"
              : "header__menu__content header__menu-content--show"
          }
        >
              <span className='header__menu__content-title'>Store Managment System</span>
              <Link className='header__menu__content-link' to="/">Dashboard</Link>
              <Link className='header__menu__content-link' to="/customers">Customers</Link>
              <Link className='header__menu__content-link' to="/products">Products</Link>
              <Link className='header__menu__content-link' to="/operations">Operations</Link>
              <button className='header__menu__content-button'>Add Operation</button>
        </div>
      </div>
    </header>
  );
}

export default Header