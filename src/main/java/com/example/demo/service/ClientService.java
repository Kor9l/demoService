package com.example.demo.service;


import com.example.demo.dto.request.CreateClientRequest;
import com.example.demo.dto.request.SearchClientRequest;
import com.example.demo.dto.request.UpdateClientRequest;
import com.example.demo.dto.response.ClientResponse;

public interface ClientService {
    ClientResponse getById(Integer id);

    void deleteById(Integer id);

    void create(CreateClientRequest createClientRequest);

    ClientResponse search(SearchClientRequest searchClientRequest);

    ClientResponse update(UpdateClientRequest updateClientRequest);
}
