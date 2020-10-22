package com.meiit.webalk.reservation.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.meiit.webalk.reservation.domain.BookingPerson;
import com.meiit.webalk.reservation.domain.Currency;
import com.meiit.webalk.reservation.domain.Floor;
import com.meiit.webalk.reservation.domain.Hotel;
import com.meiit.webalk.reservation.domain.Reservation;
import com.meiit.webalk.reservation.domain.Room;
import com.meiit.webalk.reservation.domain.Wing;

public class View implements IView {
    private Scanner in = new Scanner(System.in);

    public BookingPerson readBookingPerson() {
        System.out.println("Whats your name?");
        BookingPerson bookingPerson = new BookingPerson();
        bookingPerson.setName(in.nextLine());
        System.out.println("How much money do you have? (more than 0)");
        BigDecimal balance = new BigDecimal(in.nextLine());
        bookingPerson.setBalance(balance);
        System.out.println("What is your currency?(HUF,EUR or USD)");
        String currency = in.nextLine();
        bookingPerson.setCurrency(Currency.valueOf(currency));
        return bookingPerson;
    }

    public void printWelcomeMessage(BookingPerson bookingPerson) {
        System.out.println("Welcome " + bookingPerson.getName());
        printBalace(bookingPerson);
    }

    public void printBalace(BookingPerson bookingPerson) {
        System.out.println("Your balance is: " + bookingPerson.getBalance());
    }

    public void printRooms(List<Room> rooms) {
        for (int i = 0; i < rooms.size(); i++) {
            Room curr = rooms.get(i);
            System.out.println((i + 1) + ": Hotel name: " + curr.getWing().getFloor().getHotel().getName() + ", Floor: "
                    + curr.getWing().getFloor().getFloorNumber() + ", Wing: " + curr.getWing().getWingType()
                    + ", Room number: " + curr.getNumber() + ", Beds: " + curr.getBeds() + ", Room Price: "
                    + curr.getPrice());
        }
    }

    public Room selectRoom(List<Hotel> hotels) {
        List<Room> rooms = new ArrayList<Room>();
        for (Hotel hotel : hotels) {
            for (Floor floor : hotel.getFloors()) {
                for (Wing wing : floor.getWings()) {
                    for (Room room : wing.getRooms()) {
                        rooms.add(room);
                    }
                }
            }
        }
        System.out.println("Where you want to book? (choose a number or press q for quit)");
        printRooms(rooms);
        String s = "q";
        try {
            s = in.nextLine();
            int choosen = Integer.parseInt(s);
            return rooms.get(choosen - 1);
        } catch (NumberFormatException e) {
            if (!s.equals("q"))
                System.out.println("Unknown command");
            return null;
        }
    }

    public void printReservationSaved(Reservation reservation) {
        System.out.println("The reservation successfully saved!");
        System.out.println("Reservation details: " + reservation.getRoom().getWing().getFloor().getHotel().getName()
                + ", Floor: " + reservation.getRoom().getWing().getFloor().getFloorNumber() + ", Wing: "
                + reservation.getRoom().getWing().getWingType() + ", Room number: " + reservation.getRoom().getNumber()
                + ", Beds: " + reservation.getRoom().getBeds());
    }

    public void printNotEnoughBalance(BookingPerson bookingPerson) {
        System.out.println("Sorry you don't have nought balance please choose another room!");
        printBalace(bookingPerson);
    }

    public void printCheckIn(Reservation reservation) {
        System.out.println("Check in " + reservation.getRoom().getWing().getFloor().getHotel().getName() + ", room:"
                + reservation.getRoom().getNumber());
    }

    public void printCheckOut(BookingPerson bookingPerson, Reservation reservation) {
        System.out.println("Check out!");
    }

    public void printSurprise() {
        System.out.println("Surprise you are the 100th guest you got 10% refund");
    }
}
