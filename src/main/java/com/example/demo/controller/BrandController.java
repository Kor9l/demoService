package com.example.demo.controller;

import com.example.demo.dto.request.CreateBrandRequest;
import com.example.demo.dto.response.BrandResponse;
import com.example.demo.dto.response.MessageResponse;
import com.example.demo.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/brand")
public class BrandController {
    public final BrandService brandService;

    @GetMapping("/{id}")
    public ResponseEntity<BrandResponse> findById(@PathVariable Integer id) {
        BrandResponse brandResponse = brandService.getById(id);
        return new ResponseEntity<>(brandResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> delete(@PathVariable Integer id) {
        brandService.deleteById(id);
        return new ResponseEntity<>(new MessageResponse("Delete successfully."), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MessageResponse> create(@RequestBody CreateBrandRequest createBrandRequest) {
        brandService.create(createBrandRequest);
        return new ResponseEntity<>(new MessageResponse("Create successfully."), HttpStatus.CREATED);
    }

}
