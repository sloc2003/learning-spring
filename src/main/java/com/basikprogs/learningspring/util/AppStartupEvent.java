package com.basikprogs.learningspring.util;

import java.util.Date;
import java.util.List;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.basikprogs.learningspring.business.ReservationService;
import com.basikprogs.learningspring.business.RoomReservation;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent>{
    private final ReservationService reservationService;
    private final DateUtils dateUtils;


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Date date = this.dateUtils.createDateFromDateString("2022-01-01");
        List<RoomReservation> resrvations = this.reservationService.getRoomReservationsForDate(date);
        resrvations.forEach(System.out::println);
    }
    
}
