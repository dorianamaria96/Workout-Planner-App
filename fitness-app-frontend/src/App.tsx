import React from 'react';
import logo from './logo.svg';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import HomePage from './pages/homepage/HomePage';
import Navbar from './compoments/navbar/Navbar';
import StickyFooter from './compoments/footer/StickyFooter';
import RegisterPage from './pages/registerPage/RegisterPage';
import LoginPage from './pages/loginPage/LoginPage';

function App() {
  return (
    <BrowserRouter>
    <Navbar/>
      <Routes>
        <Route>
          <Route index element={<HomePage />} />
          <Route path="homepage" element={<HomePage />} />
           <Route path="register" element={<RegisterPage />} />
          <Route path="login" element={<LoginPage />} /> 
        </Route>
      </Routes>
      <StickyFooter/>
    </BrowserRouter>
  );
}

export default App;
