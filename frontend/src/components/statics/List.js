import React from 'react';
import { Card, List } from 'antd';
import { EnvironmentOutlined } from '@ant-design/icons';

const RoomNamesList = () => {
    const roomNames = [
        { name: 'Room A', icon: <EnvironmentOutlined /> },
        { name: 'Room B', icon: <EnvironmentOutlined /> },
        { name: 'Room C', icon: <EnvironmentOutlined /> },
        { name: 'Room D', icon: <EnvironmentOutlined /> },
    ];

    return (
        <Card title="Currently Available Rooms">
            <List
                className="room-names-list"
                itemLayout="horizontal"
                dataSource={roomNames}
                renderItem={(item) => (
                    <List.Item>
                        <List.Item.Meta
                            avatar={item.icon}
                            title={item.name}
                        />
                    </List.Item>
                )}
            />
        </Card>
    );
};

export default RoomNamesList;
