import React, {useEffect, useState} from 'react';
import Services from "./Services";
import Table from "../components/Table";
import {useAuth} from "../utils/hooks/useAuth";

const TableOperations = (props) => {

    const [list, setList] = useState([]);
    const [listOnUpdate, setListOnUpdate] = useState(false);
    const {token}=useAuth();

    const handleUpdate = () => {
        setListOnUpdate(!listOnUpdate);
        console.log("update durumu değişti:", listOnUpdate)
    }
    useEffect(() => {
        // declare the data fetching function
        Services.getTable(props.tableName, token)
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