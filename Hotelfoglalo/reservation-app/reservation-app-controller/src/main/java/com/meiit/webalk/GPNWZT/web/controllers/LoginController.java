package com.meiit.webalk.GPNWZT.web.controllers;

import java.util.Optional;

import com.meiit.webalk.GPNWZT.User;
import com.meiit.webalk.GPNWZT.services.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping({"/login"})
    public String login(@RequestParam Optional<String> fail,Model model){
        if (fail.isPresent() && fail.get().equals("true")){
            model.addAttribute("fail", "Invalid password or username");
            model.addAttribute("alertClass","alert-danger");
        }
        else model.addAttribute("fail","");
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/reg")
    public String saveuser(@ModelAttribute User user,Model model){
        model.addAttribute("user", user);
        reservationService.saveBookingPersonUser(user);
        return "login";
    }





}
