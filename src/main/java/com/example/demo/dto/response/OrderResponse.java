package com.example.demo.dto.response;


import com.example.demo.domain.Part;
import com.example.demo.domain.Work;
import com.example.demo.enums.OrderStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class OrderResponse {
    private Integer id;
    private Integer technicId;
    private Integer clientId;
    private OrderStatus status;
    private Integer lastModifiedBy;
    private Set<Work> works;
    private Set<Part> parts;

}
