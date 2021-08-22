package com.example.demo.mapper;


import com.example.demo.domain.Work;
import com.example.demo.dto.request.CreateWorkRequest;
import com.example.demo.dto.response.WorkResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkDtoToEntityMapper {
    Work workDtoToEntity(CreateWorkRequest createWorkRequest);
    WorkResponse workEntityToDtoResponse(Work work);
}
