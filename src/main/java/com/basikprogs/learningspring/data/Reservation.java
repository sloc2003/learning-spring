package com.basikprogs.learningspring.data;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "RESERVATION")
public class Reservation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RESERVATION_ID")
    private long id;

    @Column(name = "ROOM_ID")
    private long roomId;
    
    @Column(name = "GUEST_ID")
    private long guestId;
    
    @Column(name = "RES_DATE")
    private Date reservationDate;

}
