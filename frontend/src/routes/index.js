import React from 'react';
import {Navigate, Redirect, Route, Routes} from "react-router";
import NotFound from "../pages/NotFound";
import Dashboard from "../pages/Dashboard";
import LibraryReservation from "../pages/LibraryReservation";
import UserReports from "../pages/Users/UserReports";
import BookRecords from "../pages/Books/BookRecords";
import UserRecords from "../pages/Users/UserRecords";
import BookReports from "../pages/Books/BookReports";
import BorrowingRecords from "../pages/Borrowings/BorrowingRecords";
import BorrowingReports from "../pages/Borrowings/BorrowingReports";
import Login from "../pages/LogIn";
import SignUp from "../pages/SignUp";
import ProtectedRoute from "./ProtectedRoute";


function Index() {

    const ROLES = {
        "LIB-ONE": "Admin",
        "LIB-TWO": "User"
    }

    return (

        <Routes>
           <Route path="/" element={<Navigate to="/login" />} />
            {/*Public routes*/}
            <Route path={"/login"} element={<Login/>}></Route>

            <Route path={"/signup"} element={<SignUp/>}></Route>

            <Route path="*" element={<NotFound/>}/>

            <Route path="/dashboard" element={

                <Dashboard/>
            }/>

            <Route path="/library-reservation" element={
                <LibraryReservation/>
            }/>
            <Route path="/user-records" element={
                <UserRecords/>
            }/>
            <Route path="/user-reports" element={
                <UserReports/>
            }/>
            <Route path="/book-records" element={
                <BookRecords/>
            }/>
            <Route path="/book-reports" element={
                <BookReports/>
            }/>
            <Route path="/borrowing-records" element={
                <BorrowingRecords/>
            }/>
            <Route path="/borrowing-reports" element={
                <BorrowingReports/>
            }/>


        </Routes>

    );
}

export default Index;