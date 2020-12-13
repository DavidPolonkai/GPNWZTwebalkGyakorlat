package com.meiit.webalk.GPNWZT.web.controllers;

import com.meiit.webalk.GPNWZT.Hotel;
import com.meiit.webalk.GPNWZT.Room;
import com.meiit.webalk.GPNWZT.Wing;
import com.meiit.webalk.GPNWZT.services.ReservationService;
import com.meiit.webalk.GPNWZT.services.exceptions.NotEnoughBalance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    private Hotel hotel;

    @GetMapping("/hotels")
    public String hotels(Model model) {
        model.addAttribute("hotels", reservationService.findAllHotels());
        return "hotels";
    }

    @GetMapping("/bookhotel={ID}")
    public String bookhotel(@PathVariable(value = "ID") String id, Model model,RedirectAttributes redirectAttributes) {
        try {
            Long validid = Long.parseLong(id);
            this.hotel = reservationService.findHotelByID(validid);
            model.addAttribute("hotel", this.hotel);
            model.addAttribute("wings", reservationService.findWingsInHotel(this.hotel));
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message","Server side error");
            redirectAttributes.addFlashAttribute("alertClass","alert-danger");
            redirectAttributes.addFlashAttribute("link","logout");
            return "redirect:/errorpage";
        }
        return "wings";
    }

    @GetMapping("/wing={ID}")
    public String bookRoom(@PathVariable(value = "ID") String id, Model model,RedirectAttributes redirectAttributes) {
        try {
            Long validid = Long.parseLong(id);
            Wing wing = reservationService.findWingById(validid);
            model.addAttribute("hotel", this.hotel);
            model.addAttribute("wing", wing);
            model.addAttribute("rooms", reservationService.findRooms(wing));
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message","Server side error");
            redirectAttributes.addFlashAttribute("alertClass","alert-danger");
            redirectAttributes.addFlashAttribute("link","logout");
            return "redirect:/errorpage";
        }
        return "rooms";
    }

    @PostMapping("/bookroom")
    public String makereservation(@ModelAttribute Room room, Model model,RedirectAttributes redirectAttributes) {
        model.addAttribute("room", room);
        redirectAttributes.addFlashAttribute("message", null);
        try {
            Room roomall = reservationService.findRoomById(room.getId());
            reservationService.checkIn(roomall);
        } catch (NotEnoughBalance e) {
            redirectAttributes.addFlashAttribute("message",e.getMessage());
            redirectAttributes.addFlashAttribute("alertClass","alert-warning");
            redirectAttributes.addFlashAttribute("link","modifyuser");
            return "redirect:/errorpage";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message","Server side error");
            redirectAttributes.addFlashAttribute("alertClass","alert-danger");
            redirectAttributes.addFlashAttribute("link","logout");
            return "redirect:/errorpage";
        }
        return "refpage";
    }

    @GetMapping("/errorpage")
    public String error(Model model){
        return "errorpage";
    }

    @GetMapping("/deletereservation={ID}")
    public String deleteReservation(@PathVariable(value = "ID") String id, Model model,RedirectAttributes redirectAttributes) {
        try {
            reservationService.checkOut(Long.valueOf(id));
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message","Server side error");
            redirectAttributes.addFlashAttribute("alertClass","alert-danger");
            redirectAttributes.addFlashAttribute("link","logout");
            return "redirect:/errorpage";
        }
        return "refpage";
    }

}
