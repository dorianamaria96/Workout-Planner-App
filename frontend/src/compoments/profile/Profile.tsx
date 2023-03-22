import { useState, ChangeEvent } from "react";
import './styles.css'

export default function Profile() {

    const [uploadedImage, setUploadedImage] = useState<File>()

    function handleImageUpload(event: ChangeEvent<HTMLInputElement>) {
        const file = event.target.files?.[0];
        if (!file) return;
        const reader = new FileReader();

        // reader.onload = (event) => {
        //     const result = event.target?.result;
        //     if (!result) return;
        //     const byteArray = new Uint8Array(
        //         typeof result === "string" ?
        //             new TextEncoder().encode(result) :
        //             result
        //     );
    
            
            
        // };
        if (file.size > 1048576) {
            alert("File is too big!")
        }
        
        reader.readAsArrayBuffer(file);
        setUploadedImage(file);
    }

    function uploadImage() {
        console.log("FILE ", uploadedImage)
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
        console.log("REQUEST FK OPTIONS ", requestOptions)

        fetch('http://localhost:8080/profile/image', requestOptions)
        .then(res => res.json())
        .then(res => {
            console.log(res);                   
        })
        .catch(err => {
            console.log(err);
        })
    }

    const reguestOptionsImage = {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            authorization: 'Bearer ' + localStorage.getItem('token')
        }
    }

    const imageObjectResult = {
        fileName: '',
        fileType: '',
        data: ''
    }
    const [image, setImage] = useState(imageObjectResult)
    const [imageData, setImageData] = useState<string>()

    function retrieveImage() {
        fetch('http://localhost:8080/profile/image/2', reguestOptionsImage)
            .then(data => data.json())
            .then(data => 
                setImage(data)
                )
            .catch(error => error) 
    }

    function showImage() {
        retrieveImage()
        console.log(window.atob(image.data))
        console.log(image.data)
        setImageData(`data:${image.fileType};base64,${image.data}`)

    }
    

    return (
        <div className="profile">This is the Profile Page

            <input type="file" multiple accept="image/*" onChange={handleImageUpload} />

            <button className="upload-button" onClick={uploadImage}>Upload</button>

            <button onClick={showImage} > Show Image </button>

            <>
            {
                image && <img className="profile-image" src={imageData} alt={image.fileName}/>
            }
            </>

        </div>
    );
}