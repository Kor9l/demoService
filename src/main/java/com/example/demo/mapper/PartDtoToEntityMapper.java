package com.example.demo.mapper;


import com.example.demo.domain.Part;
import com.example.demo.dto.request.CreatePartRequest;
import com.example.demo.dto.response.PartResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PartDtoToEntityMapper {
    Part partDtoToEntity(CreatePartRequest createPartRequest);
    PartResponse partEntityToDto(Part part);
}
