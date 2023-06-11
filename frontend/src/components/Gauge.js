import React, { useEffect } from 'react';
import { Chart, registerShape } from '@antv/g2';

function GaugeChart({ value }) {
    useEffect(() => {
        // Register custom Shape
        registerShape('point', 'pointer', {
            draw(cfg, container) {
                const group = container.addGroup({});
                const center = this.parsePoint({ x: 0, y: 0 });

                group.addShape('line', {
                    attrs: {
                        x1: center.x,
                        y1: center.y,
                        x2: cfg.x,
                        y2: cfg.y,
                        stroke: '#0086FA',
                        lineWidth: 3,
                        lineCap: 'round',
                    },
                });

                group.addShape('circle', {
                    attrs: {
                        x: center.x,
                        y: center.y,
                        r: 6,
                        stroke: '#0086FA',
                        lineWidth: 4.5,
                        fill: '#fff',
                    },
                });

                return group;
            },
        });

        const chart = new Chart({
            container: 'container',
            autoFit: true,
            height: 180,
            padding: [0, 0, 20, 0],
        });

        chart.data([{ value }]);
        chart.animate(false);

        chart.coordinate('polar', {
            startAngle: (-9 / 8) * Math.PI,
            endAngle: (1 / 8) * Math.PI,
            radius: 0.80,
        });

        chart.scale('value', {
            min: 0,
            max: 6,
            tickInterval: 1,
        });

        chart.axis('1', false);
        chart.axis('value', {
            line: null,
            label: {
                offset: -40,
                style: {
                    fontSize: 14,
                    fill: '#CBCBCB',
                    textAlign: 'center',
                    textBaseline: 'middle',
                },
            },
            tickLine: {
                length: -16,
            },
            grid: null,
        });

        chart.legend(false);
        chart.tooltip(false);

        chart
            .point()
            .position('value*1')
            .shape('pointer')
            .color('#0086FA');

        draw();

        function draw() {
            const val = value;
            const lineWidth = 15;
            chart.annotation().clear(true);

            chart.annotation().arc({
                top: false,
                start: [0, 1],
                end: [6, 1],
                style: {
                    stroke: '#CBCBCB',
                    lineWidth,
                    lineDash: null,
                },
            });

            chart.annotation().arc({
                start: [0, 1],
                end: [val, 1],
                style: {
                    stroke: '#0086FA',
                    lineWidth,
                    lineDash: null,
                },
            });

            chart.annotation().text({
                position: ['50%', '85%'],
                content: 'Fullness',
                style: {
                    fontSize: 18,
                    fill: '#545454',
                    textAlign: 'center',
                },
            });

            chart.annotation().text({
                position: ['50%', '90%'],
                content: `${val * 10} %`,
                style: {
                    fontSize: 20,
                    fill: '#545454',
                    textAlign: 'center',
                },
                offsetY: 15,
            });

            chart.render();
        }

        return () => {
            chart.destroy();
        };
    }, [value]);

    return <div id="container" />;
}

export default GaugeChart;
