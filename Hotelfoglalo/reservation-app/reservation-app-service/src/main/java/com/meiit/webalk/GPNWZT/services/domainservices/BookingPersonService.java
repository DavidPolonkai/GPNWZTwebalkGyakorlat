package com.meiit.webalk.GPNWZT.services.domainservices;

import java.util.List;

import com.meiit.webalk.GPNWZT.BookingPerson;
import com.meiit.webalk.GPNWZT.repositories.BookingPersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingPersonService {
    
    @Autowired
    private BookingPersonRepository bookingPersonRepository;

    public List<BookingPerson> findAll(){
        return (List<BookingPerson>) bookingPersonRepository.findAll();
    }

    public void save(BookingPerson bookingPerson){
        bookingPersonRepository.save(bookingPerson);
    }
}
