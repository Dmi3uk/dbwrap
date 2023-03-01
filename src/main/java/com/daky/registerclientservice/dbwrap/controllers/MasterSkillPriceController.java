package com.daky.registerclientservice.dbwrap.controllers;

import com.daky.registerclientservice.dbwrap.dto.MasterSkillPriceData;
import com.daky.registerclientservice.dbwrap.entries.compositekeys.MasterSkillKey;
import com.daky.registerclientservice.dbwrap.services.AbstractRegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
public class MasterSkillPriceController {
    @Resource(name = "masterSkillPriceService")
    private AbstractRegisterService registerService;


    @PostMapping(value = "/masterSkillPrices")
    public ResponseEntity<?> create(@RequestBody MasterSkillPriceData masterSkillPriceData) {
        registerService.create(masterSkillPriceData);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/masterSkillPrices")
    public ResponseEntity<List<MasterSkillPriceData>> getAllMasterSkillPrices() {
        final List<MasterSkillPriceData> masterSkillPriceDataList = registerService.getAll();

        return masterSkillPriceDataList != null &&  !masterSkillPriceDataList.isEmpty()
                ? new ResponseEntity<>(masterSkillPriceDataList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/masterSkillPrices/id")
    public ResponseEntity<?> getMasterSkillPriceByID(@RequestParam(name = "masterID") long masterID,
                                                     @RequestParam(name = "skillID") long skillID) {
        MasterSkillKey id = new MasterSkillKey(masterID, skillID);
        final Optional<MasterSkillPriceData> masterSkillPriceData = registerService.getById(id);

        return masterSkillPriceData != null
                ? new ResponseEntity<>(masterSkillPriceData, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/masterSkillPrices/id")
    public ResponseEntity<?> updateMasterSkillPrice(@RequestParam(name = "masterID") long masterID,
                                                    @RequestParam(name = "skillID") long skillID,
                                                    @RequestBody MasterSkillPriceData masterSkillPriceData) {
        MasterSkillKey id = new MasterSkillKey(masterID, skillID);
        final boolean updated = registerService.update(masterSkillPriceData, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/masterSkillPrices/id")
    public ResponseEntity<?> deleteMasterSkillPrice(@RequestParam(name = "masterID") long masterID,
                                                    @RequestParam(name = "skillID") long skillID) {

        MasterSkillKey id = new MasterSkillKey(masterID, skillID);
        return registerService.delete(id)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
