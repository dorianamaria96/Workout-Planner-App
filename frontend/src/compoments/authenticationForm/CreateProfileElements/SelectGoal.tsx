import "./../styles.css"

interface SelectGoalProps {
    goals: string[];
  }

export default function SelectGoal({goals}: SelectGoalProps) {
  return (
    <>
    <div className="goal-title">Select your goals</div>
     {goals.map((goal:string) =>
        
        <div key={goal} className="goal-holder">
        <input type="radio" name={goal} id={goal} value={goal} />
        <label className='goal' htmlFor={goal}>{goal.charAt(0).toUpperCase() + goal.slice(1).toLowerCase().replace(/_/g, ' ')}</label>
        </div>
      )}
    </>
  );
}
