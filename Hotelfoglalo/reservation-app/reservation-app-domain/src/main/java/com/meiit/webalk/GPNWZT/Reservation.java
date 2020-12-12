package com.meiit.webalk.GPNWZT;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private BigDecimal amount;
    private LocalDate rfrom;
    private LocalDate rto;
    private boolean active;
    private boolean processed;
    @ManyToOne
    private Room room;

    public Reservation(BigDecimal amount, LocalDate rfrom, LocalDate rto, boolean active, boolean processed, Room room) {
        this.amount = amount;
        this.rfrom = rfrom;
        this.rto = rto;
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

    public LocalDate getRfrom() {
        return rfrom;
    }

    public void setRfrom(LocalDate from) {
        this.rfrom = from;
    }

    public LocalDate getRto() {
        return rto;
    }

    public void setRto(LocalDate to) {
        this.rto = to;
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
        return "Reservation [active=" + active + ", amount=" + amount + ", from=" + rfrom + ", processed=" + processed
                + ", to=" + rto + "]";
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
