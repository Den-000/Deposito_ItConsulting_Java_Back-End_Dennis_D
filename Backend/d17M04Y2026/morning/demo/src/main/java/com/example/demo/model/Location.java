package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "locations") // nome tabella

@Data // Lombok: genera getter, setter, toString, ecc.
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private String address;
    private String city;
}