package com.meiit.webalk.GPNWZT.web.RestController;

import java.util.List;

import com.meiit.webalk.GPNWZT.BookingPerson;
import com.meiit.webalk.GPNWZT.Hotel;
import com.meiit.webalk.GPNWZT.Reservation;
import com.meiit.webalk.GPNWZT.Room;
import com.meiit.webalk.GPNWZT.User;
import com.meiit.webalk.GPNWZT.services.RestService.RestEndService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestEndController {

    @Autowired
    private RestEndService restEndService;

    @PostMapping("/add-hotel")
    public void addHotel(Hotel hotel) {
        restEndService.addHotel(hotel);
    }

    @PostMapping("/add-room")
    public void addRoom(Room room) {
        restEndService.addRoom(room);
    }

    @PostMapping("/create-user")
    public void createUser(User user) {
        restEndService.createUser(user);
    }

    @GetMapping("/user-info")
    public ResponseEntity<User> getUserInfo(Long id) {
        User user = restEndService.userInfo(id);
        System.out.println(user.getId());
        if (user == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(user);
    }

    @GetMapping("/show-reservations")
    public ResponseEntity<List<Reservation>> showReservations() {
        List<Reservation> reservations = restEndService.showReservation();
        if (restEndService == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(reservations);
    }
}
