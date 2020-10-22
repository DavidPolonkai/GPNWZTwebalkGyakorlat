package com.meiit.webalk.reservation.service;

import com.meiit.webalk.reservation.domain.BookingPerson;
import com.meiit.webalk.reservation.domain.Hotel;
import com.meiit.webalk.reservation.domain.Reservation;
import com.meiit.webalk.reservation.domain.Room;

import java.util.List;

public interface IView {

    public BookingPerson readBookingPerson();

    public void printWelcomeMessage(BookingPerson bookingPerson);

    public void printBalace(BookingPerson bookingPerson);

    public void printRooms(List<Room> rooms);

    public Room selectRoom(List<Hotel> hotels);

    public void printReservationSaved(Reservation reservation);

    public void printNotEnoughBalance(BookingPerson bookingPerson);

    public void printCheckIn(Reservation reservation);

    public void printCheckOut(BookingPerson bookingPerson, Reservation reservation);
}
