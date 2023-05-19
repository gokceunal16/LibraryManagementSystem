import React, {useEffect, useState} from 'react';
import TableService from "./TableService";
import Table from "../components/Table";

const TableOperations = (props) => {

    const [list, setList] = useState([]);
    const [listOnUpdate, setListOnUpdate] = useState(false);

    const handleUpdate = () => {
        setListOnUpdate(!listOnUpdate);
        console.log("update durumu değişti:", listOnUpdate)
    }
    useEffect(() => {
        // declare the data fetching function
        TableService.getTable(props.tableName)
            .then((res) => {
                console.log(res.data);
                setList(res.data);
            }).catch(console.error);

    }, [listOnUpdate])

    console.log("list: ", list);

    if (list.length === 0) {
        // Render a loading state or placeholder while the data is being fetched
        return(
        <div style={{color:'darkslategray', margin:'1rem'}}>
            Loading...
        </div>
        );
    }

    return (
        <div style={{padding: '1rem'}}>
            <Table tableName={props.tableName} tableData={list} handleUpdate={handleUpdate}/>
        </div>
    );
};

export default TableOperations;