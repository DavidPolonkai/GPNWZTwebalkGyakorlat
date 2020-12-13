package com.meiit.webalk.GPNWZT.services.domainservices;

import java.util.List;

import com.meiit.webalk.GPNWZT.Room;
import com.meiit.webalk.GPNWZT.Wing;
import com.meiit.webalk.GPNWZT.repositories.WingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WingService {
    
    @Autowired
    private WingRepository wingRepository;

    public Wing findById(Long id) throws Exception {
        return wingRepository.findById(id).orElseThrow(()->new Exception("Server side error happened"));
    }

    public List<Room> findRoomsByWing(Wing wing){
        return wing.getRooms();
    }
}
