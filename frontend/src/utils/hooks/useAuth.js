import React, {createContext, useContext, useMemo} from "react";
import {useLocalStorage} from "./useLocalStorage";
import {useNavigate} from "react-router";
import {message} from "antd";
import axios from "axios";

const AuthContext = createContext();

export const AuthProvider = ({children}) => {
        const [token, setToken] = useLocalStorage("token", null);
        const [user, setUser] = useLocalStorage("user", null);
        const navigate = useNavigate();

        const login = async (data) => {
            const response = await axios.post("http://localhost:8080/auth/login", data).then(console.log("oldu"));
            console.log("response", response);
            message.success("Login Successful!")

            if (response.status === 200) {
                setToken(response.data.token);
                // setUser(response.data.id);
            }

            if (response.data.role === ("User")) {
                navigate("/dashboard", {replace: true})

            } else {
                navigate("/dashboard", {replace: true})
            }

        };

        const logout = () => {
            setToken(null);
            setUser(null);
            message.success("Logout Successful!")
            navigate("/login", {replace: true});
        };

        const value = useMemo(
            () => ({
                token,
                user,
                setUser,
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