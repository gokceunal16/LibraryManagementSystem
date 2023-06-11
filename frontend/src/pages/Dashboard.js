import React, {useEffect, useState} from 'react';
import {Card, Row, Col} from 'antd';
import DashboardLayout from "../components/common/DashboardLayout";
import AnimatedNumber from "../components/statics/AnimatedNumber";
import GaugeChart from "../components/Gauge";
import Histogram from "../components/statics/Histogram";
import BagelChart from "../components/statics/BagelChart";
import RoomNamesList from "../components/statics/List";
import Services from "../services/Services";
import {useAuth} from "../utils/hooks/useAuth";

const Dashboard = () => {
    const [countList, setCountList] = useState([]);
    const {token, user} = useAuth();

    useEffect(() => {
        console.log(token)
        // declare the data fetching function
        Services.getCounts(token)
            .then((res) => {
                console.log(res.data);
                //setCountList(res.data);
            }).catch(console.error);

    }, [])


    const availableBooks = [
        // Pie chart: These operations will come from SQL
        {type: 'Currently Available Physical Books', value: 50},
        {type: 'Borrowed Books', value: 30},
    ];

    const availableNewspapers = [
        // Pie chart: These operations will come from SQL
        {type: 'Currently Available Newspapers', value: 50},
        {type: 'Borrowed Newspapers', value: 30},
    ];

    return (
        <DashboardLayout>
            <Row gutter={[16, 16]}>
                <Col span={6}>
                    <Card>
                        <AnimatedNumber value={3321} title="Number of Users"/>
                    </Card>
                </Col>
                <Col span={6}>
                    <Card>
                        <AnimatedNumber value={3321} title="Number of Books"/>
                    </Card>
                </Col>
                <Col span={6}>
                    <Card>
                        <AnimatedNumber value={3321} title="Number of Newspapers"/>
                    </Card>
                </Col>
                <Col span={6}>
                    <Card>
                        <AnimatedNumber value={3321} title="Number of Available Books"/>
                    </Card>
                </Col>
            </Row>
            <br/>
            <Card >

                <Row justify="space-between">
                    <Col className="gutter-row" span={6}>
                        <BagelChart data={availableBooks} id={4} chartName='Book Availability' name={'available-books'}
                                    colorList={['#1976D2', '#64B5F6']}/>
                    </Col>
                    <Col className="gutter-row" span={6}>

                        <BagelChart data={availableNewspapers} id={3} chartName='Newspaper Availability'
                                    name={'available-newspaper'} colorList={['#39A57D', '#83D5C0']
                        }/>
                    </Col>
                    <Col className="gutter-row" span={6}>
                        <BagelChart data={availableBooks} id={2} chartName='Smth Availability' name={'available-smth'}
                                    colorList={['#9F82FF', '#D9C5FF']
                                    }/>
                    </Col>
                    <Col className="gutter-row" span={6}>
                        <BagelChart data={availableNewspapers} id={1} chartName='Smth2 Availability'
                                    name={'available-smth2'} colorList={['#FF6B8E', '#FFD591']}/>
                    </Col>
                </Row>

            </Card>
            <br/>


            <Row gutter={[16, 16]}>
                <Col span={12}>
                    <Card>
                        <RoomNamesList/>
                    </Card>
                </Col>
                <Col span={12}>
                    <Card>
                        <GaugeChart value={0.5}/>
                    </Card>
                </Col>
            </Row>

            <Row gutter={[16, 16]}>
                <Col span={24}>
                    <Card>
                        <Histogram/>
                    </Card>
                </Col>
            </Row>
        </DashboardLayout>
    )
        ;
};

export default Dashboard;
