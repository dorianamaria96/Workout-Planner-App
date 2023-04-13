import './styles.css';
import { ChangeEvent, useState } from 'react';
import { useNavigate } from 'react-router-dom';

interface Credentials {
    firstname: string;
    lastname: string;
    email: string;
    password: string;
}

export default function RegisterForm() {

    let navigate = useNavigate()

    const initialCredentials: Credentials = {
        firstname: '',
        lastname: '',
        email: '',
        password: '',
    };

    const [credentials, setCredentials] = useState<Credentials>(initialCredentials);

    const handleChange = (event: ChangeEvent<HTMLInputElement>) => {
        const { name, value } = event.target;
        setCredentials((prevCredentials) => ({
            ...prevCredentials,
            [name]: value,
        }));
    };

    const registerUser = (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        const requestOptions = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(credentials),
        };

        fetch('http://localhost:8080/authentication/register', requestOptions)
            .then((response) => response.text())
            .then((response) => {
                if (response === "Success!") {
                    navigate('/create-profile')
                } else {
                    alert(response)
                }
            })
            .catch((error) => {
                console.error('Error:', error);
            });
  
    };

    return (
        <div className="forms">
            <div className="form-wrapper">
                <div className="title-text">
                    <div className="title">Register Form</div>
                </div>
                <div className="form-inner">
                    <form onSubmit={registerUser}>
                        <div className="field">
                            <input
                                type="text"
                                placeholder="First Name"
                                value={credentials.firstname}
                                onChange={handleChange}
                                name="firstname"
                                required
                            />
                        </div>
                        <div className="field">
                            <input
                                type="text"
                                placeholder="Last Name"
                                value={credentials.lastname}
                                onChange={handleChange}
                                name="lastname"
                                required
                            />
                        </div>
                        <div className="field">
                            <input
                                type="email"
                                placeholder="Email Address"
                                value={credentials.email}
                                onChange={handleChange}
                                name="email"
                                required
                            />
                        </div>
                        <div className="field">
                            <input
                                type="password"
                                placeholder="Password"
                                value={credentials.password}
                                onChange={handleChange}
                                name="password"
                                required
                            />
                        </div>
                        {/* <div className="pass-link">
                            <a href="#">Forgot password?</a>
                        </div> */}
                        <div className="field btn">
                            <div className="btn-layer"></div>
                            <input type="submit" value="Register" />
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
}
