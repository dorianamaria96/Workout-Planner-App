import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import HomePage from './pages/homepage/HomePage';
import Navbar from './compoments/navbar/Navbar';
import Footer from './compoments/footer/Footer';
import RegisterPage from './pages/registerPage/RegisterPage';
import LoginPage from './pages/loginPage/LoginPage';
import ExercisesPage from './pages/exercises/ExercisesPage';
import ProfilePage from './pages/profile/ProfilePage';

function App() {
  return (
    <BrowserRouter>
    <Navbar />
      <Routes>
        <Route>
          <Route index element={<HomePage />} />
          <Route path="homepage" element={<HomePage />} />
           <Route path="register" element={<RegisterPage />} />
          <Route path="login" element={<LoginPage />} /> 
          <Route path="exercises" element={<ExercisesPage />} />
          <Route path="profile" element={<ProfilePage />} />  
        </Route>
      </Routes>
      <Footer/>
    </BrowserRouter>
  );
}

export default App;
