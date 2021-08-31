import React from 'react';

const currentDate = new Date();
var year = currentDate.getFullYear(); 

function Footer() {
    return (
        <span>
            <footer><p>Copyright Ⓒ{year}</p></footer>
        </span>
    )
}

export default Footer;