package com.example.demo.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
public class Part {

    @Id
    private Integer partNumber;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Double price;

    @ManyToMany(mappedBy = "order_parts")
    Set<Orders> partForOrders  = new HashSet<>();


}
