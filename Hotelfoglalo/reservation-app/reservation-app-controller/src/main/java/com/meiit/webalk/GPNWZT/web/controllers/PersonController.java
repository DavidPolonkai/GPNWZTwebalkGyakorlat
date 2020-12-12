package com.meiit.webalk.GPNWZT.web.controllers;

import java.util.Optional;

import javax.websocket.server.PathParam;

import com.meiit.webalk.GPNWZT.BookingPerson;
import com.meiit.webalk.GPNWZT.User;
import com.meiit.webalk.GPNWZT.repositories.UserRepository;
import com.meiit.webalk.GPNWZT.services.ReservationService;
import com.meiit.webalk.GPNWZT.services.domainservices.BookingPersonService;
import com.meiit.webalk.GPNWZT.services.domainservices.UserService;
import com.meiit.webalk.GPNWZT.services.security.MyUserPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonController {

    @Autowired
    private ReservationService reservationService;


    @GetMapping("/modifyuser")
    public String modifyuser(Model model){
        model.addAttribute("bookingperson", reservationService.findBookingPerson());
        return "modifyuser";
    }

    @PostMapping("/savebookingperson")
    public String savebookingperson(@ModelAttribute BookingPerson bookingPerson, Model model){
        model.addAttribute("bookingperson", bookingPerson);
        reservationService.updateBookingPerson(bookingPerson);
        System.out.println(bookingPerson);
        return "refpage";
    }

}
