package com.basikprogs.learningspring.webservice;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.basikprogs.learningspring.business.ReservationService;
import com.basikprogs.learningspring.business.RoomReservation;
import com.basikprogs.learningspring.data.Guest;
import com.basikprogs.learningspring.data.Room;
import com.basikprogs.learningspring.util.DateUtils;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class WebserviceController {
    private final DateUtils dateUtils;
    private final ReservationService reservationService;    

    @GetMapping("/reservations")
    public List<RoomReservation> getReservations(@RequestParam(value = "date", required = false) String dateString) {
        return this.reservationService.getRoomReservationsForDate(this.dateUtils.createDateFromDateString(dateString));
    }

    @GetMapping("/rooms")
    public List<Room> getRooms() {
        return this.reservationService.getHotelRooms();
    }

    @GetMapping("/guests")
    public List<Guest> getGuests() {
        return this.reservationService.getHotelGuests();
    }

    @PostMapping("/guests")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addGuest(@RequestBody Guest guest) {
        this.reservationService.addHotelGuest(guest);
    }
}
