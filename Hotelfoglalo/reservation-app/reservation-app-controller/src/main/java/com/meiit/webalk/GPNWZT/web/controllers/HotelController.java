package com.meiit.webalk.GPNWZT.web.controllers;

import javax.websocket.server.PathParam;

import com.meiit.webalk.GPNWZT.Hotel;
import com.meiit.webalk.GPNWZT.Room;
import com.meiit.webalk.GPNWZT.Wing;
import com.meiit.webalk.GPNWZT.services.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HotelController {
    
    @Autowired
    private ReservationService reservationService;

    private Hotel hotel;

    @GetMapping("/hotels")
    public String hotels(Model model){
        model.addAttribute("hotels", reservationService.findAllHotels());
        return "hotels";
    }

    @GetMapping("/bookhotel={ID}")
    public String bookhotel(@PathVariable(value="ID") String id,Model model){
        try{
        Long validid=Long.parseLong(id);
        this.hotel=reservationService.findHotelByID(validid);
        model.addAttribute("hotel", this.hotel);
        model.addAttribute("wings", reservationService.findWingsInHotel(this.hotel));
        }catch(NotFoundException e){
            return "hotels";
        }
        return "wings";
    }

    @GetMapping("/wing={ID}")
    public String bookRoom(@PathVariable(value="ID") String id,Model model){
        try{
            Long validid=Long.parseLong(id);
            Wing wing=reservationService.findWingById(validid);
            model.addAttribute("hotel", this.hotel);
            model.addAttribute("wing",wing);
            model.addAttribute("rooms", reservationService.findRooms(wing));
        }catch(Exception e){
            return "wings";
        }
        return "rooms";
    }

    @PostMapping("/create-reservation")
    public String makereservation(@ModelAttribute Room room,Model model){
        System.out.println(room);
        model.addAttribute("room", room);
        System.out.println(room);
        return "refpage";
    }
}
