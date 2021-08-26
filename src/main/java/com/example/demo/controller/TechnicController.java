package com.example.demo.controller;

import com.example.demo.dto.request.CreateTechnicRequest;
import com.example.demo.dto.response.MessageResponse;
import com.example.demo.dto.response.TechnicResponse;
import com.example.demo.service.TechnicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/technic")
public class TechnicController {
    private final TechnicService technicService;
    @PostMapping
    public ResponseEntity<MessageResponse> create(@RequestBody CreateTechnicRequest createTechnicRequest){
        technicService.create(createTechnicRequest);
        return new ResponseEntity<>(new MessageResponse("Create successfully."),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TechnicResponse> findById(@PathVariable Integer id) {
        TechnicResponse technicResponse = technicService.getById(id);
        return new ResponseEntity<>(technicResponse, HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteById(@PathVariable Integer id) {
        technicService.deleteById(id);
        return new ResponseEntity<>(new MessageResponse("Delete successfully."), HttpStatus.OK);
    }


}
