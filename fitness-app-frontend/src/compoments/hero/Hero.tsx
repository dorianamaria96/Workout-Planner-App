import './styles.css'

export default function Hero() {
    return (
        <div className='container'>
            <div className="wrapper">
                <div className="left-div">
                    <h2 className='hero-text'>Take your fitness game to the next level with</h2>
                    <img src={"/media/logo_writting_white.svg"} className="logo-image" alt="Logo" />
                </div>
                <div className="right-div">
                    <img src={"/media/figure_3.svg"} className="hero-image" alt="Logo" />
                </div>
            </div>
        </div>
    );
}