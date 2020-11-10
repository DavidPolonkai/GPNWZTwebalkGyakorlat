package com.meiit.webalk.reservation;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.meiit.webalk.reservation.domain.Reservation;
import com.meiit.webalk.reservation.domain.Room;
import com.meiit.webalk.reservation.service.ReservationService;
import com.meiit.webalk.reservation.view.View;

public final class App {
    // Print and view should be in separetad folders!!
    // I separated them as shown in the documentations.
    private ReservationService reservationService;
    private View view;

    private App(ReservationService reservationService, View view) {
        this.reservationService = reservationService;
        this.view = view;
    }

    public static void main(String[] args) {
        App app = new App(new ReservationService(), new View());
        app.createBookingPerson();
        app.book();

        app.reservationService.checkIn();
        app.view.printCheckIn(app.reservationService.findALLreservations().get(0));
        System.out.println("Few days later");
        app.reservationService.checkOut();
        app.view.printSurprise();
        app.view.printCheckOut();
        app.view.printBalace(app.reservationService.findBookingPerson());
    }

    public void createBookingPerson() {
        reservationService.saveBookingPerson(view.readBookingPerson());
    }

    public void book() {
        Room room;
        do {
            room = view.selectRoom(reservationService.findAllHotels());
            if (room == null)
                break;
            if (room.getPrice() <= reservationService.findBookingPerson().getBalance().intValue()) {
                reservationService.findBookingPerson().setBalance(reservationService.findBookingPerson().getBalance()
                        .subtract(BigDecimal.valueOf(room.getPrice())));
                Reservation reservation = new Reservation();
                reservation.setAmount(BigDecimal.valueOf(room.getPrice()));
                reservation.setFrom(LocalDate.now());
                reservation.setTo(LocalDate.now().plusDays(6));
                reservation.setRoom(room);
                reservationService.saveReservation(reservation);
                view.printReservationSaved(reservation);
                room = null;
            } else {
                view.printNotEnoughBalance(reservationService.findBookingPerson());
            }
        } while (room != null);
    }
}
