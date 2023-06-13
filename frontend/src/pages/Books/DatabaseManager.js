import React from 'react';
import DashboardLayout from "../../components/common/DashboardLayout";
import TableOperations from "../../services/TableOperations";
import Tabs from "../../components/Tabs";

const DatabaseManager = () => {
    return (
        <DashboardLayout>
            <Tabs/>
        </DashboardLayout>
    );
};

export default DatabaseManager;