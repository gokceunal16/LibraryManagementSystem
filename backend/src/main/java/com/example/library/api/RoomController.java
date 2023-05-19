package com.example.library.api;

import com.example.library.entity.Room;
import com.example.library.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }


    @PostMapping(value = "/room")
    @ResponseBody
    public void createRoom(@RequestBody Room room){

        roomService.createRoom(room);
    }

    @GetMapping(value = "/rooms")
    @ResponseBody
    public List<Room> getRooms(){

        return roomService.getRooms();
    }

    @GetMapping(value = "/room/{id}")
    @ResponseBody
    public Room findById(@PathVariable("id") int id){

        return roomService.findById(id);
    }

    @PutMapping(value = "/room/{id}")
    @ResponseBody
    public void updateRoom(@PathVariable("id") int id, @RequestBody Room updatedRoom){

        roomService.updateRoom(id, updatedRoom);
    }
}
