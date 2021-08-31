import React from 'react'

function UploadFile() {
    return(
        <div>
            <form className = "login" action = "/handleUpload" method = "post" encType = "multipart/form-data">
                <h2>Upload expense file</h2>
                <div><input className = "login-input" type = "file" name = "filename" />
                <input className = "login-input" type = "submit" value = "Upload" /></div>
            </form>
        </div>
    );
}

export default UploadFile;