package com.example.demo.mapper;


import com.example.demo.domain.Brand;
import com.example.demo.dto.request.CreateBrandRequest;
import com.example.demo.dto.response.BrandResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandDtoToEntityMapper {
    Brand brandDtoToEntity(CreateBrandRequest createBrandRequest);
    BrandResponse brandEntityToDto(Brand brand);
}
