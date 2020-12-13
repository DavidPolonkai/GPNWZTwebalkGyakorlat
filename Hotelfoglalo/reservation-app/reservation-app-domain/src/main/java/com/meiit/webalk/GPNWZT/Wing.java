package com.meiit.webalk.GPNWZT;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Wing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    private String description;
    @NonNull
    @ManyToOne
    private Floor floor;
    
    @NonNull
    private WingType wingType;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "WING_ID")
    private List<Room> rooms;


}
