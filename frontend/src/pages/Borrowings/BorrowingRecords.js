import React from 'react';
import DashboardLayout from "../../components/common/DashboardLayout";
import TableOperations from "../../services/TableOperations";

const BorrowingRecords = () => {
    return (
        <DashboardLayout>
            <TableOperations tableName='borrowings' />
        </DashboardLayout>    );
};

export default BorrowingRecords;