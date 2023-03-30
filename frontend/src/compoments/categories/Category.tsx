import './styles.css'
import { useState } from 'react';
import Filter from './Filters';
import Exercises from '../exercises/Exercises'
import Exercise from '../exercises/Exercise'

interface CategoryProps {
    category: string;
}

// interface ExercisesProps {
//     exercises: Exercise[];
// }

interface ExerciseObject {
    exercise: ExerciseDetails;
}

interface ExerciseDetails {
    name: string,
    type: string,
    muscle: string,
    equipment: string,
    difficulty: string,
    instructions: string,
}

export default function Category({ category }: CategoryProps) {
    const exerciseObjectStructure = ['name', 'type', 'muscle', 'equipment', 'difficulty', 'instructions']

    const [filters, setFilters] = useState<string[]>();
    const [isHidden, setIsHidden] = useState<boolean>(true);
    const [exercises, setExercises] = useState<ExerciseDetails[]>([]);
    const [isHiddenExercises, setIsHiddenExercises] = useState<boolean>(true);

    function handleClick(key: string) {
        fetch(`http://localhost:8080/categories/${key}`)
            .then((response) => response.json())
            .then((data: string[]) => {
                setFilters(data)
                setIsHidden(!isHidden)
                if (isHiddenExercises == false && isHidden == true) {
                    setIsHiddenExercises(true)
                }
            })
            .catch((error) => console.error(error));
    }

    function handleFilter(filter: string) {
        const chosenFilter = {
            parameter: category,
            value: filter
        }


        fetch(`http://localhost:8080/categories/chosenFilter/${chosenFilter.parameter}/${chosenFilter.value}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            },
        })
            .then(response => response.json())
            .then((data: ExerciseDetails[]) => {
                setIsHiddenExercises(false)
                setExercises(data)
            })
    }

    const exerciseBeispiel = {
        name: "name",
        type: "type",
        muscle: "muscle",
        equipment: "equipment",
        difficulty: "difficutly",
        instructions: "instructions",
    }


    console.log("EXERCISES ", exerciseBeispiel)
    exercises?.map((exercise: ExerciseDetails) => {
        console.log("HERE U HAVE THE EXERCISESE; Bro", exercise.name)
    })
    console.log("IS HIDDEN OR NOT ", isHiddenExercises)
    //exercises?.map((exercise) => console.log("SINGLE EXERCISES", exercise.exercise.instructions))
    return (
        <div className='categories'>
            <>
                {/* <Exercise exercise={exerciseBeispiel}></Exercise> */}

                <button onClick={() => handleClick(category)} className='category' key={category}>{category.replace(/\b\w/g, c => c.toUpperCase())}</button>
                {!isHidden && (
                    <div className='filters'>
                        {filters?.map((filter) => (
                            <Filter onClick={() => handleFilter(filter)} key={filter} filter={filter} />
                        ))}


                    </div>
                )}

                {!isHiddenExercises && (



                    exercises.map((exercise) => (
                        <Exercise key={exercise.name} exercise={exercise} />
                    ))


                )}
            </>
        </div>

    );
}