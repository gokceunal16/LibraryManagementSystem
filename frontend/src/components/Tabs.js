import * as React from 'react';
import PropTypes from 'prop-types';
import Tabs from '@mui/material/Tabs';
import Tab from '@mui/material/Tab';
import Typography from '@mui/material/Typography';
import Box from '@mui/material/Box';
import Services from "../services/Services";
import {useEffect, useState} from "react";
import TableOperations from "../services/TableOperations";

function TabPanel(props) {

    const {children, value, index, ...other} = props;

    return (<div
        role="tabpanel"
        hidden={value !== index}
        id={`simple-tabpanel-${index}`}
        aria-labelledby={`simple-tab-${index}`}
        {...other}
    >
        {value === index && (<Box sx={{p: 2}}>
            <Typography>{children}</Typography>
        </Box>)}
    </div>);
}

TabPanel.propTypes = {
    children: PropTypes.node, index: PropTypes.number.isRequired, value: PropTypes.number.isRequired,
};

function a11yProps(index) {
    return {
        id: `simple-tab-${index}`, 'aria-controls': `simple-tabpanel-${index}`,
    };
}

const TabsComponent = () => {
    const [value, setValue] = useState(0);
    const [tableNames, setTableNames] = useState([]);
    useEffect(() => {
        Services.getTableNames().then(response => {
            console.log(response.data)
            setTableNames(response.data);

        })
            .catch(error => {
                console.log('Error fetching table names:', error);
            });
    }, [])

    const handleChange = (event, newValue) => {
        setValue(newValue);
    };

    return (<Box sx={{width: '100%'}}>
        <Box sx={{borderBottom: 1, borderColor: 'divider'}}>
            <Tabs value={value} onChange={handleChange} variant="scrollable"
                  scrollButtons="auto" aria-label="scrollable auto tabs example">

                {tableNames.map((item, index) => (
                    <Tab key={item.name} label={
                        <Typography sx={{textTransform: 'none'}}>{item.name}</Typography>
                    } {...a11yProps(index)} />
                ))}
            </Tabs>
        </Box>
        {tableNames.map((item, index) => (
            <TabPanel key={item.name} value={value} index={index}>
                <TableOperations tableName={item.name}/>
            </TabPanel>
        ))}


    </Box>);
}
export default TabsComponent;