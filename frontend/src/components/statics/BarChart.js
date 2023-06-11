import React from 'react';
import {Bar} from "@ant-design/charts"
const data = [
    { year: 'book1', value: 3 },
    { year: 'book2', value: 4 },
    { year: 'book3', value: 3.5 },
    { year: 'book4', value: 5 },
    { year: 'book5', value: 4.9 },
    { year: 'book6', value: 6 },
    { year: 'book7', value: 7 },
    { year: 'book8', value: 9 },
    { year: 'book9', value: 13 },
];
const BarChart = (props) => {
    const config = {
        data,
        height: 400,
        xField: {props},
        yField: {props},
    };
    return <Bar {...config} />;
};

export default BarChart;