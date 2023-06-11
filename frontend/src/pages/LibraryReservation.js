import React from 'react';
import DashboardLayout from "../components/common/DashboardLayout";
import ReservationTable from "../components/ReservationTable";

const LibraryReservation = () => {
    return (
        <DashboardLayout>
            <ReservationTable/>
        </DashboardLayout>
    );
};

export default LibraryReservation;