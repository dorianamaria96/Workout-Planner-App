import './styles.css';
import React, { useState } from 'react';

export default function LoginForm() {

    return (
        <div className='forms'>
            <div className='form-wrapper'>
                <div className="title-text">
                    <div className="title">Login Form</div>
                </div>
                <div className="form-inner">
                <form action="#">
                        <div className="field">
                            <input type="email" placeholder="Email Address" required />
                        </div>
                        <div className="field">
                            <input type="password" placeholder="Password" required />
                        </div>
                        <div className="pass-link"><a href="#">Forgot password?</a></div>
                        <div className="field btn">
                            <div className="btn-layer"></div>
                            <input type="submit" value="Login" />
                        </div>
                        <div className="signup-link">Not a member? <a href="">Signup now</a></div>
                    </form>
                    
                </div>
            </div>
        </div>
    );
}