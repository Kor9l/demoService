package com.example.demo.service.impl;


import com.example.demo.domain.Brand;
import com.example.demo.dto.request.CreateBrandRequest;
import com.example.demo.dto.request.SearchBrandRequest;
import com.example.demo.dto.response.BrandResponse;
import com.example.demo.mapper.BrandDtoToEntityMapper;
import com.example.demo.repository.BrandRepository;
import com.example.demo.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final BrandDtoToEntityMapper brandDtoToEntityMapper;

    @Override
    public BrandResponse getById(Integer id) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Brand with id " + id + " not found."));
        return brandDtoToEntityMapper.brandEntityToDto(brand);
    }

    @Override
    public void deleteById(Integer id) { brandRepository.deleteById(id);}

    @Override
    public BrandResponse search(SearchBrandRequest searchBrandRequest) {
        Brand brand = brandRepository.findByNameContaining(searchBrandRequest.getName());
        return brandDtoToEntityMapper.brandEntityToDto(brand);
    }

    @Override
    public void create( CreateBrandRequest createBrandRequest) {
        Brand newBrand = brandDtoToEntityMapper.brandDtoToEntity(createBrandRequest);
        brandRepository.save(newBrand);

    }
}
