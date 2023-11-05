package com.basikprogs.learningspring.data;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Long>{
    List<Reservation> findByReservationDate(Date reservationDate);
}
