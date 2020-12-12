package com.meiit.webalk.GPNWZT.services.domainservices;

import java.util.List;
import java.util.Optional;

import com.meiit.webalk.GPNWZT.Room;
import com.meiit.webalk.GPNWZT.Wing;
import com.meiit.webalk.GPNWZT.repositories.WingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WingService {
    
    @Autowired
    private WingRepository wingRepository;

    public Optional<Wing> findById(Long id){
        return wingRepository.findById(id);
    }

    public List<Room> findRoomsByWing(Wing wing){
        return wing.getRooms();
    }
}
