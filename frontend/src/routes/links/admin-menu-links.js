import React from "react";
import {
    BookOutlined,
    TeamOutlined,
    ReadOutlined, ShareAltOutlined, DashboardOutlined, LogoutOutlined,
} from "@ant-design/icons";
import {Link} from "react-router-dom";

const menuItems= (logout) => [
    {
        label:  <Link to="/dashboard">Dashboard</Link>,
        icon:<DashboardOutlined />,
        key: '1',
    },
    {
        label:  <Link to="/library-reservation">Library Reservation</Link>,
        icon: <BookOutlined />,
        key: '2',
    },
    {
        label: "Users",
        icon: <TeamOutlined />,
        key: 'sub1',
        children: [
            {
                label:  <Link to="/user-records">User Records</Link>,
                key: '4',
            },
            {
                label:  <Link to="/user-reports">Reports</Link>,
                key: '3',
            },
        ],
    },
    {
        label: "Books",
        icon: <ReadOutlined />,
        key: 'sub2',
        children: [
            {
                label:  <Link to="/book-records">Book Records</Link>,
                key: '5',
            },
            {
                label:  <Link to="/book-reports">Reports</Link>,
                key: '6',
            },
        ],
    },
    {
        label: "Borrowings",
        icon: <ShareAltOutlined />,
        key: 'sub3',
        children: [
            {
                label:  <Link to="/borrowing-records">Borrowing Records</Link>,
                key: '7',
            },
            {
                label:  <Link to="/borrowing-reports">Reports</Link>,
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

export default menuItems;
