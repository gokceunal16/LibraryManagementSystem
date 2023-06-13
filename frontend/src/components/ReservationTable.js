import React, { useState, useEffect } from 'react';
import { Button, Modal, Select, Row, Col, DatePicker } from 'antd';
import Services from '../services/Services';
import { useAuth } from '../utils/hooks/useAuth';


const ReservationTable = () => {
    const [selectedSlot, setSelectedSlot] = useState('');
    const [selectedRoom, setSelectedRoom] = useState('');
    const [selectedDate, setSelectedDate] = useState(null);
    const [isModalVisible, setIsModalVisible] = useState(false);
    const [isCancelModalVisible, setIsCancelModalVisible] = useState(false);
    const [reservations, setReservations] = useState([]);

    const [timeSlots, setTimeSlots] = useState([]);
    const [rooms, setRooms] = useState([]);
    const [loading, setLoading] = useState(true);
    const { token, user } = useAuth();

    useEffect(() => {
        console.log(token);
        fetchReservations(selectedDate);
    }, [selectedDate]);

    const fetchReservations = (date) => {
        setLoading(true);
        Services.getTable('time_slots', token)
            .then((res) => {
                const formattedTimeSlots = res.data
                    .sort((a, b) => a.id - b.id)
                    .map(
                        (slot) =>
                            `${slot.start_time.slice(0, -3)} - ${slot.end_time.slice(0, -3)}`
                    );
                setTimeSlots(formattedTimeSlots);
            })
            .catch(console.error);
        Services.getTable('rooms', token)
            .then((res) => {
                const formattedRooms = res.data
                    .sort((a, b) => a.id - b.id)
                    .map((room) => `${room.name} (${room.capacity})`);
                setRooms(formattedRooms);
            })
            .catch(console.error);
        Services.getTable('reservations', token) // Fetch reservations
            .then((res) => {
                setReservations(res.data);
                setLoading(false);
                console.log(res.data)
            })
            .catch(console.error);
    };

    const handleSlotSelect = (slot, room) => {
        setSelectedSlot(slot);
        setSelectedRoom(room);
        setIsModalVisible(true);
    };

    const handleReservation = () => {
        const existingReservation = reservations.find(
            (r) => r.slot === selectedSlot && r.room !== selectedRoom
        );

        if (existingReservation) {
            Modal.error({
                title: 'Conflict',
                content: 'You already have a booking for another room at this time.',
            });
            return;
        }

        const newReservation = {
            slot: selectedSlot,
            room: selectedRoom,
            date: selectedDate,
        };

        setReservations([...reservations, newReservation]);
        setIsModalVisible(false);
    };

    const handleCancelReservation = (slot, room) => {
        setSelectedSlot(slot);
        setSelectedRoom(room);
        setIsCancelModalVisible(true);
    };

    const confirmReservation = () => {
        const updatedReservations = reservations.filter(
            (r) => r.slot !== selectedSlot || r.room !== selectedRoom
        );

        setReservations(updatedReservations);
        setIsCancelModalVisible(false);
    };

    const getReservationStatus = (slot, room) => {
        const existingReservation = reservations.find(
            (r) => r.slot === slot && r.room === room
        );

        if (existingReservation) {
            if (existingReservation.user_id !== user) {
                return 'unavailable';
            }
        }

        return 'available';
    };

    const handleDateChange = (date) => {
        setSelectedDate(date);
    };

    return (
        <div className="reservation-matrix">
            <Row>
                <Col span={6}>
                    <DatePicker onChange={handleDateChange} />
                </Col>
            </Row>

            <div className="time-slots">
                <div className="empty-cell"></div>
                {rooms.map((room) => (
                    <div
                        className="room-header"
                        key={room}
                        style={{ textAlign: 'center' }}
                    >
                        {room}
                    </div>
                ))}
            </div>

            {/*cancel çalışmıyor*/}
            {timeSlots.map((slot) => (
                <div className="time-slot-row" key={slot}>
                    <div className="time-slot-header">{slot}</div>
                    {rooms.map((room) => (
                        <div
                            className={`room-cell ${getReservationStatus(slot, room)}`}
                            key={room}
                        >
                            {getReservationStatus(slot, room) === 'unavailable' ? (
                                <Button
                                    className="cancel-button"
                                    disabled={!user}
                                >
                                    Cancel
                                </Button>
                            ) : (
                                <Button
                                    className="book-button"
                                    disabled={!user}
                                    onClick={() => handleSlotSelect(slot, room)}
                                >
                                    Book
                                </Button>
                            )}
                        </div>
                    ))}
                </div>
            ))}

            <Modal
                title="Confirm Reservation"
                visible={isModalVisible}
                onOk={handleReservation}
                onCancel={() => setIsModalVisible(false)}
                okText="Confirm Booking"
                cancelText="Cancel"
            >
                <p>
                    Do you want to book {selectedRoom} for the time slot on{' '}
                    {selectedDate && selectedDate.format('YYYY-MM-DD')}:
                </p>
                <p>{selectedSlot}</p>
            </Modal>

            <Modal
                title="Confirm Cancellation"
                visible={isCancelModalVisible}
                onOk={confirmReservation}
                onCancel={() => setIsCancelModalVisible(false)}
                okText="Confirm Cancellation"
                cancelText="Cancel"
            >
                <p>
                    Do you want to cancel the booking for {selectedRoom} at the time slot
                    on {selectedDate && selectedDate.format('YYYY-MM-DD')}:
                </p>
                <p>{selectedSlot}</p>
            </Modal>
        </div>
    );
};

export default ReservationTable;
