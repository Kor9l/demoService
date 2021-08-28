package com.example.demo.service.impl;


import com.example.demo.domain.Part;
import com.example.demo.dto.request.CreatePartRequest;
import com.example.demo.dto.request.SearchPartRequest;
import com.example.demo.dto.response.PartResponse;
import com.example.demo.mapper.PartDtoToEntityMapper;
import com.example.demo.repository.PartRepository;
import com.example.demo.service.PartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@AllArgsConstructor
public class PartServiceImpl implements PartService {

    private final PartRepository partRepository;
    private final PartDtoToEntityMapper partDtoToEntityMapper;


    @Override
    public PartResponse getById(Integer id) {
        Part part = partRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Part with id:" +id + " not found."));
        return partDtoToEntityMapper.partEntityToDto(part);
    }

    @Override
    public void deleteById(Integer id) {partRepository.deleteById(id); }

    @Override
    public PartResponse search(SearchPartRequest searchPartRequest) {
        Part part = partRepository.findByTitleContaining(searchPartRequest.getTitle());
        return partDtoToEntityMapper.partEntityToDto(part);
    }

    @Override
    public void create(CreatePartRequest createPartRequest) {
        Part newPart = partDtoToEntityMapper.partDtoToEntity(createPartRequest);
        partRepository.save(newPart);

    }
}
