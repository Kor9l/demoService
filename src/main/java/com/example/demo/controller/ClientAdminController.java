package com.example.demo.controller;

import com.example.demo.dto.request.UpdateClientRequest;
import com.example.demo.dto.response.ClientResponse;
import com.example.demo.dto.response.MessageResponse;
import com.example.demo.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/client")
public class ClientAdminController {
    private final ClientService clientService;

    @DeleteMapping("/{id}")
    public ResponseEntity<ClientResponse> deleteById(@PathVariable Integer id) {
        clientService.deleteById(id);
        return new ResponseEntity(new MessageResponse("Deleted successfully"), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ClientResponse> update(@RequestBody UpdateClientRequest updateClientRequest) {

        return new ResponseEntity<>(clientService.update(updateClientRequest), HttpStatus.OK);
    }
}
