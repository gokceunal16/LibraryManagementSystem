import React, { useState } from 'react';
import { Button, Modal, Select, Row, Col } from 'antd';

const { Option } = Select;

const timeSlots = [
    '09:00 AM - 10:00 AM',
    '10:00 AM - 11:00 AM',
    '11:00 AM - 12:00 PM',
    '12:00 PM - 01:00 PM',
    '01:00 PM - 02:00 PM',
    '02:00 PM - 03:00 PM',
    '03:00 PM - 04:00 PM',
];

const rooms = ['Room 1', 'Room 2', 'Room 3', 'Room 4'];

const ReservationTable = () => {
    const [selectedSlot, setSelectedSlot] = useState('');
    const [selectedRoom, setSelectedRoom] = useState('');
    const [isModalVisible, setIsModalVisible] = useState(false);
    const [isCancelModalVisible, setIsCancelModalVisible] = useState(false);
    const [reservations, setReservations] = useState([]);

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

        return existingReservation ? 'unavailable' : 'available';
    };

    return (
        <div className="reservation-matrix">
            <div className="time-slots">
                <div className="empty-cell"></div>
                {rooms.map((room) => (
                    <div className="room-header" key={room}>
                        {room}
                    </div>
                ))}
            </div>

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
                                    onClick={() => handleCancelReservation(slot, room)}
                                >
                                    Cancel
                                </Button>
                            ) : (
                                <Button
                                    className="book-button"
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
                <p>Do you want to book {selectedRoom} for the time slot:</p>
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
                <p>Do you want to cancel the booking for {selectedRoom} at the time slot:</p>
                <p>{selectedSlot}</p>
            </Modal>
        </div>
    );
};

export default ReservationTable;
