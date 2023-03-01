import React from 'react';
import logo from './logo.svg';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import Homepage from './pages/homepage/Homepage';
import Navbar from './compoments/navbar/Navbar';
import StickyFooter from './compoments/footer/StickyFooter';

function App() {
  return (
    <BrowserRouter>
    <Navbar/>
      <Routes>
        <Route>
          <Route index element={<Homepage />} />
          <Route path="homepage" element={<Homepage />} />
          {/* <Route path="login" element={<CalendarPage />} />
          <Route path="register" element={<HabitTrackerPage />} /> */}
        </Route>
      </Routes>
      <StickyFooter/>
    </BrowserRouter>
  );
}

export default App;
