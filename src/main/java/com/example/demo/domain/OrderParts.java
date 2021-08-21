package com.example.demo.domain;



import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@Data
public class OrderParts implements Serializable {

    @Id
    private Integer partNumber;

    @Id
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "partNumber")
    private Part part;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;
}
