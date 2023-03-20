import React, { useState, useEffect } from 'react';
import Category from './Category';
import './styles.css'


export default function Categories() {
    const [categories, setCategories] = useState<string[]>();

    useEffect(() => {
        fetch('http://localhost:8080/categories')
            .then((response) => response.json())
            .then((data: string[]) => {
                setCategories(data);
            })
            .catch((error) => console.error(error));
    }, []);

    return (
        <div>
            <div className='filter-text'>Filter exercises by:</div>
            
                {categories?.map((category) => (
                    <Category category={category} key={category}/>
                ))}
       
        </div>
    );
}
