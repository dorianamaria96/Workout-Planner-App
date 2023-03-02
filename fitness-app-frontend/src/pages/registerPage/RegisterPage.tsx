import Section from "../../compoments/section/Section";
import RegisterForm from "../../compoments/authenticationForm/RegisterForm";


export default function Homepage() {
    return (
        <Section
            container={<RegisterForm/>}/>
    );
}