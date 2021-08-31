import React, {useState} from 'react';
import SortIcon from '@material-ui/icons/Sort';
import FilterListIcon from '@material-ui/icons/FilterList';
import ArrowDownwardIcon from '@material-ui/icons/ArrowDownward';
import ArrowUpwardIcon from '@material-ui/icons/ArrowUpward';


function HeaderItem(props) {
    var [sort, setSort] = useState(0);
    var [filter, setFilter] = useState(0);

    var SortIconName = ArrowUpwardIcon;

    function handleSort() {
        setSort((sort + 1)%3);
        console.log("Sort clicked! value:"+sort);
    } 
    function renderSort(SortIconName) {
        if(sort === 0) {
            SortIconName = SortIcon;
        } else if(sort === 1){
            SortIconName = ArrowUpwardIcon;
        } else if(sort === 2){
            SortIconName = ArrowDownwardIcon;
        }
        return <span><SortIconName  className = "header-item-icon" onClick = {handleSort} /></span>
    }  
    function handleFilter() {
        setFilter((filter + 1)%2);
        console.log("Filter clicked! value:"+filter);
    }
    function renderHeaderItem() {
        if(filter === 0) {
            return (
                <div>
                    <span className = "header-item-text" >{props.header}</span>
                    {props.sortable && renderSort(SortIconName)}
                    {props.filterable && <span ><FilterListIcon className = "header-item-icon" onClick = {handleFilter}/></span>}
                </div>
            );
        } else {
            return <span className = "header-item-edit"><input type ="button" placeholder = "Fiter text.."/></span>
        }
    }

    return(
        <span className = "header-item" style = {{minWidth : props.width}}>
            {renderHeaderItem()}
        </span>
    );
}

export default HeaderItem;