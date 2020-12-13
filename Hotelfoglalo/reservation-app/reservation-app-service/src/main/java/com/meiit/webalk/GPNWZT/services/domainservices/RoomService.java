package com.meiit.webalk.GPNWZT.services.domainservices;

import com.meiit.webalk.GPNWZT.Room;
import com.meiit.webalk.GPNWZT.repositories.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    
    @Autowired
    private RoomRepository roomRepository;

    public Room findById(long id) throws Exception {
        return roomRepository.findById(id).orElseThrow(()->new Exception("Server side error happened"));
    }

    public void save(Room room){
        roomRepository.save(room);
    }
}
