import './styles.css'

export default function Navbar() {
  return (
    <header className="header">
      <div className="logo">
        <img src={"/media/logo_simple.png"} className="logo" alt="Logo" />
      </div>
      <nav className="navMenu">
        <a href="/homepage">Home</a>
        <a href="/exercises">Exercises</a>
        <a href="/login">Log in</a>
        <div className='register-button'><a href="/register">Register</a></div>
        
        
      </nav>
    </header>
  );
}