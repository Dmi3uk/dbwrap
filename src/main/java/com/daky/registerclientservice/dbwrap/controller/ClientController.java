package com.daky.registerclientservice.dbwrap.controller;

import com.daky.registerclientservice.dbwrap.dto.ClientData;
import com.daky.registerclientservice.dbwrap.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {

    @Resource(name = "clientService")
    private ClientService clientService;


    @PostMapping(value = "/clients")
    public ResponseEntity<?> create(@RequestBody ClientData clientData) {
        clientService.create(clientData);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/clients")
    public ResponseEntity<List<ClientData>> read() {
        final List<ClientData> clients = clientService.getAllClients();

        return clients != null &&  !clients.isEmpty()
                ? new ResponseEntity<>(clients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/clients/{id}")
    public ResponseEntity<?> read(@PathVariable(name = "id") long id) {
        final Optional<ClientData> client = clientService.getClientById(id);

        return client != null
                ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/clients/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody ClientData clientData) {
        final boolean updated = clientService.updateClient(clientData, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/clients/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {

        return clientService.deleteClient(id)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
