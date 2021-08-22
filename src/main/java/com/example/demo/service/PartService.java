package com.example.demo.service;


import com.example.demo.dto.request.CreatePartRequest;
import com.example.demo.dto.request.SearchPartRequest;
import com.example.demo.dto.response.PartResponse;

public interface PartService {
    PartResponse getById(Integer id);

    void deleteById(Integer id);

    PartResponse search(SearchPartRequest searchPartRequest);

    void create(CreatePartRequest createPartRequest);
}
