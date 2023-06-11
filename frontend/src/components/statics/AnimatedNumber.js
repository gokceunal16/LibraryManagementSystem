import {Col, Row, Statistic} from 'antd';
import CountUp from 'react-countup';

const formatter = (value) => <CountUp end={value} separator=","/>;
const AnimatedNumber = (props) => (
            <Statistic title={props.title} value={props.value} precision={2} formatter={formatter}/>
);
export default AnimatedNumber;