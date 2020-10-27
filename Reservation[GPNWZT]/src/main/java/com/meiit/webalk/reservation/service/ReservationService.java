package com.meiit.webalk.reservation.service;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.math.MathContext;

import com.meiit.webalk.reservation.domain.BookingPerson;
import com.meiit.webalk.reservation.domain.Floor;
import com.meiit.webalk.reservation.domain.Hotel;
import com.meiit.webalk.reservation.domain.Reservation;
import com.meiit.webalk.reservation.domain.Room;
import com.meiit.webalk.reservation.domain.Wing;
import com.meiit.webalk.reservation.domain.WingType;

public class ReservationService implements IReservationService {
    private List<Hotel> hotels;
    private BookingPerson bp;

    public ReservationService() {
        initData();
    }

    private void initData() {
        hotels = new ArrayList<Hotel>();
        Hotel hotel = new Hotel("Hotel Miskolc", "Miskolc", 5);
        List<Room> rooms = new ArrayList<Room>();
        Floor floor = new Floor(1, hotel);
        Wing wing = new Wing("Business", floor, WingType.NORTH);
        floor.getWings().add(wing);
        rooms.add(new Room(1, 2, false, 2000, wing));
        rooms.add(new Room(2, 2, true, 2500, wing));
        rooms.add(new Room(3, 2, true, 2800, wing));
        rooms.add(new Room(4, 3, false, 3000, wing));
        rooms.add(new Room(5, 3, true, 3500, wing));
        wing.getRooms().addAll(rooms);
        hotel.getFloors().add(floor);
        hotels.add(hotel);
    }

    public void saveBookingPerson(BookingPerson bp) {
        this.bp = bp;
    }

    public BookingPerson findBookingPerson() {
        return bp;
    }

    public List<Hotel> findAllHotels() {
        return hotels;
    }

    public void saveReservation(Reservation r) {
        bp.getReservations().add(r);
    }

    public List<Reservation> findAllreservations() {
        return bp.getReservations();
    }

    public void checkIn(View view) {
        //1 person how able to check in multiple hotels?
        for (Reservation r : bp.getReservations()) {
            //based on documentation View is not permitted to call from service
            view.printCheckIn(r);
        }
    }

    public void checkOut(View view) {
        view.printSurprise();
        //Same like check in
        for (Reservation r : bp.getReservations()) {
            //based on documentation View is not permitted to call from service
            view.printCheckOut(bp, r);
            bp.setBalance((bp.getBalance().add(r.getAmount().multiply(new BigDecimal(0.1)))).round(new MathContext(0)));
        }
        //based on documentation View is not permitted to call from service
        view.printBalace(bp);

    }
}
