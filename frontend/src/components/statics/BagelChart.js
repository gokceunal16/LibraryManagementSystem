import React, {useEffect, useState} from 'react';
import {Chart} from '@antv/g2';

const BagelChart = (props) => {
    const containerId=props.name;
    useEffect(() => {
        // Create a new instance of the chart
        const chart = new Chart({
            container: containerId,
            forceFit: true,
            height: 200,
            width:150
        });

        // Set the data for the chart
        chart.data(props.data);

        // Configure the bagel chart
        chart.coordinate('theta', {
            radius: 0.8,
            innerRadius: 0.6, // Set innerRadius to create a bagel chart
        });
        chart.tooltip(true);
        chart.legend(true);
        chart
            .interval()
            .position('value')
            .color('type', props.colorList)
            .style({lineWidth: 1, stroke: '#fff'})
            .label('type', {offset: -15});

        // Render the chart
        chart.render();

        // Clean up the chart when the component is unmounted
        return () => {
            chart.destroy();
        };
    }, []);
    const containerStyle = {
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
        height: '100%',
    };

    return(
        <div>
            <div style={{textAlign:"center", color:"gray"}}>{props.chartName}</div>
        <div id={containerId} style={containerStyle} />
        </div>
    );
};

export default BagelChart;
