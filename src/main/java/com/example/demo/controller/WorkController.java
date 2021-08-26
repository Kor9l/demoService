package com.example.demo.controller;

import com.example.demo.dto.request.CreateWorkRequest;
import com.example.demo.dto.response.MessageResponse;
import com.example.demo.dto.response.WorkResponse;
import com.example.demo.service.WorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/work")
public class WorkController {


    private final WorkService workService;

    @PostMapping
    public ResponseEntity<MessageResponse> create(@RequestBody CreateWorkRequest createWorkRequest) {
        workService.create(createWorkRequest);
        return new ResponseEntity<>(new MessageResponse("Create successfully."), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkResponse> findById(@PathVariable Integer id) {
        WorkResponse workResponse = workService.getById(id);
        return new ResponseEntity<>(workResponse, HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteById(@PathVariable Integer id) {
        workService.deleteById(id);
        return new ResponseEntity<>(new MessageResponse("Delete successfully."), HttpStatus.OK);
    }
}

