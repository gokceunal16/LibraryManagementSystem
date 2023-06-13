import React, { useState } from 'react';
import {message, Button, Card, Form, Input, Row, Col } from 'antd';
import axios from "axios";

function SignUp() {
    const [form] = Form.useForm();
    const [registrationSuccess, setRegistrationSuccess] = useState(false);


    const signUp = async (values) => { // Create a custom React Hook function
        console.log('Received values:', values);
        try {
            const mappedValues = {
                first_name: values.firstName,
                last_name: values.lastName,
                email: values.email,
                password: values.password,
                phone: values.phoneNumber,
                city: values.city,
                street: values.street,
                postal_code: values.postalCode,
                role_id: 2,
            };
            const response = await axios.post(`http://localhost:8080/auth/register`, mappedValues);
            console.log(response);
            if (response.status === 200) {
                setRegistrationSuccess(true); // Set the success state variable to true
                message.success('Registration successful', 2, () => {
                    // Callback function to navigate to login page after displaying the success message
                    window.location.href = '/login';
                });
            }
        } catch (error) {
            console.error(error);
        }
    };

    const onFinish = (values) => {
        signUp(values); // Call the custom hook for form submission
    };

    return (
        <div style={{ width: '400px', margin: '8% auto' }}>
            <Card hoverable title="SIGN UP" headStyle={{ textAlign: 'center' }}>
                <Form form={form} onFinish={onFinish} autoComplete="off">
                    <Row gutter={8}>
                        <Col span={12}>
                            <Form.Item
                                name="firstName"
                                rules={[{ required: true, message: 'Please enter your first name' }]}
                            >
                                <Input placeholder="First Name" />
                            </Form.Item>
                        </Col>
                        <Col span={12}>
                            <Form.Item
                                name="lastName"
                                rules={[{ required: true, message: 'Please enter your last name' }]}
                            >
                                <Input placeholder="Last Name" />
                            </Form.Item>
                        </Col>
                        <Col span={12}>
                            <Form.Item
                                name="city"
                                rules={[{ required: true, message: 'Please enter your city' }]}
                            >
                                <Input placeholder="City" />
                            </Form.Item>
                        </Col>
                        <Col span={12}>
                            <Form.Item
                                name="street"
                                rules={[{ required: true, message: 'Please enter your street' }]}
                            >
                                <Input placeholder="Street" />
                            </Form.Item>
                        </Col>
                        <Col span={12}>
                            <Form.Item
                                name="postalCode"
                                rules={[{ required: true, message: 'Please enter your postal code' }]}
                            >
                                <Input placeholder="Postal Code" />
                            </Form.Item>
                        </Col>
                        <Col span={12}>
                            <Form.Item
                                name="phoneNumber"
                                rules={[{ required: true, message: 'Please enter your phone number' }]}
                            >
                                <Input placeholder="Phone Number" />
                            </Form.Item>
                        </Col>
                        <Col span={24}>
                            <Form.Item
                                name="email"
                                rules={[{ required: true, message: 'Please enter your email address' }]}
                            >
                                <Input placeholder="Email Address" />
                            </Form.Item>
                        </Col>
                        <Col span={24}>
                            <Form.Item
                                name="password"
                                rules={[{ required: true, message: 'Please enter your password' }]}
                            >
                                <Input.Password placeholder="Password" />
                            </Form.Item>
                        </Col>
                    </Row>
                    <Form.Item style={{ textAlign: 'center' }}>
                        <Button type="primary" htmlType="submit" style={{ width: '100%', marginBottom: '1rem' }}>
                            Sign Up
                        </Button>
                        Already have an account? <a href="/login">Login now!</a>
                    </Form.Item>
                </Form>
            </Card>
        </div>
    );
}

export default SignUp;
