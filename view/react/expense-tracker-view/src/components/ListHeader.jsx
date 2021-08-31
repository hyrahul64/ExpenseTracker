import React from 'react';
import HeaderItem from './HeaderItem';

function ListHeader() {
    return(
        <div className = "header">
            <HeaderItem header = "Idx" width = "70px"/>
            <HeaderItem header = "Description" width = "220px" sortable = "true" filterable = "true"/>
            <HeaderItem header = "Cost" width = "120px" sortable = "true" filterable = "true"/>
            <HeaderItem header = "Date" width = "140px" sortable = "true" filterable = "true"/>
            <HeaderItem header = "Type" width = "120px" filterable = "true"/>
            <HeaderItem header = "Edit" width = "50px"/>
            <HeaderItem header = "Delete" width = "50px"/>
        </div>
    );
}

export default ListHeader;