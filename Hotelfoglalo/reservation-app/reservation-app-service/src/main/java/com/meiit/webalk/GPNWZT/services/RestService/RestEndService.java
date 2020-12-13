package com.meiit.webalk.GPNWZT.services.RestService;

import java.util.List;

import com.meiit.webalk.GPNWZT.BookingPerson;
import com.meiit.webalk.GPNWZT.Hotel;
import com.meiit.webalk.GPNWZT.Reservation;
import com.meiit.webalk.GPNWZT.Room;
import com.meiit.webalk.GPNWZT.User;
import com.meiit.webalk.GPNWZT.services.domainservices.BookingPersonService;
import com.meiit.webalk.GPNWZT.services.domainservices.HotelService;
import com.meiit.webalk.GPNWZT.services.domainservices.ReservService;
import com.meiit.webalk.GPNWZT.services.domainservices.RoomService;
import com.meiit.webalk.GPNWZT.services.domainservices.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestEndService {
    
    @Autowired
    private HotelService hotelService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private UserService userService;

    @Autowired
    private BookingPersonService bookingPersonService;

    @Autowired
    private ReservService reservService;


    public void addHotel(Hotel hotel){
        hotelService.save(hotel);
    }

    public void addRoom(Room room){
        roomService.save(room);
    }

    public void createUser(User user){
        BookingPerson bookingPerson = new BookingPerson();
        bookingPersonService.save(bookingPerson);
        user.setBookingPerson(bookingPerson);
        userService.save(user);
    }

    public User userInfo(Long id){
        try{
            return userService.findById(id);
        }catch(Exception e){
            return null;
        }
    }

    public List<Reservation> showReservation(){
       return reservService.findAll();
    }
}
