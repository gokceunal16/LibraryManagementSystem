import React, { useState } from 'react';
import { Table, Button, Modal, Form, Input } from 'antd';

const UserTable = ({ columns }) => {
    const [data, setData] = useState([]);
    const [visible, setVisible] = useState(false);
    const [form] = Form.useForm();

    // Handle delete action
    const handleDelete = (key) => {
        const updatedData = data.filter((item) => item.key !== key);
        setData(updatedData);
    };

    // Handle form submission
    const handleFormSubmit = () => {
        form.validateFields().then((values) => {
            const newData = {
                key: Date.now(),
                ...values,
            };
            setData([...data, newData]);
            form.resetFields();
            setVisible(false);
        });
    };

    // Open modal for adding a new person
    const showModal = () => {
        setVisible(true);
    };

    // Close modal
    const handleCancel = () => {
        form.resetFields();
        setVisible(false);
    };

    return (
        <div>
            <Button onClick={showModal} type="primary" style={{ marginBottom: 16 }}>
                Add New Person
            </Button>
            <Table columns={columns} dataSource={data} />

            <Modal
                visible={visible}
                title="Add New Person"
                okText="Add"
                onCancel={handleCancel}
                onOk={handleFormSubmit}
            >
                <Form form={form} layout="vertical">
                    {columns.map((column) => (
                        <Form.Item
                            key={column.dataIndex}
                            label={column.title}
                            name={column.dataIndex}
                            rules={[
                                { required: true, message: `Please enter a ${column.title.toLowerCase()}` },
                            ]}
                        >
                            <Input />
                        </Form.Item>
                    ))}
                </Form>
            </Modal>
        </div>
    );
};

export default UserTable;
