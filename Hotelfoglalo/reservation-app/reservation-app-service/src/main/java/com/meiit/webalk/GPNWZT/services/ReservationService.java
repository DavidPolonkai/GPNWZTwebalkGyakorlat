package com.meiit.webalk.GPNWZT.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;
import java.math.MathContext;

import com.meiit.webalk.GPNWZT.*;
import com.meiit.webalk.GPNWZT.services.domainservices.BookingPersonService;
import com.meiit.webalk.GPNWZT.services.domainservices.HotelService;
import com.meiit.webalk.GPNWZT.services.domainservices.UserService;
import com.meiit.webalk.GPNWZT.services.domainservices.WingService;
import com.meiit.webalk.GPNWZT.services.security.MyUserPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class ReservationService implements IReservationService {
    private List<Hotel> hotels;
    private BookingPerson bp;

    @Autowired
    private UserService userService;

    @Autowired
    private BookingPersonService bookingPersonService;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private WingService wingService;

    public void saveBookingPerson(BookingPerson bookingPerson) {
        bookingPersonService.save(bookingPerson);
    }

    public void updateBookingPerson(BookingPerson bookingPerson) {
        bookingPerson.setId(findBookingPerson().getId());
        saveBookingPerson(bookingPerson);
    }

    public void saveBookingPersonUser(User user) {
        BookingPerson bookingPerson = new BookingPerson();
        bookingPersonService.save(bookingPerson);
        user.setBookingPerson(bookingPerson);
        userService.save(user);
    }

    public BookingPerson findBookingPerson() {
        MyUserPrincipal user = (MyUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userService.findByEmail(user.getUsername()).getBookingPerson();

    }

    public List<Hotel> findAllHotels() {
        return hotelService.findAll();
    }

    public void saveReservation(Reservation r) {
        // bp.setReservation(r);
    }

    public Hotel findHotelByID(Long id) throws NotFoundException {
        Optional<Hotel> hotel = hotelService.findById(id);
        if (hotel.isPresent())
            return hotel.get();
        else
            throw new NotFoundException();
    }

    public List<Wing> findWingsInHotel(Hotel hotel) {
        List<Floor> floors=hotelService.findFloorsByHotel(hotel);
        List<Wing> wings=new ArrayList<Wing>();
        for (Floor f: floors){
            for(Wing w:f.getWings()){
                wings.add(w);
            }
        }

        Collections.sort(wings, new Comparator<Wing>(){
            @Override
            public int compare (Wing w1, Wing w2){
                return w1.getWingType().compareTo(w2.getWingType());
            }
        });
        return wings;
    }

    public Wing findWingById(Long id) throws NotFoundException {
        Optional<Wing>  wing= wingService.findById(id);
        if (wing.isPresent())
            return wing.get();
        else
            throw new NotFoundException();
    }

    public List<Room> findRooms(Wing wing){
        return wingService.findRoomsByWing(wing);
        
    }

    /*
     * public List<Reservation> findALLreservations() { List<Reservation> ret = new
     * ArrayList<Reservation>(); //ret.add(bp.getReservation()); //return ret; }
     */

    public void checkIn() {
        // 1 person how able to check in multiple hotels
        // based on documentation View is not permitted to call from service
    }

    public void checkOut() {
        // view.printSurprise();
        // Same like check in
        // based on documentation View is not permitted to call from service
        // view.printCheckOut(bp, r);
        // bp.setBalance((bp.getBalance().add(bp.getReservation().getAmount().multiply(new
        // BigDecimal(0.1))))
        // .round(new MathContext(0)));
        // based on documentation View is not permitted to call from service

    }

    @Override
    public List<Reservation> findALLreservations() {
        // TODO Auto-generated method stub
        return null;
    }
}
