package com.basikprogs.learningspring.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.basikprogs.learningspring.business.ReservationService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/guests")
@RequiredArgsConstructor
public class GuestController {
    private final ReservationService reservationService;
    
    @GetMapping
    public String getGuests(Model model) {
        model.addAttribute("guests", reservationService.getHotelGuests());
        return "guests";
    }
}
