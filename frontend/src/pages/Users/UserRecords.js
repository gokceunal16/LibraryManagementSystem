import React from 'react';
import TableOperations from "../../services/TableOperations";
import DashboardLayout from "../../components/common/DashboardLayout";

const UserRecords = () => {
    return (
        <DashboardLayout>
            <TableOperations tableName='users' />
        </DashboardLayout>
    );
};

export default UserRecords;