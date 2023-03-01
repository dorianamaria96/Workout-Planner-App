import './styles.css'

export default function Navbar() {
  return (
    <header className="header">
      <div className="logo">
        <img src={"/media/logo_simple.png"} className="logo" alt="Logo" />
      </div>
      <nav className="navMenu">
        <a href="#">Home</a>
        <a href="#">Sign up</a>
        <div className='register-button'><a href="#">Register</a></div>
        
        
      </nav>
    </header>
  );
}