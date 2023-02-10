package com.daky.registerclientservice.dbwrap.service;

import com.daky.registerclientservice.dbwrap.dto.ClientData;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    /**
     * Creates a new client
     * @param clientData - client to create
     */
    ClientData create(ClientData clientData);

    /**
     * Returns a list of all available clients
     * @return list of clients
     */
    List<ClientData> getAllClients();

    /**
     * Returns the client by its ID
     * @param id - Client ID
     * @return - client object with the specified ID
     */
    Optional<ClientData> getClientById(long id);

    /**
     * Updates the client with the specified ID
     * @param clientData - the client according to which the data needs to be updated
     * @param id - id of the client to update
     * @return - true if the data has been updated, otherwise false
     */
    boolean updateClient(ClientData clientData, long id);

    /**
     * Deletes a client with the specified ID
     * @param id - id of the client to delete
     * @return - true if the client was deleted, otherwise false
     */
    boolean deleteClient(long id);
}

