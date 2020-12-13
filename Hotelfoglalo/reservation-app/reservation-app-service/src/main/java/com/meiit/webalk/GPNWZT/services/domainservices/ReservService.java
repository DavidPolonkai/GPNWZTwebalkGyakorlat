package com.meiit.webalk.GPNWZT.services.domainservices;

import java.util.List;

import com.meiit.webalk.GPNWZT.Reservation;
import com.meiit.webalk.GPNWZT.repositories.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservService {

    @Autowired
    private ReservationRepository reservationRepository;

    public void save(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public void delete(Long id) {
        reservationRepository.deleteById(id);
    }

    public Reservation findById(Long id) throws Exception {
        return reservationRepository.findById(id).orElseThrow(()->new Exception("Server side error happened"));
    } 
    
    public List<Reservation> findAll(){
        return (List<Reservation>) reservationRepository.findAll();
    }

}
