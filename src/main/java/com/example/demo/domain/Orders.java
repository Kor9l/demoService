package com.example.demo.domain;

import com.example.demo.enums.OrderStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Entity
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer technicId;

    @Column(nullable = false)
    private Integer clientId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

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

     @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "order_works",
            joinColumns = @JoinColumn(name = "order_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "work_id",
                    referencedColumnName = "id"))
    private Set<Work> works ;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "order_parts",
            joinColumns = @JoinColumn(name = "order_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "part_number",
                    referencedColumnName = "partNumber"))
    private Set<Part> parts ;



}
