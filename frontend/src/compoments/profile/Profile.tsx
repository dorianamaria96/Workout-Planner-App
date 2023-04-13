import { useEffect, useState, ChangeEvent } from "react";
import './styles.css'
import ProfileInformation from "./ProfileInformation";


interface Profile {

}

interface Goal {
    goals: string[]
}


export default function Profile() {

    const imageObjectResult = {
        fileName: '',
        fileType: '',
        data: ''
    }

    const reguestOptionsGet = {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            authorization: 'Bearer ' + localStorage.getItem('token')
        }
    }

    const [uploadedImage, setUploadedImage] = useState<File>()
    const [image, setImage] = useState(imageObjectResult)
    const [imageExists, setImageExists] = useState<boolean>()

    useEffect(() => {

        fetch('http://localhost:8080/profile/image/find-if-exists', reguestOptionsGet)
            .then(data => data.json())
            .then(data => {
                setImageExists(data)
                if (data) {
                    retrieveImage()
                }
            })
            .catch(error => console.log(error))

        fetch('http://localhost:8080/profile/user-profile', reguestOptionsGet)
            .then(data => data.json())
            .then(data => {
                console.log("DATA ", data)
            })
            .catch(error => console.log(error))

        fetch('http://localhost:8080/profile/goals', reguestOptionsGet)
            .then(data => data.json())
            .then(data => {
                console.log("GOALS ", data)
            })
            .catch(error => console.log(error))
    }, [])


    function handleImageUpload(event: ChangeEvent<HTMLInputElement>) {
        const file = event.target.files?.[0];
        if (!file) return;

        if (file.size > 1048576) {
            alert("File is too big!")
        }
        setUploadedImage(file);
    }

    function uploadImage() {
        const formData = new FormData();
        if (uploadedImage) {
            formData.append('name', 'File Upload');
            formData.append('data', uploadedImage);
        }

        const requestOptions = {
            method: 'POST',
            headers: {
                authorization: 'Bearer ' + localStorage.getItem('token')
            },
            body: formData
        }

        fetch('http://localhost:8080/profile/image', requestOptions)
            .then(res => res.json())
            .then(res => {
                console.log(res)
                retrieveImage();
            })
            .catch(err => {
                console.log(err);
            })
    }


    function retrieveImage() {
        fetch('http://localhost:8080/profile/image', reguestOptionsGet)
            .then(data => data.json())
            .then(data =>
                setImage(data)
            )
            .catch(error => error)
    }

    const profile = {
        firstname: "Doriana",
        lastname: "Maria",
        weight: "50",
        height: "1.50",
        goal: "Gain Weight"
    }

    return (
        <div className="profile">

            <div className="profile-title">PROFILE</div>
            <div className="profile-holder">
                <div className="left-profile-section">
                    <>
                        {
                            imageExists
                                ?
                                <div className="profile-image" style={{ backgroundImage: `url(data:${image.fileType};base64,${image.data})` }}></div>
                                :
                                <div className="profile-image" style={{ backgroundImage: `url("/media/Portrait_Placeholder.png")` }}></div>
                        }
                    </>

                    <input type="file" multiple accept="image/*" onChange={handleImageUpload} />

                    <button className="upload-button button-hero" onClick={uploadImage}>Upload</button>



                </div>

                <div className="right-profile-section">
                    <ProfileInformation profile={profile}/>

                </div>


            </div>


        </div>
    );
}