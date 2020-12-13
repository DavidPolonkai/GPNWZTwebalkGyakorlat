package com.meiit.webalk.GPNWZT;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    private BigDecimal amount;
    @NonNull
    private LocalDate rfrom;
    @NonNull
    private LocalDate rto;
    @NonNull
    private boolean active;
    @NonNull
    private boolean processed;
    @OneToOne
    private Room room;
    @ManyToOne
    private BookingPerson bookingPerson;



}
