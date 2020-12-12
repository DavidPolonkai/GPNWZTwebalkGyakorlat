package com.meiit.webalk.GPNWZT.repositories;

import com.meiit.webalk.GPNWZT.BookingPerson;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingPersonRepository extends CrudRepository<BookingPerson,Long>{
    
}
