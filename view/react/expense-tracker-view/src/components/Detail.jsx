import React from 'react';
import CloseIcon from '@material-ui/icons/Close';

function Detail(props) {

    function handleClose() {
        console.log("Close clicked.");
        window.location.href = '../';
    }
    return(
        <div class  = "detail">
            <div class = "detail-front">
                <div class = "detail-front-close">
                    <CloseIcon onClick = {handleClose}/>
                </div>
                <form  class = "detail-form">
                    <div class = "detail-form-item">
                        <label>Description:</label>
                        <input name = "desc" id = "desc" placeholder ="Description" type="text" value = {props.description}/>
                    </div>

                    <div class = "detail-form-item">
                        <label>Cost:</label>
                        <input name = "cost" id = "cost" placeholder ="Cost" type="text" value = {props.cost}/>
                    </div>

                    <div class = "detail-form-item">
                        <label>Type:</label>
                        <select value = "Recurrent">
                            <option value="Necessary">Necessay</option>
                            <option value="Recurrent">Recurrent</option>
                            <option value="Default">Default</option>
                            <option value="Unnecessary">Unnecessary</option>
                        </select>
                    </div>

                    <div class = "detail-form-item">
                        <label>Date:</label>
                        <input name = "date" id = "date" placeholder ="Description" type="date" value = "{props.date}"/>
                    </div>
                    <div class = "detail-form-item">
                        <input value = "Add" type="submit"/>
                    </div>
                </form>
            </div>
        </div>
    );
}

export default Detail;