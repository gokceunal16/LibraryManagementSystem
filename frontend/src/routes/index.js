import React from 'react';
import {Navigate, Route, Routes} from "react-router";
import NotFound from "../pages/NotFound";
import Dashboard from "../pages/Dashboard";
import LibraryReservation from "../pages/LibraryReservation";
import DatabaseManager from "../pages/Books/DatabaseManager";
import BorrowingRecords from "../pages/Borrowings/BorrowingRecords";
import BorrowingReports from "../pages/Borrowings/BorrowingReports";
import Login from "../pages/LogIn";
import SignUp from "../pages/SignUp";
import ProtectedRoute from "./ProtectedRoute";
import BookDetailPage from "../pages/Books/BookDetails";
import BookSearchPage from "../pages/Books/BookSearch";
import History from "../pages/Users/History";


const Index = () => {

    const ROLES = {
        "admin": 1,
        "user": 2
    }

    return (
        <Routes>
            <Route path="/" element={<Navigate to="/login"/>}/>
            {/*Public routes*/}
            <Route path={"/login"} element={<Login/>}></Route>

            <Route path={"/signup"} element={<SignUp/>}></Route>

            <Route path="*" element={<NotFound/>}/>

            <Route path="/dashboard" element={
                <Dashboard/>
            }/>

            <Route path="/library-reservation" element={
                <ProtectedRoute allowedRoles={[ROLES.user]}>
                    <LibraryReservation/>
                </ProtectedRoute>
            }/>

            <Route path="/history" element={
                <ProtectedRoute allowedRoles={[ROLES.user]}>
                    <History/>
                </ProtectedRoute>
            }/>
            <Route path="/db-manager" element={
                <ProtectedRoute allowedRoles={[ROLES.admin]}>
                    <DatabaseManager/>
                </ProtectedRoute>
            }/>
            <Route path="/book-details" element={
                <ProtectedRoute allowedRoles={[ROLES.user]}>
                    <BookDetailPage/>
                </ProtectedRoute>
            }/>

            <Route path="/book/:id" element={
                <ProtectedRoute allowedRoles={[ROLES.user]}>
                    <BookDetailPage/>
                </ProtectedRoute>
            } />

            <Route path="/book-search" element={
                <ProtectedRoute allowedRoles={[ROLES.user, ROLES.admin]}>
                <BookSearchPage/>
                </ProtectedRoute>
            }/>
            <Route path="/borrowing-records" element={
                <ProtectedRoute allowedRoles={[ROLES.admin]}>
                    <BorrowingRecords/>
                </ProtectedRoute>
            }/>

        </Routes>

    );
}

export default Index;