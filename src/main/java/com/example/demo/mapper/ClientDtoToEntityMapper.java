package com.example.demo.mapper;


import com.example.demo.domain.Client;
import com.example.demo.dto.request.CreateClientRequest;
import com.example.demo.dto.response.ClientResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientDtoToEntityMapper {
    Client ClientDtoToEntity(CreateClientRequest createClientRequest);

    ClientResponse clientEntityToDto(Client client);
}
