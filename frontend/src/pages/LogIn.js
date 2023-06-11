import React, {useState} from 'react';
import {Button, Card, Form, Input} from "antd";
import {LockOutlined, UserOutlined} from "@ant-design/icons";
import {useAuth} from "./../utils/hooks/useAuth";

function Login() {

    const [form, setForm] = useState({})
    const {login} = useAuth();


    const onFinish = (values) => {
        const user = {
                "email": values.email,
                "password": values.password
        }
        console.log("user:", user)
        login(user)
    };
    const handleFormChange = (event) => {
        setForm({
            ...form,
            [event.target.name]: [event.target.value]
        })
    }
    console.log("form", form)
    return (
        <div style={{width: "400px", margin: "8% auto"}}>
            <Card hoverable title={"LOGIN"} headStyle={{textAlign: "center"}}>
                <Form
                    onFinish={onFinish}
                    autoComplete="off"
                >
                    <Form.Item
                        name="email"
                        rules={[{required: true, message: 'Please enter your email'}]}
                    >
                        <Input
                            prefix={<UserOutlined className="site-form-item-icon"/>}
                            placeholder="Email" name="email"
                            value={form.email || ""}
                            onChange={event => handleFormChange(event)}/>
                    </Form.Item>
                    <Form.Item
                        name="password"
                        rules={[{required: true, message: 'Please enter your password!'}]}
                    >
                        <Input
                            prefix={<LockOutlined className="site-form-item-icon"/>}
                            type="password"
                            name="password"
                            value={form.password || ""}
                            placeholder="Password"
                            onChange={event => handleFormChange(event)}
                        />
                    </Form.Item>
                    <Form.Item  style={{textAlign: "center"}}>
                        <Button type="primary" htmlType="submit" style={{width: "100%", marginBottom:"1rem"}}>
                            Log in
                        </Button>
                        If you don't have an account <a href="/signup">register now!</a>
                    </Form.Item>
                </Form>
            </Card>
        </div>
    );
}

export default Login;