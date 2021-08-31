import React from 'react';
import DeleteIcon from '@material-ui/icons/Delete';
import EditIcon from '@material-ui/icons/Edit';

function handleEdit() {
    console.log("edit clicked!");
}

function handleDelete(props) {
    console.log("delete clicked!" + props.index);
    props.onDelete(props.index);
}

function ListItem(props) {
    return (
        <div className = "expense-list-item">
            <span className = "expense-list-item-col" style = {{minWidth : "70px"}}>{props.index+1}</span>
            <span className = "expense-list-item-col" style = {{minWidth : "220px", maxWidth : "220px"}}>{props.description}</span>
            <span className = "expense-list-item-col" style = {{minWidth : "120px", maxWidth : "120px"}}>{props.cost}</span>
            <span className = "expense-list-item-col" style = {{minWidth : "140px"}}>{props.date}</span>
            <span className = "expense-list-item-col" style = {{minWidth : "120px"}}>{props.type}</span>
            <span className = "expense-list-item-col" style = {{minWidth : "50px"}}><EditIcon onClick = {() => handleEdit(props.index)}/></span>
            <span className = "expense-list-item-col" style = {{minWidth : "50px"}}><DeleteIcon onClick = {() => handleDelete(props)}/></span>
        </div>
    );
}

export default ListItem;