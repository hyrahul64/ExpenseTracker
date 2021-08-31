import React from 'react'

function Login() {
    return (
        <form className = "login">
            <h2>Login</h2>
            <div><input className = "login-input" type = "edit" placeholder="Username"/></div>
            <div><input className = "login-input" type = "password" placeholder="Password"/></div>
            <div><input className = "login-input" type = "password" placeholder="Confirm password"/></div>
        </form>
    )
}

export default Login;