package com.meiit.webalk.GPNWZT.services;

import java.util.List;

import com.meiit.webalk.GPNWZT.BookingPerson;
import com.meiit.webalk.GPNWZT.Hotel;
import com.meiit.webalk.GPNWZT.Reservation;
import com.meiit.webalk.GPNWZT.services.security.MyUserPrincipal;



public interface IReservationService {

    public void saveBookingPerson(BookingPerson bp);

    public BookingPerson findBookingPerson();

    public List<Hotel> findAllHotels();

    public void saveReservation(Reservation r);

    public List<Reservation> findALLreservations();

    public void checkIn();

    public void checkOut();

}
