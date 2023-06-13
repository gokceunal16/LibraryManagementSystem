import {Layout, Menu, Spin, theme} from 'antd';
import React, {useEffect, useState} from 'react';
import {useAuth} from "../../utils/hooks/useAuth";
import {Link} from "react-router-dom";
import {
    BookOutlined,
    DashboardOutlined, DeploymentUnitOutlined,
    LogoutOutlined,
    ReadOutlined,
    ShareAltOutlined,
    TeamOutlined
} from "@ant-design/icons";

const {Header, Content, Footer, Sider} = Layout;


const DashboardLayout = (props) => {
    const [collapsed, setCollapsed] = useState(false);
    const [loading, setLoading] = useState(true);
    const {userRole, logout} = useAuth();

    const adminMenu = [
        {
            label: <Link to="/dashboard">Dashboard</Link>,
            icon: <DashboardOutlined/>,
            key: '1',
        },
        {
            label: <Link to="/db-manager">Manage Database</Link>,
            icon:<DeploymentUnitOutlined/>,
            key: '5',
        },

        {
            label: "Borrowings",
            icon: <ShareAltOutlined/>,
            key: 'sub3',
            children: [
                {
                    label: <Link to="/borrowing-records">Borrowing Records</Link>,
                    key: '8',
                },
            ],
        },
        {
            label: <div onClick={logout}> Logout</div>,
            icon: <LogoutOutlined/>,
            key: '10'
        }
    ];
    const userMenu =  [
        {
            label: <Link to="/dashboard">Dashboard</Link>,
            icon: <DashboardOutlined/>,
            key: '1',
        },
        {
            label: <Link to="/library-reservation">Library Reservation</Link>,
            icon: <BookOutlined/>,
            key: '2',
        },
        {
            label: <Link to="/book-search">Book Search</Link>,
            icon: <ReadOutlined/>,
            key: '5'

        },
        {
            label: <Link to="/history">History</Link>,
            key: '33',
        },
        {
            label: <div onClick={logout}> Logout</div>,
            icon: <LogoutOutlined/>,
            key: '10'
        }
    ];

    const {
        token: {colorBgContainer},
    } = theme.useToken();
    return (
        <Layout
            style={{
                minHeight: '100vh',
            }}
        >

            <Sider style={{
                padding: '16px 0',
            }} collapsible collapsed={collapsed} onCollapse={(value) => setCollapsed(value)}>
                <div style={{
                    marginBottom: '16px',
                    color:'lightgray',
                    textWeight:'900',
                    textAlign:'center'
                }}>
                    BBM473 LIBRARY SYSTEM
                </div>
                <Menu theme="dark" defaultSelectedKeys={['1']} mode="inline" items={userRole===1 ? adminMenu : userMenu
                }/>
            </Sider>
            <Layout>

                <Content
                    style={{
                        margin: '32px 0',
                    }}
                >

                    <div
                        style={{
                            padding: '3rem',
                            minHeight: 360,
                            background: colorBgContainer,
                        }}
                    >
                        {props.children}
                    </div>
                </Content>
                <Footer
                    style={{
                        textAlign: 'center',
                    }}
                >
                    Library Management System ©2023 Created by KütüpGang
                </Footer>
            </Layout>
        </Layout>
    );
};
export default DashboardLayout;