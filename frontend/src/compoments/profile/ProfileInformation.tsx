import './styles.css'

interface Profile {
    profile: ProfileInformation
}

interface ProfileInformation {
    firstname: string,
    lastname: string,
    weight: string,
    height: string,
    goal: string
}

export default function ProfileInformation({profile}: Profile) {
    return (
        <div className='profile-section' >

                <div className="personal-information-holder">
                    <div className="information-label">First Name</div>
                    <div className="information">
                        {profile.firstname}
                    </div>
                </div>

                <div className="personal-information-holder">
                    <div className="information-label">Last Name</div>
                    <div className="information">
                        {profile.lastname}
                    </div>
                </div>

                <div className="personal-information-holder">
                    <div className="information-label">Weight</div>
                    <div className="information">
                        {profile.weight} kg
                    </div>
                </div>

                <div className="personal-information-holder">
                    <div className="information-label">Height</div>
                    <div className="information">
                        {profile.height} cm
                    </div>
                </div>

                <div className="personal-information-holder">
                    <div className="information-label">Goal</div>
                    <div className="information">
                        {profile.goal}
                    </div>
                </div>
            </div>
    );
}