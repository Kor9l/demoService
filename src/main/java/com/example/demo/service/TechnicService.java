package com.example.demo.service;


import com.example.demo.dto.request.CreateTechnicRequest;
import com.example.demo.dto.request.SearchTechnicRequest;
import com.example.demo.dto.response.TechnicResponse;

public interface TechnicService {

    TechnicResponse getById(Integer id);

    void deleteById(Integer id);

    TechnicResponse search(SearchTechnicRequest searchTechnicRequest);

    void create(CreateTechnicRequest createTechnicRequest);

}
