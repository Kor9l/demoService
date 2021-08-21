package com.example.demo.service.impl;


import com.example.demo.domain.Client;
import com.example.demo.dto.request.CreateClientRequest;
import com.example.demo.dto.request.SearchClientRequest;
import com.example.demo.dto.request.UpdateClientRequest;
import com.example.demo.dto.response.ClientResponse;
import com.example.demo.mapper.ClientDtoToEntityMapper;
import com.example.demo.repository.ClientRepository;
import com.example.demo.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientDtoToEntityMapper clientDtoToEntityMapper;

    @Override
    public ClientResponse getById(Integer id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client with id:" + id + " not found."));
        return clientDtoToEntityMapper.clientEntityToDto(client);
    }

    @Override
    public void deleteById(Integer id) {
        clientRepository.deleteById(id);
    }

    @Override
    public void create(CreateClientRequest createClientRequest) {
        Client newClient = clientDtoToEntityMapper.ClientDtoToEntity(createClientRequest);
        clientRepository.save(newClient);
    }

    @Override
    public ClientResponse search(SearchClientRequest searchClientRequest) {
        Client client = clientRepository.findByFullNameContaining(searchClientRequest.getFullName());

        return clientDtoToEntityMapper.clientEntityToDto(client);
    }

    @Override
    public ClientResponse update(UpdateClientRequest updateClientRequest) {
        Client client = clientRepository.findById(updateClientRequest.getId())
                .orElseThrow(()-> new EntityNotFoundException("Client with id:"
                +updateClientRequest.getId() + " not found."));
        client.setEmail(updateClientRequest.getEmail());
        client.setFullName(updateClientRequest.getFullName());
        client.setTelNumber(updateClientRequest.getTelNumber());
        clientRepository.save(client);

        return clientDtoToEntityMapper.clientEntityToDto(client);
    }
}
