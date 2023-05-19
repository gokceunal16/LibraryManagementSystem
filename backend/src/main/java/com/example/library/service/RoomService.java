package com.example.library.service;

import com.example.library.entity.Room;
import com.example.library.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public void createRoom(Room room) {
        roomRepository.createRoom(room);
    }

    public List<Room> getRooms() {
        return roomRepository.getRooms();
    }

    public Room findById(int id) {
        return roomRepository.findById(id);
    }

    public void updateRoom(int id, Room room) {
        roomRepository.updateRoom(id, room);
    }
}
