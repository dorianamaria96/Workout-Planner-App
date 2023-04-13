import './styles.css';
import { ChangeEvent, useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import SelectGoal from './CreateProfileElements/SelectGoal'

interface Credentials {
    firstname: string;
    lastname: string;
    email: string;
    password: string;
}

interface Goal {
    goals: string[]
}


export default function ProfileForm() {

    let navigate = useNavigate()

    const initialProfile = {
        weight: 0.0,
        height: 0,
        birthday: null,
        gender: null,
        goals: []
      };

    const initialGoals: string[] = []

    const reguestOptionsGet = {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        }
    }


    //const [credentials, setCredentials] = useState<Credentials>(initialCredentials);
    const [goals, setGoals] = useState<string[]>(initialGoals)
    const [profile, setProfile] = useState<Object>()

    useEffect(() => {

        fetch('http://localhost:8080/profile/goals', reguestOptionsGet)
            .then(data => data.json())
            .then(data => {
                setGoals(data)
            })
            .catch(error => console.log(error))
    }, [])

    // const handleChange = (event: ChangeEvent<HTMLInputElement>) => {
    //     const { name, value } = event.target;
    //     setCredentials((prevCredentials) => ({
    //         ...prevCredentials,
    //         [name]: value,
    //     }));
    // };

    console.log("GOALS", goals)
    // const registerUser = (e: React.FormEvent<HTMLFormElement>) => {
    //     e.preventDefault();
    //     const requestOptions = {
    //         method: 'POST',
    //         headers: {
    //             'Content-Type': 'application/json',
    //         },
    //         body: JSON.stringify(credentials),
    //     };

    // };

    return (
        <div className="forms">
            <div className="form-wrapper">
                <div className="title-text">
                    <div className="title">Create Profile</div>
                </div>
                <div className="form-inner">

                    <div className='details'>
                    <label className="profile-label" htmlFor="weight">Weight (kg):</label>
                    <input className="profile-input" type="number" id="weight" name="weight" min={35} max={350} />
                    </div>
                    <div className='details'>
                    <label className="profile-label" htmlFor="height">Height (cm):</label>
                    <input className="profile-input" type="number" id="height" name="height" min={100} max={300} />
                    </div>
                    <div className='details'>
                    <label className="profile-label" htmlFor="gender">Gender:</label>
                    <select className="profile-input" id="gender" name="gender">
                        <option className="profile-input" value="male">Male</option>
                        <option className="profile-input" value="female">Female</option>
                    </select>
                    </div>
                    <div className='details'>
                    <label className="profile-label" htmlFor="dob">Date of Birth:</label>
                    <input className="profile-input" type="date" id="dob" name="dob" min="1930-01-01" max="2010-12-31" />
                    </div>
                    <SelectGoal goals={goals} />
                </div>
            </div>
        </div>
    );
}
