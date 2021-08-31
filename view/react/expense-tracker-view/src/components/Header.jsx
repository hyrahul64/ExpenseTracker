import React from 'react';

function Header(props) {
    return (
        <header>
        <ul>
            {props.loggedIn && <li><a href =  "/add">Add Expense</a></li>}
            {props.loggedIn && <li><a href =  "/expenses">Show all expenses</a></li>}
            {props.loggedIn && <li><a href =  "/upload">Upload file</a></li>}
            {!props.loggedIn && <li><a href =  "/login">Login</a></li>}
            {!props.loggedIn && <li><a href =  "/register">Register</a></li>}
        </ul>
        </header>
    );
}

export default Header;