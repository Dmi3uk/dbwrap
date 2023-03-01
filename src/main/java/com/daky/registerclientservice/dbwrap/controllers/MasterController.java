package com.daky.registerclientservice.dbwrap.controllers;

import com.daky.registerclientservice.dbwrap.dto.MasterData;
import com.daky.registerclientservice.dbwrap.services.AbstractRegisterService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
public class MasterController {

    @Resource(name = "masterService")
    private AbstractRegisterService registerService;


    @PostMapping(value = "/masters")
    public ResponseEntity<?> create(@RequestBody MasterData masterData) {
        registerService.create(masterData);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/masters")
    public ResponseEntity<List<MasterData>> getAllMasters() {
        final List<MasterData> masters = registerService.getAll();

        return masters != null &&  !masters.isEmpty()
                ? new ResponseEntity<>(masters, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/masters/{id}")
    public ResponseEntity<?> getMasterByID(@PathVariable(name = "id") long id) {
        final Optional<MasterData> master = registerService.getById(id);

        return master != null
                ? new ResponseEntity<>(master, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/masters/{id}")
    public ResponseEntity<?> updateMaster(@PathVariable(name = "id") long id, @RequestBody MasterData masterData) {
        final boolean updated = registerService.update(masterData, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/masters/{id}")
    public ResponseEntity<?> deleteMaster(@PathVariable(name = "id") long id) {

        return registerService.delete(id)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
