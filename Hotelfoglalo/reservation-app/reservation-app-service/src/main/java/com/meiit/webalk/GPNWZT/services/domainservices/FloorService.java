package com.meiit.webalk.GPNWZT.services.domainservices;

import java.util.List;

import com.meiit.webalk.GPNWZT.Floor;
import com.meiit.webalk.GPNWZT.Wing;
import com.meiit.webalk.GPNWZT.repositories.FloorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FloorService {
    
    @Autowired
    private FloorRepository floorRepository;

    public List<Floor> findAll(){
        return (List<Floor>) floorRepository.findAll();
    }

    public List<Wing> findWings(Floor floor){
        return floor.getWings();
    }
}
