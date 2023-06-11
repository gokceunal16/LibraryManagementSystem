import React from 'react';
import {Button, Result} from "antd";
import {useNavigate} from "react-router";
import {useLocation} from "react-router-dom";

function NotFound() {
    const navigate = useNavigate();
    const {state} = useLocation();
    const backHome = () => {
        navigate(-1, {replace: true}, {state: state})
    }
    return (
        <div style={{display: "flex", alignItems: "center", justifyContent: "center", height: "100vh"}}>
            <Result
                status="500"
                title="500"
                subTitle="Sorry, page you're looking for does not exist."
                extra={<Button type="primary" onClick={backHome}>Geri Dön</Button>}
            /></div>
    );
}

export default NotFound;