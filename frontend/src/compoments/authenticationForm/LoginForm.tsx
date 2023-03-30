import './styles.css';
import { ChangeEvent, useState } from 'react';
import { useNavigate } from 'react-router-dom';

interface LoginCredentials {
    email: string;
    password: string;
}

export default function LoginForm() {

    let navigate = useNavigate();

    const initialCredentials = {
        email: '',
        password: '',
    };

    const [credentials, setCredentials] = useState<LoginCredentials>(initialCredentials);

    const handleChange = (event: ChangeEvent<HTMLInputElement>) => {
        const { name, value } = event.target;
        setCredentials((prevCredentials) => ({
            ...prevCredentials,
            [name]: value,
        }));
    };

    const loginUser = (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        let encodedData = window.btoa(
            credentials.email + ':' + credentials.password,
        );

        const requestOptions = {
            method: 'POST',
            headers: {
                authorization: 'Basic ' + encodedData,
            },
        };


        return fetch('http://localhost:8080/authentication/login', requestOptions)
            .then((response) => response.text())
            .then((token: string) => {
                localStorage.setItem('token', token);
                if (token) {
                    fetchUsername(token)
                    navigate('/homepage');
                } else {
                    alert('Wrong username or password, try again!');
                    setCredentials(initialCredentials)
                }
            })
            .catch((err) => {
                console.error(err);
            });

    };

    function fetchUsername(token: string) {
        fetch('http://localhost:8080/authentication/username', {
            method: 'GET',
            headers: {
                authorization: 'Bearer ' + token,
            },
        })
            .then((response) => response.text())
            .then((data: string) => {
                localStorage.setItem('logged_in_user', data)
            })
            .catch((error) => console.error(error));
    }



return (
    <div className='forms'>
        <div className='form-wrapper'>
            <div className="title-text">
                <div className="title">Login Form</div>
            </div>
            <div className="form-inner">
                <form onSubmit={loginUser}>
                    <div className="field">
                        <input
                            type="email"
                            name="email"
                            placeholder="Email Address"
                            value={credentials.email}
                            onChange={handleChange}
                            required />
                    </div>
                    <div className="field">
                        <input
                            type="password"
                            name="password"
                            placeholder="Password"
                            value={credentials.password}
                            onChange={handleChange}
                            required />
                    </div>
                    {/* <div className="pass-link"><a href="#">Forgot password?</a></div> */}
                    <div className="field btn">
                        <div className="btn-layer"></div>
                        <input type="submit" value="Login" />
                    </div>
                    <div className="signup-link">Not a member? <a href="/register">Signup now</a></div>
                </form>

            </div>
        </div>
    </div>
);
}