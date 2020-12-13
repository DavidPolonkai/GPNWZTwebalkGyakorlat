package com.meiit.webalk.GPNWZT.testdata;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.meiit.webalk.GPNWZT.BookingPerson;
import com.meiit.webalk.GPNWZT.Currency;
import com.meiit.webalk.GPNWZT.Floor;
import com.meiit.webalk.GPNWZT.Hotel;
import com.meiit.webalk.GPNWZT.Room;
import com.meiit.webalk.GPNWZT.User;
import com.meiit.webalk.GPNWZT.Wing;
import com.meiit.webalk.GPNWZT.WingType;
import com.meiit.webalk.GPNWZT.repositories.BookingPersonRepository;
import com.meiit.webalk.GPNWZT.repositories.FloorRepository;
import com.meiit.webalk.GPNWZT.repositories.HotelRepository;
import com.meiit.webalk.GPNWZT.repositories.RoomRepository;
import com.meiit.webalk.GPNWZT.repositories.UserRepository;
import com.meiit.webalk.GPNWZT.repositories.WingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class TestDataGenerator implements CommandLineRunner {
    @Autowired
    private BookingPersonRepository bookingPersonRepository;
    @Autowired
    private FloorRepository floorRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private WingRepository wingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        List<Hotel> hotels = new ArrayList<Hotel>();
        hotels.add(new Hotel("Hotel Miskolc", "Miskolc", 5));
        hotels.add(new Hotel("Hotel California","US California",5));


        List<Floor> floors = new ArrayList<Floor>();
        floors.add(new Floor(1, hotels.get(0)));
        floors.add(new Floor(2, hotels.get(0)));
        List<Floor> floors1 = new ArrayList<Floor>();
        floors1.add(new Floor(1, hotels.get(1)));


        List<Wing> wings = new ArrayList<Wing>();
        wings.add(new Wing("Business", floors.get(0), WingType.NORTH));
        wings.add(new Wing("Superior", floors.get(0), WingType.EAST));
        List<Wing> wings1 = new ArrayList<Wing>();
        wings1.add(new Wing("Business", floors.get(1), WingType.NORTH));
        List<Wing> wings2 = new ArrayList<Wing>();
        wings2.add(new Wing("Business", floors1.get(0), WingType.NORTH));

        List<Room> rooms = new ArrayList<Room>();
        rooms.add(new Room(1, 2, false,new BigDecimal(2000),wings.get(0)));
        rooms.add(new Room(2, 2, true, new BigDecimal(2500),wings.get(0)));
        rooms.add(new Room(3, 2, true, new BigDecimal(2800),wings.get(0)));
        rooms.add(new Room(4, 3, false, new BigDecimal(3000),wings.get(0)));
        rooms.add(new Room(5, 3, true, new BigDecimal(3500),wings.get(0)));

        List<Room> rooms1 = new ArrayList<Room>();
        rooms1.add(new Room(1, 2, false,new BigDecimal(2000),wings.get(1)));
        rooms1.add(new Room(2, 2, true, new BigDecimal(2500),wings.get(1)));
        rooms1.add(new Room(3, 2, true, new BigDecimal(2800),wings.get(1)));
        rooms1.add(new Room(4, 3, false, new BigDecimal(3000),wings.get(1)));
        rooms1.add(new Room(5, 3, true, new BigDecimal(3500),wings.get(1)));

        List<Room> rooms2 = new ArrayList<Room>();
        rooms2.add(new Room(1, 2, false,new BigDecimal(2000),wings1.get(0)));
        rooms2.add(new Room(2, 2, true, new BigDecimal(2500),wings1.get(0)));
        rooms2.add(new Room(3, 2, true, new BigDecimal(2800),wings1.get(0)));
        rooms2.add(new Room(4, 3, false, new BigDecimal(3000),wings1.get(0)));
        rooms2.add(new Room(5, 3, true, new BigDecimal(3500),wings1.get(0)));

        List<Room> rooms3 = new ArrayList<Room>();
        rooms3.add(new Room(1, 2, false,new BigDecimal(2000),wings2.get(0)));
        rooms3.add(new Room(2, 2, true, new BigDecimal(2500),wings2.get(0)));
        rooms3.add(new Room(3, 2, true, new BigDecimal(2800),wings2.get(0)));
        rooms3.add(new Room(4, 3, false, new BigDecimal(3000),wings2.get(0)));
        rooms3.add(new Room(5, 3, true, new BigDecimal(3500),wings2.get(0)));


        hotels.get(0).setFloors(floors);
        hotels.get(1).setFloors(floors1);
        floors.get(0).setWings(wings);
        floors.get(1).setWings(wings1);
        floors1.get(0).setWings(wings2);
        wings.get(0).setRooms(rooms);
        wings.get(1).setRooms(rooms1);
        wings1.get(0).setRooms(rooms2);
        wings2.get(0).setRooms(rooms3);

        hotelRepository.saveAll(hotels);
        floorRepository.saveAll(floors);
        wingRepository.saveAll(wings);
        roomRepository.saveAll(rooms);

        User user = new User("u", passwordEncoder.encode("u"), new BookingPerson());
        BookingPerson bookingPerson = new BookingPerson(10,"name", new BigDecimal(2000),LocalDate.of(2000, 04, 20), Currency.EUR);
        user.setBookingPerson(bookingPerson);

        bookingPersonRepository.save(bookingPerson);
        userRepository.save(user);

    }
}
