package com.example.demo.controller;

import com.example.demo.dto.request.CreatePartRequest;
import com.example.demo.dto.response.MessageResponse;
import com.example.demo.dto.response.PartResponse;
import com.example.demo.service.PartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/part")
public  class PartController {

    private final PartService partService;


    @GetMapping("/{id}")
    public ResponseEntity<PartResponse> findById(@PathVariable Integer id) {

        PartResponse partResponse = partService.getById(id);
        return new ResponseEntity<>(partResponse, HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteById(@PathVariable Integer id) {
        partService.deleteById(id);
        return new ResponseEntity<>(new MessageResponse("Delete successfully."), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MessageResponse> create(@RequestBody CreatePartRequest createPartRequest) {
        partService.create(createPartRequest);
        return new ResponseEntity<>(new MessageResponse("Create successfully."), HttpStatus.OK);
    }
}
