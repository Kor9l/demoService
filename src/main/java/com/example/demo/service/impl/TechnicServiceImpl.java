package com.example.demo.service.impl;


import com.example.demo.domain.Technic;
import com.example.demo.dto.request.CreateTechnicRequest;
import com.example.demo.dto.request.SearchTechnicRequest;
import com.example.demo.dto.response.TechnicResponse;
import com.example.demo.mapper.TechnicDtoToEntityMapper;
import com.example.demo.repository.TechnicRepository;
import com.example.demo.service.TechnicService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@AllArgsConstructor
public class TechnicServiceImpl implements TechnicService {

    private final TechnicRepository technicRepository;
    private final TechnicDtoToEntityMapper technicDtoToEntityMapper;

    @Override
    public TechnicResponse getById(Integer id) {
        Technic technic = technicRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Technic with id:" +id+" not found."));
        return technicDtoToEntityMapper.technicEntityToDto(technic);
    }

    @Override
    public void deleteById(Integer id) {technicRepository.deleteById(id); }

    @Override
    public TechnicResponse search(SearchTechnicRequest searchTechnicRequest) {
        Technic technic = technicRepository.findByModelContaining(searchTechnicRequest.getModel());
        return technicDtoToEntityMapper.technicEntityToDto(technic);
    }

    @Override
    public void create(CreateTechnicRequest createTechnicRequest) {
        Technic newTechnic = technicDtoToEntityMapper.technicDtoToEntity(createTechnicRequest);
        technicRepository.save(newTechnic);

    }
}
