package com.meiit.webalk.reservation.service;

import com.meiit.webalk.reservation.domain.BookingPerson;
import com.meiit.webalk.reservation.domain.Hotel;
import com.meiit.webalk.reservation.domain.Reservation;
import com.meiit.webalk.reservation.view.View;

import java.util.List;

public interface IReservationService {

    public void saveBookingPerson(BookingPerson bp);

    public BookingPerson findBookingPerson();

    public List<Hotel> findAllHotels();

    public void saveReservation(Reservation r);

    public List<Reservation> findALLreservations();

    public void checkIn();

    public void checkOut();

}
