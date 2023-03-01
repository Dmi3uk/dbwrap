package com.daky.registerclientservice.dbwrap.converters;

import com.daky.registerclientservice.dbwrap.dto.ClientData;
import com.daky.registerclientservice.dbwrap.entries.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientConverterImpl implements AbstractConverter<ClientData, Client> {

    @Override
    public ClientData populateData(final Client client) {
        ClientData clientData = new ClientData();
        clientData.setId(client.getId());
        clientData.setName(client.getName());
        clientData.setSurname(client.getSurname());
        clientData.setEmail(client.getEmail());
        clientData.setPhone(client.getPhone());
        return clientData;
    }

    @Override
    public Client populateEntity(ClientData clientData) {
        Client client = new Client();
        client.setName(clientData.getName());
        client.setSurname(clientData.getSurname());
        client.setEmail(clientData.getEmail());
        client.setPhone(clientData.getPhone());
        return client;
    }
}
