import './styles.css'

export default function Footer() {
  return (

    <footer>
      <div className="footer">
        <div className='footer-message'>Excuses don't burn calories.</div>
          
            <img src={"/media/insta-icon.png"} className="social-logo" alt="insta-logo" />
          
        <p>Copyright ©2023 </p>
      </div>
    </footer>
  );
}