package com.example.demo.domain;

import com.example.demo.enums.OrderStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer technicId;

    @Column(nullable = false)
    private Integer clientId;

    @Column(nullable = false)
    private OrderStatus status;

    @Column(nullable = false)
    private Long lastModifiedBy;

    @ManyToOne
    @JoinColumn(name = "lastModifiedBy", nullable = false, updatable = false, insertable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "clientId", nullable = false, updatable = false, insertable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "technicId", nullable = false, updatable = false, insertable = false)
    private Technic technic;


}
