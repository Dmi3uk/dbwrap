package com.daky.registerclientservice.dbwrap.services;

import com.daky.registerclientservice.dbwrap.converters.ClientConverterImpl;
import com.daky.registerclientservice.dbwrap.entries.Client;
import com.daky.registerclientservice.dbwrap.dto.ClientData;
import com.daky.registerclientservice.dbwrap.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("clientService")
public class ClientServiceImpl implements AbstractRegisterService<ClientData, ClientData, Long> {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientConverterImpl clientConverter;

    @Override
    public ClientData create(ClientData clientData) {
        Client client = clientConverter.populateEntity(clientData);
        return clientConverter.populateData(clientRepository.save(client));
    }

    @Override
    public List<ClientData> getAll() {
        List<ClientData> clients = new ArrayList<>();
        List<Client> clientList = clientRepository.findAll();
        clientList.forEach(client -> {
            clients.add(clientConverter.populateData(client));
        });
        return clients;
    }

    @Override
    public Optional<ClientData> getById(Long clientId) {
        Optional<Client> client = clientRepository.findById(clientId);
        if(client.isEmpty()) {
            return null;
        }
        return Optional.of(clientConverter.populateData(client.get()));
    }

    @Override
    public boolean update(ClientData clientData, Long clientId) {
        if (clientRepository.existsById(clientId)) {
            Client client = clientConverter.populateEntity(clientData);
            client.setId(clientId);
            clientRepository.save(client);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long clientId) {
        if (clientRepository.existsById(clientId)) {
            clientRepository.deleteById(clientId);
            return true;
        }
        return false;
    }
}