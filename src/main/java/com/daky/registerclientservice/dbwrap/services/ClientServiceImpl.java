package com.daky.registerclientservice.dbwrap.services;

import com.daky.registerclientservice.dbwrap.entries.Client;
import com.daky.registerclientservice.dbwrap.dto.ClientData;
import com.daky.registerclientservice.dbwrap.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("clientService")
public class ClientServiceImpl implements RegisterService<ClientData,ClientData> {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientData create(ClientData clientData) {
        Client client = populateClientEntity(clientData);
        return populateClientData(clientRepository.save(client));
    }

    @Override
    public List<ClientData> getAll() {
        List<ClientData> clients = new ArrayList<>();
        List<Client> clientList = clientRepository.findAll();
        clientList.forEach(client -> {
            clients.add(populateClientData(client));
        });
        return clients;
    }

    @Override
    public Optional<ClientData> getById(long clientId) {
        Optional<Client> client = clientRepository.findById(clientId);
        if(client.isEmpty()) {
            return null;
        }
        return Optional.of(populateClientData(client.get()));
    }

    @Override
    public boolean update(ClientData clientData, long clientId) {
        if (clientRepository.existsById(clientId)) {
            Client client = populateClientEntity(clientData);
            client.setId(clientId);
            clientRepository.save(client);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(long clientId) {
        if (clientRepository.existsById(clientId)) {
            clientRepository.deleteById(clientId);
            return true;
        }
        return false;
    }

    /**
     * Internal method to convert Customer JPA entity to the DTO object
     * for frontend data
     * @param client
     * @return clientData
     */
    private ClientData populateClientData(final Client client) {
        ClientData clientData = new ClientData();
        clientData.setId(client.getId());
        clientData.setName(client.getName());
        clientData.setSurname(client.getSurname());
        clientData.setEmail(client.getEmail());
        clientData.setPhone(client.getPhone());
        return clientData;
    }

    /**
     * Method to map the front end customer object to the JPA customer entity.
     * @param clientData
     * @return client
     */
    private Client populateClientEntity(ClientData clientData) {
        Client client = new Client();
        client.setName(clientData.getName());
        client.setSurname(clientData.getSurname());
        client.setEmail(clientData.getEmail());
        client.setPhone(clientData.getPhone());
        return client;
    }
}