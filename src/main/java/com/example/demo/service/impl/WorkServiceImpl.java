package com.example.demo.service.impl;


import com.example.demo.domain.Work;
import com.example.demo.dto.request.CreateWorkRequest;
import com.example.demo.dto.request.SearchWorkRequest;
import com.example.demo.dto.response.WorkResponse;
import com.example.demo.mapper.WorkDtoToEntityMapper;
import com.example.demo.repository.WorkRepository;
import com.example.demo.service.WorkService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class WorkServiceImpl implements WorkService {

    private final WorkRepository workRepository;
    private final WorkDtoToEntityMapper workDtoToEntityMapper;

    @Override
    public WorkResponse getById(Integer id) {
        Work work = workRepository.getById(id);

        return workDtoToEntityMapper.workEntityToDtoResponse(work);
    }

    @Override
    public void deleteById(Integer id) {workRepository.deleteById(id); }

    @Override
    public List<WorkResponse> search(SearchWorkRequest searchWorkRequest) {
        List<WorkResponse> result = new ArrayList<>();
        result = workRepository.findAll().stream()
                .map(workDtoToEntityMapper::workEntityToDtoResponse)
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public void create(CreateWorkRequest createWorkRequest) {
        Work newWork = workDtoToEntityMapper.workDtoToEntity(createWorkRequest);
        workRepository.save(newWork);
    }
}
