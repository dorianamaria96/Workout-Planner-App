import Section from "../../compoments/section/Section";
import ProfileForm from "../../compoments/authenticationForm/ProfileForm";

export default function CreateProfilePage() {
    return (
        <Section container={<ProfileForm/>}/>
    );
}