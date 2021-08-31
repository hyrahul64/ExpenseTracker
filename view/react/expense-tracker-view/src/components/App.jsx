import React from 'react';

import Header from './Header';
import Footer from './Footer';
import Body from './Body';

const isLogin = false;

function App() {
    return(
        <div>
            <h1 style = {{textAlign:"center"}}>Expense Tracker Application</h1>
            <Header loggedIn = {isLogin}/>
            <Body loggedIn = {isLogin}/>
            <Footer />
        </div>
    );
}

export default App;


