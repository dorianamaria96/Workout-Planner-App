import Exercise from "./Exercise";

interface ExercisesProps {
  exercises: Exercise[];
}

interface Exercise {
  exercise: ExerciseDetails;
}

interface ExerciseDetails {
  difficulty: string;
  equipment: string;
  instructions: string;
  muscle: string;
  name: string;
  type: string;
}

export default function Exercises({ exercises }: ExercisesProps) {
  return (
    <>
      {exercises.map((exercise) => (
        <div key={exercise.exercise.name}>
          {/* <Exercise exercise={exercise.exercise} /> */}
        </div>
      ))}
    </>
  );
}
