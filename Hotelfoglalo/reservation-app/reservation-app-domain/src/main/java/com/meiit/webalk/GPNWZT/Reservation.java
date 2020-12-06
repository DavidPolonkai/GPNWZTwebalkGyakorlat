package com.meiit.webalk.reservation.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Reservation {
    private BigDecimal amount;
    private LocalDate from;
    private LocalDate to;
    private boolean active;
    private boolean processed;
    private Room room;

    public Reservation(BigDecimal amount, LocalDate from, LocalDate to, boolean active, boolean processed, Room room) {
        this.amount = amount;
        this.from = from;
        this.to = to;
        this.active = active;
        this.processed = processed;
        this.room = room;
    }

    public Reservation() {

    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    @Override
    public String toString() {
        return "Reservation [active=" + active + ", amount=" + amount + ", from=" + from + ", processed=" + processed
                + ", to=" + to + "]";
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

}
