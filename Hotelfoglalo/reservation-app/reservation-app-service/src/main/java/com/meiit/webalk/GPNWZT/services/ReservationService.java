package com.meiit.webalk.GPNWZT.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.meiit.webalk.GPNWZT.BookingPerson;
import com.meiit.webalk.GPNWZT.Floor;
import com.meiit.webalk.GPNWZT.Hotel;
import com.meiit.webalk.GPNWZT.Reservation;
import com.meiit.webalk.GPNWZT.Room;
import com.meiit.webalk.GPNWZT.User;
import com.meiit.webalk.GPNWZT.Wing;
import com.meiit.webalk.GPNWZT.services.domainservices.BookingPersonService;
import com.meiit.webalk.GPNWZT.services.domainservices.HotelService;
import com.meiit.webalk.GPNWZT.services.domainservices.ReservService;
import com.meiit.webalk.GPNWZT.services.domainservices.RoomService;
import com.meiit.webalk.GPNWZT.services.domainservices.UserService;
import com.meiit.webalk.GPNWZT.services.domainservices.WingService;
import com.meiit.webalk.GPNWZT.services.exceptions.NotEnoughBalance;
import com.meiit.webalk.GPNWZT.services.security.MyUserPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class ReservationService implements IReservationService {

    @Autowired
    private UserService userService;

    @Autowired
    private BookingPersonService bookingPersonService;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private WingService wingService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private ReservService reservService;

    public void saveBookingPerson(BookingPerson bookingPerson) {
        bookingPersonService.save(bookingPerson);
    }

    public void updateBookingPerson(BookingPerson bookingPerson) {
        BookingPerson oldbookingPerson = findBookingPerson();
        bookingPerson.setId(oldbookingPerson.getId());
        bookingPerson.setReservations(oldbookingPerson.getReservations());
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

    public void saveReservation(Reservation reservation) {
        reservService.save(reservation);
    }

    public Hotel findHotelByID(Long id) throws Exception {
        return hotelService.findById(id);
    }

    public List<Wing> findWingsInHotel(Hotel hotel) {
        List<Floor> floors = hotelService.findFloorsByHotel(hotel);
        List<Wing> wings = new ArrayList<Wing>();
        for (Floor f : floors) {
            for (Wing w : f.getWings()) {
                wings.add(w);
            }
        }

        Collections.sort(wings, new Comparator<Wing>() {
            @Override
            public int compare(Wing w1, Wing w2) {
                return w1.getWingType().compareTo(w2.getWingType());
            }
        });
        return wings;
    }

    public Wing findWingById(Long id) throws Exception {
        return wingService.findById(id);
    }

    public List<Room> findRooms(Wing wing) {
        List<Room> rooms = wingService.findRoomsByWing(wing);
        for (Reservation r : findALLreservations()) {
            if (r.isActive()) {
                rooms.remove(r.getRoom());
            }
        }
        return rooms;

    }

    public Room findRoomById(Long id) throws Exception {
        return roomService.findById(id);

    }

    @Override
    public List<Reservation> findALLreservations() {
        return findBookingPerson().getReservations();
    }

    @Override
    public void checkIn(Room room) throws NotEnoughBalance {
        Reservation reservation = new Reservation(room.getPrice(), LocalDate.now(), LocalDate.now().plusDays(3), true,
                true);
        BookingPerson bookingPerson = findBookingPerson();
        if (bookingPerson.getBalance().compareTo(reservation.getAmount()) >= 0) {
            bookingPerson.setBalance(bookingPerson.getBalance().subtract(reservation.getAmount()));
            reservation.setBookingPerson(bookingPerson);
            reservation.setRoom(room);
            bookingPerson.getReservations().add(reservation);

            bookingPersonService.save(bookingPerson);
            reservService.save(reservation);
        } else
            throw new NotEnoughBalance();
    }

    @Override
    public void checkOut(Long id) throws Exception {
        BookingPerson bookingPerson = findBookingPerson();
        Reservation reservation = reservService.findById(id);
        bookingPerson.getReservations().remove(reservation);

        reservService.delete(id);
        bookingPersonService.save(bookingPerson);
    }

}
