package com.example.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Entity
@Data
public class Technic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private Integer brandId;

    @ManyToOne
    @JoinColumn(name = "brandId", nullable = false, insertable = false,
            updatable = false)
    private Brand brand;

    @OneToMany(mappedBy = "technic")
    private Set<Order> orders;

}

