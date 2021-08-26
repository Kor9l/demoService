package com.example.demo.controller;

import com.example.demo.dto.request.CreateClientRequest;
import com.example.demo.dto.response.ClientResponse;
import com.example.demo.dto.response.MessageResponse;
import com.example.demo.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client")
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> getById(@PathVariable Integer id) {
        ClientResponse clientResponse = clientService.getById(id);
        return new ResponseEntity<>(clientResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MessageResponse> create(@RequestBody CreateClientRequest createClientRequest) {
        clientService.create(createClientRequest);
        return new ResponseEntity<>(new MessageResponse("Create successfully"), HttpStatus.OK);
    }
}
