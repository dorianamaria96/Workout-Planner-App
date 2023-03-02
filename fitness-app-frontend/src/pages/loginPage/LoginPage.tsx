import Section from "../../compoments/section/Section";
import LoginForm from "../../compoments/authenticationForm/LoginForm";

export default function Homepage() {
    return (
        <Section
            container={<LoginForm/>}/>
    );
}