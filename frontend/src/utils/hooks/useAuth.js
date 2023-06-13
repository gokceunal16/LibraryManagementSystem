import React, {createContext, useContext, useMemo} from "react";
import {useLocalStorage} from "./useLocalStorage";
import {useNavigate} from "react-router";
import {message} from "antd";
import axios from "axios";


const AuthContext = createContext();

export const AuthProvider = ({children}) => {
        const [token, setToken] = useLocalStorage("token", null);
        const [user, setUser] = useLocalStorage("user", null);
        const [userRole, setUserRole] = useLocalStorage("role", null);
        const navigate = useNavigate();


    const login = async (data) => {
            const response = await axios.post("http://localhost:8080/auth/login", data).then(console.log("oldu"));

            if (response.status === 200) {
                setToken(response.data.token);
                setUserRole(response.data.role_id);
                setUser(response.data.user_id);
                message.success("Login Successful!");
                navigate("/dashboard", {replace: true})
            }

        };

        const logout = () => {
            setToken(null);
            setUser(null);
            setUserRole(null)
            message.success("Logout Successful!")
            navigate("/login", {replace: true});
        };

        const value = useMemo(
            () => ({
                token,
                user,
                setUser,
                userRole,
                login,
                logout
            }),
            [token, user]
        );

        return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
    }
;

export const useAuth = () => {
    return useContext(AuthContext);
};