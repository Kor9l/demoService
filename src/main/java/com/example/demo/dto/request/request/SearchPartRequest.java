package com.example.demo.dto.request.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SearchPartRequest {
    private String partNumber;
    private String title;
}
