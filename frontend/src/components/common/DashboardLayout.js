import {Layout, Menu, theme} from 'antd';
import {useState} from 'react';
import menuItems from "../../routes/links/admin-menu-links";
import {useAuth} from "../../utils/hooks/useAuth";

const {Header, Content, Footer, Sider} = Layout;


const DashboardLayout = (props) => {
    const [collapsed, setCollapsed] = useState(false);
    const {user, logout} = useAuth();

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
                <Menu theme="dark" defaultSelectedKeys={['1']} mode="inline" items={menuItems(logout)}/>
            </Sider>
            <Layout>
                <Header
                    style={{
                        padding: 0,
                        background: colorBgContainer,
                    }}
                />
                <Content
                    style={{
                        margin: '0 16px',
                    }}
                >

                    <div
                        style={{
                            padding: 24,
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