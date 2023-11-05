package com.basikprogs.learningspring.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.basikprogs.learningspring.data.Guest;
import com.basikprogs.learningspring.data.GuestRepo;
import com.basikprogs.learningspring.data.Reservation;
import com.basikprogs.learningspring.data.ReservationRepo;
import com.basikprogs.learningspring.data.Room;
import com.basikprogs.learningspring.data.RoomRepo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent>{

    private final RoomRepo  roomRepo;
    private final GuestRepo guestRepo;
    private final ReservationRepo reservationRepo;


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Iterable<Room> rooms = this.roomRepo.findAll();
        rooms.forEach(System.out::println);

        Iterable<Guest> guests = this.guestRepo.findAll();
        guests.forEach(System.out::println);

        Iterable<Reservation> reservations = this.reservationRepo.findAll();
        reservations.forEach(System.out::println);
    }
    
}
