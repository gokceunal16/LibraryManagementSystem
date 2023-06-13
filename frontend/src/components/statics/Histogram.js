import React from 'react';
import { Chart } from '@antv/g2';

const Histogram = ({ books, name, container }) => {
    const chartContainerRef = React.useRef(null); // Use a ref to access the chart container element

    React.useEffect(() => {
        const sortedBooks = [...books].sort((a, b) => b.average_score - a.average_score).slice(0, 10);
        const data = sortedBooks.map((book) => ({
            title: book.title,
            average_score: book.average_score,
        }));

        const chart = new Chart({
            container: chartContainerRef.current, // Use the chart container ref here
            height: 270,
            width: 250,
        });

        chart.scale({
            title: {
                type: 'cat',
            },
            average_score: {
                type: 'linear',
                nice: true,
            },
        });

        chart.data(data);
        chart.interval().position('title*average_score').adjust('stack').color('title');
        chart.coordinate().transpose();
        chart.render();

        return () => {
            chart.destroy();
        };
    }, [books]);

    const chartContainerId = `histogram-container-${container}`;
    const title = name;

    return (
        <div style={{textAlign:'center', color:'gray'}}>
            {title}
            <div id={chartContainerId} ref={chartContainerRef}  style={{marginTop:'1rem'}}/>
        </div>
    );

};

export default Histogram;
