package com.meiit.webalk.reservation.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingPerson extends User {
    private String name;
    private String account;
    private BigDecimal balance;
    private LocalDate birth;
    private Currency currency;
    // Person dont have reservation list field
    private Reservation reservation;

    public BookingPerson(String name, String account, BigDecimal balance, LocalDate birth, Currency currency) {
        super();
        this.name = name;
        this.account = account;
        this.balance = balance;
        this.birth = birth;
        this.currency = currency;
        this.reservation = null;
    }

    public BookingPerson(String email, String password, String name, String account, BigDecimal balance,
            LocalDate birth) {
        super(email, password);
        this.name = name;
        this.account = account;
        this.balance = balance;
        this.birth = birth;
        this.currency = currency;
        this.reservation = null;
    }

    public BookingPerson() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "BookingPerson [account=" + account + ", balance=" + balance + ", birth=" + birth + ", currency="
                + currency + ", name=" + name + ", reservations=" + reservation + "]";
    }
}
