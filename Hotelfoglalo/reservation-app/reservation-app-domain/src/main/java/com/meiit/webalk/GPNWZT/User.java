package com.meiit.webalk.GPNWZT;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
// @AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    private String email;
    @NonNull
    private String password;

    @NonNull
    @OneToOne
    private BookingPerson bookingPerson;

    @Override
    public String toString() {
        return "User [email=" + email + ", password=" + password + "]";
    }

    public User(String email,String password){
        this.email=email;
        this.password=password;
    }

}