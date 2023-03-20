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

  return (
    <header className="header">
      <div className="logo">
        <img src={'/media/logo_simple.png'} className="logo" alt="Logo" />
      </div>
      <nav className="navMenu">
        <a href="/homepage">Home</a>
        <a href="/exercises">Exercises</a>

        {userFirstname ? (
          <>
          <a href='/profile' className="user-button">Hello, {user}</a>
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
