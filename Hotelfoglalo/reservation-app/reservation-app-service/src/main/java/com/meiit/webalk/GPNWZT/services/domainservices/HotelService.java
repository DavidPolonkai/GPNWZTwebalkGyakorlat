package com.meiit.webalk.GPNWZT.services.domainservices;

import java.util.List;

import com.meiit.webalk.GPNWZT.Floor;
import com.meiit.webalk.GPNWZT.Hotel;
import com.meiit.webalk.GPNWZT.repositories.HotelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
    
    @Autowired
    private HotelRepository hotelRepository;

	public List<Hotel> findAll() {
		return (List<Hotel>) hotelRepository.findAll();
	}

	public Hotel findById(Long id) throws Exception {
		return hotelRepository.findById(id).orElseThrow(()->new Exception("Server side error happened")); 
	}

	public  List<Floor> findFloorsByHotel(Hotel hotel){
		return hotel.getFloors();
	}

	public void save(Hotel hotel){
		hotelRepository.save(hotel);
	}

	
}
