package com.meiit.webalk.GPNWZT.repositories;

import com.meiit.webalk.GPNWZT.Hotel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface HotelRepository extends CrudRepository<Hotel,Long>{
    

}
