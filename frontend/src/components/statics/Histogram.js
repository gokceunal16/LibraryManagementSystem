import React from 'react';
import { Chart } from '@antv/g2';


const books = [
    { title: 'Books 1', rating: 4.5 },
    { title: 'Books 2', rating: 4.2 },
    { title: 'Books 3', rating: 4.8 },
    { title: 'Books 4', rating: 4.1 },
    { title: 'Books 5', rating: 4.9 },
    { title: 'Books 6', rating: 4.6 },
    { title: 'Books 7', rating: 4.3 },
    { title: 'Books 8', rating: 4.7 },
    { title: 'Books 9', rating: 4.4 },
    { title: 'Books 10', rating: 4.0 },
];

const Histogram = () => {
    React.useEffect(() => {
        // Sort the books by rating in descending order
        const sortedBooks = books.sort((a, b) => b.rating - a.rating).slice(0, 10);

        // Prepare the data for the histogram
        const data = sortedBooks.map((book) => ({
            title: book.title,
            rating: book.rating,
        }));

        // Create a new G2 chart
        const chart = new Chart({
            container: 'histogram-container',
            height: 270,
            width: 250
        });

        chart.scale({
            title: {
                type: 'cat',
            },
            rating: {
                type: 'linear',
                nice: true,
            },
        });
        // Set the chart data
        chart.data(data);

        // Create the histogram
        chart
            .interval()
            .position('title*rating')
            .adjust('stack')
            .color('title');

        chart.coordinate().transpose()
        // Render the chart
        chart.render();
        // Clean up the chart when the component unmounts
        return () => {
            chart.destroy();
        };

    }, [books]);

    return <div id="histogram-container" />;
};

export default Histogram;
