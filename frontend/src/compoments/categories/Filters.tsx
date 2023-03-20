import './styles.css'

interface FilterProps {
    filter: string;
    onClick: (key: string) => void;
}

export default function Filter(props: FilterProps) {

    function handleClick() {
        props.onClick(props.filter);
      }

    return (
        <button onClick={() => handleClick()} className='filter'> {props.filter.replace(/\b\w|_/g, c => c === '_' ? ' ' : c.toUpperCase())} </button>
    );
}