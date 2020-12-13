package com.meiit.webalk.GPNWZT.web.controllers;

import com.meiit.webalk.GPNWZT.BookingPerson;
import com.meiit.webalk.GPNWZT.services.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {

    @Autowired
    private ReservationService reservationService;


    @GetMapping("/modifyuser")
    public String modifyuser(Model model){
        model.addAttribute("bookingperson", reservationService.findBookingPerson());
        model.addAttribute("reservations",reservationService.findALLreservations());
        return "modifyuser";
    }

    @PostMapping("/savebookingperson")
    public String savebookingperson(@ModelAttribute BookingPerson bookingPerson, Model model){
        model.addAttribute("bookingperson", bookingPerson);
        reservationService.updateBookingPerson(bookingPerson);
        return "refpage";
    }


}
