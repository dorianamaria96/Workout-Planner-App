import { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import './styles.css';

export default function Navbar() {

  const [user, setUser] = useState<string>()
  
  const userFirstname = localStorage.getItem('logged_in_user');
  let navigate = useNavigate()

  useEffect(() => {
    if (userFirstname) {
      setUser(userFirstname)
    }
  }, [userFirstname, user]);

  function logout() {
    localStorage.clear()
    navigate('/homepage')
  }

  function navigateToProfilePage() {
    navigate('/profile')
  }

  return (
    <header className="header">
      <div className="logo">
        <img src={'/media/while_logo_weights.png'} className="logo" alt="Logo" />
      </div>
      <nav className="navMenu">
        <a href="/homepage">Home</a>
        <a href="/exercises">Exercises</a>

        {userFirstname ? (
          <>
          <button className="user-button button-hero" onClick={navigateToProfilePage}> Hello, {user}</button>
          
          <a onClick={logout}>Logout</a>
        </>
          
        ) : (
          <>
            <a href="/login">Log in</a>
            <div className="register-button">
              <a href="/register">Register</a>
            </div>
          </>

        )}
      </nav>
    </header>
  );
}
