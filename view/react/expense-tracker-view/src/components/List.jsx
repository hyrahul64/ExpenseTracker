import React, {useEffect, useState} from 'react';
import axios from 'axios';
import ListItem from './ListItem';
import ListHeader from './ListHeader';

function List() {

    const [expenses, setExpenses] = useState([]);
    const [loading, setLoading] = useState();
   
    function deleteItem(deletedIntemIndex) {
        console.log("list delete item");
        setExpenses( () => {return expenses.filter((item, index) => index !== deletedIntemIndex)});
    }

        useEffect(()=> {
        setLoading(true);
        axios.get("http://localhost:8080/api/expenses")
            .then(response => setExpenses(response.data))
            setLoading(false);
    },[]);

    return (
        <div>
            <h2>All expenses</h2>
            <div className = "expense-list">
                <ListHeader />
                {!loading && expenses.map((expense, itemIndex) => {
                    return (
                        <ListItem
                                key = {expense.id}
                                index = {itemIndex}
                                description = {expense.description}
                                cost = {expense.cost}
                                date = {expense.date}
                                type = {expense.type}
                                onDelete = {deleteItem}
                        />
                    );
                })}
            </div>
        </div>
    );
}

export default List;