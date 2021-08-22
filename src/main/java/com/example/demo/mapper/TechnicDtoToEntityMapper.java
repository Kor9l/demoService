package com.example.demo.mapper;


import com.example.demo.domain.Technic;
import com.example.demo.dto.request.CreateTechnicRequest;
import com.example.demo.dto.response.TechnicResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TechnicDtoToEntityMapper {
    Technic technicDtoToEntity(CreateTechnicRequest createTechnicRequest);
    TechnicResponse technicEntityToDto(Technic technic);
}
