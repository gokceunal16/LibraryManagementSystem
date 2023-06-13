import React, {useEffect, useState} from 'react';
import {Card, Row, Col, Spin, List} from 'antd';
import DashboardLayout from "../components/common/DashboardLayout";
import AnimatedNumber from "../components/statics/AnimatedNumber";
import Histogram from "../components/statics/Histogram";
import BagelChart from "../components/statics/BagelChart";
import Services from "../services/Services";
import {useAuth} from "../utils/hooks/useAuth";

const Dashboard = () => {
    const [countList, setCountList] = useState([]);
    const [availabilityList, setAvailabilityList] = useState([]);
    const [roomNames, setRoomNames] = useState([]);
    const [allTimesHighestRated, setAllTimesHighestRated] = useState([]);
    const [threeMonthsHighestRated, setThreeMonthsHighestRated] = useState([]);
    const [loading, setLoading] = useState(true); // Add loading state
    const {token, user} = useAuth();
    const currentDate = new Date();
    console.log(currentDate);


    useEffect(() => {
        console.log(token);
        // declare the data fetching function
        const fetchData = async () => {
            try {
                const countResponse = await Services.getStatistics(token, 'counts');
                setCountList(countResponse.data);

                const availabilityResponse = await Services.getStatistics(token, 'availabilities');
                setAvailabilityList(availabilityResponse.data);

                const roomNamesResponse = await Services.getStatistics(token, 'available-room-names');
                setRoomNames(roomNamesResponse.data);

                const allTimesHighestRatedResponse = await Services.getStatistics(
                    token,
                    'highest-rated-publications'
                );
                setAllTimesHighestRated(allTimesHighestRatedResponse.data);

                const threeMonthsHighestRatedResponse = await Services.getStatistics(
                    token,
                    'highest-rated-publications-last-three-months'
                );
                setThreeMonthsHighestRated(threeMonthsHighestRatedResponse.data);

                setLoading(false); // Update loading state to false
            } catch (error) {
                console.error(error);
            }
        };

        fetchData();
    }, []);

    if (loading) {
        return ( <div style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', height: '100vh' }}>
            <Spin size="large" />
        </div>);
    }

    const availablePublications = [
        {type: 'Currently Available Publications', value: availabilityList.publications},
        {type: 'Borrowed Books', value: availabilityList.publications},
    ];

    const availableNewspapers = [
        {type: 'Currently Available Newspapers', value: availabilityList.newspapers},
        {type: 'Borrowed Newspapers', value: countList.newspapers-availabilityList.newspapers},
    ];
    const availablePhysicalBooks = [
        {type: 'Currently Available Physical Books', value: availabilityList.physical_books},
        {type: 'Borrowed Materials', value: countList.physical_books-availabilityList.physical_books},
    ];

    const availableMaterials = [
        {type: 'Currently Available Materials', value: availabilityList.materials},
        {type: 'Borrowed Materials', value: countList.materials-availabilityList.materials},
    ];

    return (
        <DashboardLayout>

            <Row gutter={[16, 16]}>
                <Col span={4}>
                    <Card>
                        <AnimatedNumber value={countList.audio_books} title="Number of Audio Books"/>
                    </Card>
                </Col>
                <Col span={4}>
                    <Card>
                        <AnimatedNumber value={countList.publications} title="Number of Publications"/>
                    </Card>
                </Col>
                <Col span={4}>
                    <Card>
                        <AnimatedNumber value={countList.newspapers} title="Number of Newspapers"/>
                    </Card>
                </Col>
                <Col span={4}>
                    <Card>
                        <AnimatedNumber value={countList.e_books} title="Number of E-books"/>
                    </Card>
                </Col><Col span={4}>
                    <Card>
                        <AnimatedNumber value={countList.physical_books} title="Number of Physical Books"/>
                    </Card>
                </Col><Col span={4}>
                    <Card>
                        <AnimatedNumber value={countList.materials} title="Number of Materials"/>
                    </Card>
                </Col>
            </Row>
            <br/>
            <Card >
                <Row justify="space-between">
                    <Col className="gutter-row" span={6}>
                        <BagelChart data={availablePublications} id={4} chartName='Publication Availability' name={'available-publications'}
                                    colorList={['#1976D2', '#64B5F6']}/>
                    </Col>
                    <Col className="gutter-row" span={6}>

                        <BagelChart data={availableNewspapers} id={3} chartName='Newspaper Availability'
                                    name={'available-newspaper'} colorList={['#39A57D', '#83D5C0']
                        }/>
                    </Col>
                    <Col className="gutter-row" span={6}>
                        <BagelChart data={availablePhysicalBooks} id={2} chartName='Physical Book Availability' name={'available-books'}
                                    colorList={['#9F82FF', '#D9C5FF']
                                    }/>
                    </Col>
                    <Col className="gutter-row" span={6}>
                        <BagelChart data={availableMaterials} id={1} chartName='Material Availability'
                                    name={'available-materials'} colorList={['#FF6B8E', '#FFD591']}/>
                    </Col>
                </Row>

            </Card>
            <br/>


            <Row gutter={[16, 16]}>
                <Col span={8}>
                    <Card title="Currently Available Rooms">
                        <List
                            className="room-names-list"
                            itemLayout="horizontal"
                            dataSource={roomNames}
                            renderItem={(item) => (
                                <List.Item>
                                    <List.Item.Meta
                                        title={item.name}
                                    />
                                </List.Item>
                            )}
                        />
                    </Card>
                </Col>
                <Col span={16}>
                <Card>
                   <Row>
                <Col span={12}>
                        <Histogram books={allTimesHighestRated} container={"all-times"} name={'Highest Rated Books of All Times'}/>
                </Col>
                <Col span={12}>
                    <Histogram books={threeMonthsHighestRated} container={"last-three"} name={'Highest Rated Books That Are Published In Last Three Months'}/>
                </Col>
                   </Row>
        </Card>
                </Col>
            </Row>

        </DashboardLayout>
    )
        ;
};

export default Dashboard;
