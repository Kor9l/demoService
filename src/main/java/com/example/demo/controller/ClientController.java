package com.example.demo.controller;

import com.example.demo.dto.request.SearchClientRequest;
import com.example.demo.dto.response.ClientResponse;
import com.example.demo.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/client")
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<ClientResponse> search(SearchClientRequest searchClientRequest) {
        return new ResponseEntity(clientService.search(searchClientRequest), HttpStatus.OK);
    }
}
