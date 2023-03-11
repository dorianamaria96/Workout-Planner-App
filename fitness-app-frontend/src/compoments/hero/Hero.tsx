import './styles.css'

export default function Hero() {
    return (
        <div className='container'>
            <div className="wrapper">
                <div className="left-div">
                    <img src={"/media/logo_writting_white.svg"} className="logo-image" alt="Logo" />

                    <h2 className='hero-text'>Take your fitness game to the next level.</h2>
                </div>
                <div className="right-div">
                    <img src={"/media/figure_3.svg"} className="hero-image" alt="Logo" />
                </div>
            </div>
        </div>
    );
}