import React, { useState, useEffect } from 'react';
import './styles.css'


export default function Categories() {
    const [categories, setCategories] = useState<string[]>();
    const [filters, setFilters] = useState<string[]>();

    useEffect(() => {
        fetch('http://localhost:8080/categories')
            .then((response) => response.json())
            .then((data: string[]) => {
                setCategories(data);
            })
            .catch((error) => console.error(error));
    }, []);


    function handleClick(key: string) {
        fetch(`http://localhost:8080/categories/${key}`)
            .then((response) => response.json())
            .then((data: string[]) => {
                console.log(data)
            })
            .catch((error) => console.error(error));
    }

    return (
        <div>
            <div>Filter exercises by:</div>
            <div className='buttons'>
                {categories?.map((category) => (
                    <button onClick={() => handleClick(category)} className='exercise' key={category}>{category}</button>
                ))}
            </div>
        </div>
    );
}
