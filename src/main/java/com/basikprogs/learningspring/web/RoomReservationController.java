package com.basikprogs.learningspring.web;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.basikprogs.learningspring.business.ReservationService;
import com.basikprogs.learningspring.business.RoomReservation;
import com.basikprogs.learningspring.util.DateUtils;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class RoomReservationController {
    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    @GetMapping
    private String getReservations(@RequestParam(value = "date", required = false) String dateString, Model model) {
        Date date = this.dateUtils.createDateFromDateString(dateString);
        List<RoomReservation> roomReservations = this.reservationService.getRoomReservationsForDate(date);
        model.addAttribute("roomReservations", roomReservations);
        return "roomres";
    }

}
