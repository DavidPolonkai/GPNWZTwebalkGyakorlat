package com.meiit.webalk.GPNWZT;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
//@AllArgsConstructor
public class BookingPerson {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    private int accountnumber;

    @NonNull
    private String name;
    @NonNull
    private BigDecimal balance;
    @NonNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate birth;
    @NonNull
    @Column
    private Currency currency;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Reservation> reservations;



}
