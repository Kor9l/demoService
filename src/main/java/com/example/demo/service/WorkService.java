package com.example.demo.service;


import com.example.demo.dto.request.CreateWorkRequest;
import com.example.demo.dto.request.SearchWorkRequest;
import com.example.demo.dto.response.WorkResponse;

import java.util.List;

public interface WorkService {

    WorkResponse getById(Integer id);

    void deleteById(Integer id);

    List<WorkResponse> search(SearchWorkRequest searchWorkRequest);

    void create(CreateWorkRequest createWorkRequest);

}
