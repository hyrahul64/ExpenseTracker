import React from 'react';
import {useRoutes} from 'hookrouter';

import Detail from './Detail';
import UploadFile from './UploadFile';
import Login from './Login';
import Register from './Register'
import List from './List'

const routes = {
    '/add' : () => <Detail />,
    '/upload' : () => <UploadFile />,
    '/login' : () => <Login />,
    '/register' : () => <Register />,
    '/expenses' : () => <List />
};

function Body(props) {
    const routeResult = useRoutes(routes);

    console.log(props.loggedIn);
    return (
        <div className = "body">
            {routeResult}
        </div>
    );
}

export default Body;