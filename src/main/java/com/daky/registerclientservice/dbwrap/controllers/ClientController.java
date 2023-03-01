package com.daky.registerclientservice.dbwrap.controllers;

import com.daky.registerclientservice.dbwrap.dto.ClientData;
import com.daky.registerclientservice.dbwrap.services.AbstractRegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {

    @Resource(name = "clientService")
    private AbstractRegisterService registerService;

    @PostMapping(value = "/clients")
    public ResponseEntity<?> createClient(@RequestBody ClientData clientData) {
        registerService.create(clientData);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/clients")
    public ResponseEntity<List<ClientData>> getAllClients() {
        final List<ClientData> clients = registerService.getAll();

        return clients != null &&  !clients.isEmpty()
                ? new ResponseEntity<>(clients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/clients/{id}")
    public ResponseEntity<?> getClientByID(@PathVariable(name = "id") long id) {
        final Optional<ClientData> client = registerService.getById(id);

        return client != null
                ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/clients/{id}")
    public ResponseEntity<?> updateClient(@PathVariable(name = "id") long id, @RequestBody ClientData clientData) {
        final boolean updated = registerService.update(clientData, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/clients/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable(name = "id") long id) {

        return registerService.delete(id)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
