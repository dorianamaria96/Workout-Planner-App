import { useState } from 'react'
import './styles.css'

interface Exercise {
    exercise: ExerciseDetails
}

interface ExerciseDetails {
    name: string,
    type: string,
    muscle: string,
    equipment: string,
    difficulty: string,
    instructions: string,
}


export default function Exercise({ exercise }: Exercise) {

    //console.log('exercise prop:', exercise.name);

    const [isReadMore, setIsReadMore] = useState(true);
    const toggleReadMore = () => {
        setIsReadMore(!isReadMore);
    };


    return (
        <div className='exercises-holder'>
            <div className='exercise-title-holder'>
                <div className='standard-style-exercise exercise-name' style={{ marginBottom: '25px' }}>{exercise.name}</div>
                <div className='standard-style-exercise exercise-difficulty'>{(exercise.difficulty).replace(/\b\w|_/g, c => c === '_' ? ' ' : c.toUpperCase())}</div>
                <div className='muscle-container'>
                    <img src={"/media/muscle-icon.png"} className="muscle-image" alt="muscle-icon" />
                    <div className='exercise-muscle'>{(exercise.muscle).replace(/\b\w|_/g, c => c === '_' ? ' ' : c.toUpperCase())}</div>
                </div> 
            </div>


            <div className='item-holder-exercise'>
                <div className='custom-label-exercise'>Type of Exercise</div>
                <div className='standard-style-exercise exercise-type'>{(exercise.type).replace(/\b\w|_/g, c => c === '_' ? ' ' : c.toUpperCase())}</div>
            </div>
            <div className='item-holder-exercise'>
                <div className='custom-label-exercise'>Necessary Equipment</div>
                <div className='standard-style-exercise exercise-equipment'>
                <img src={"/media/barbell-icon.png"} className="barbell-image" alt="barbell-icon" />
                    {(exercise.equipment).replace(/\b\w|_/g, c => c === '_' ? ' ' : c.toUpperCase())}</div>
            </div>


            <div className='item-holder-exercise'>
                <div className='custom-label-exercise'>Instructions</div>

                {exercise.instructions.length < 350 ? (<div className='standard-style-exercise exercise-instructions'>{exercise.instructions}</div>) :

                    (isReadMore ?

                        <div className='standard-style-exercise exercise-instructions'>{exercise.instructions.slice(0, 350)}
                            <span onClick={toggleReadMore} className="read-or-hide">
                                <a className='show-hide-text'> ...read more</a>
                            </span></div> :

                        <div className='standard-style-exercise exercise-instructions'>{exercise.instructions}
                            <span onClick={toggleReadMore} className="read-or-hide">
                                <a className='show-hide-text'> show less</a>
                            </span></div>
                    )
                }

            </div>
        </div>
    );
}