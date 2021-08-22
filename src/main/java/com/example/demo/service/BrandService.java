package com.example.demo.service;


import com.example.demo.dto.request.CreateBrandRequest;
import com.example.demo.dto.request.SearchBrandRequest;
import com.example.demo.dto.response.BrandResponse;

public interface BrandService {
    BrandResponse getById(Integer id);

    void deleteById(Integer id);

    BrandResponse search(SearchBrandRequest searchBrandRequest);

    void create(CreateBrandRequest createBrandRequest);
}
