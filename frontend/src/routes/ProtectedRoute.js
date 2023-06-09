import React from "react";
import {Navigate} from "react-router";
import {useAuth} from "../utils/hooks/useAuth";
import {useLocation} from "react-router-dom";

export const ProtectedRoute = ({allowedRoles, children}) => {
    const {token, userRole} = useAuth();
    const {state} = useLocation();
    if (!token) {
        return <Navigate to="/login" replace/>;
    } else {
        const checkRole = allowedRoles.includes(userRole)
        if (!checkRole) {
            return <Navigate to="/" state={state} replace/>;
        } else {
            return children;
        }
    }
}


export default ProtectedRoute;