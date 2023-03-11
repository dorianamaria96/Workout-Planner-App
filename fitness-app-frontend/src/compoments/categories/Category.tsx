import './styles.css'
import { useState } from 'react';
import Filter from './Filters';

interface CategoryProps {
    category: string;
}

export default function Category({ category }: CategoryProps) {

    const [filters, setFilters] = useState<string[]>();
    const [isHidden, setIsHidden] = useState<boolean>(true);

    function handleClick(key: string) {
        fetch(`http://localhost:8080/categories/${key}`)
            .then((response) => response.json())
            .then((data: string[]) => {
                setFilters(data)
                setIsHidden(!isHidden)
            })
            .catch((error) => console.error(error));
    }

    function handleFilter(filter: string) {
        const chosenFilter = {
            parameter: category,
            value: filter
        }
        fetch ('http://localhost:8080/categories/chosenFilter',{
            method: 'POST',
            headers: {
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(chosenFilter)
          })
            .then(response => response.json())
            .then(data => {
              console.log('Success:', data);
            })
            .catch((error) => {
              console.error('Error:', error);
            });
    }

    return (
        <div className='categories'>
            <button onClick={() => handleClick(category)} className='category' key={category}>{category.replace(/\b\w/g, c => c.toUpperCase())}</button>
            {!isHidden &&
                <div className='filters'>
                    {filters?.map((filter) => (<Filter onClick={() => handleFilter(filter)} key={filter} filter={filter}/>))
                }</div>}

        </div>
    );
}