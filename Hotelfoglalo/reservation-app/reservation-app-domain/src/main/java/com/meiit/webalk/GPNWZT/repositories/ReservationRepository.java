package com.meiit.webalk.GPNWZT.repositories;

import com.meiit.webalk.GPNWZT.Reservation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ReservationRepository extends CrudRepository<Reservation,Long>{
    
}
