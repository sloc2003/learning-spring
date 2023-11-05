package com.basikprogs.learningspring.data;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReservationRepo extends CrudRepository<Reservation, Long>{
    List<Reservation> findByReservationDate(Date reservationDate);
}
