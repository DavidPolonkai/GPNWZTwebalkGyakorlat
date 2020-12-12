package com.meiit.webalk.GPNWZT;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;



@Entity
@Data
// @AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    private int number;
    @NonNull
    private int beds;
    @NonNull
    private boolean balcony;
    @NonNull
    private BigDecimal price;
    @NonNull
    @ManyToOne
    private Wing wing;


}
