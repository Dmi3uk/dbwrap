package com.daky.registerclientservice.dbwrap.controllers;

import com.daky.registerclientservice.dbwrap.dto.MasterTimetableRulesData;
import com.daky.registerclientservice.dbwrap.entries.compositekeys.MasterTimetableRulesKey;
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
public class MasterTimetableRulesController {

    @Resource(name = "masterTimetableRulesService")
    private AbstractRegisterService registerService;

    @PostMapping(value = "/masterTimetableRules")
    public ResponseEntity<?> create(@RequestBody MasterTimetableRulesData masterTimetableRulesData) {
        registerService.create(masterTimetableRulesData);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/masterTimetableRules")
    public ResponseEntity<List<MasterTimetableRulesData>> getAllMasterTimetableRules() {
        final List<MasterTimetableRulesData> masterTimetableRulesDataList = registerService.getAll();

        return masterTimetableRulesDataList != null &&  !masterTimetableRulesDataList.isEmpty()
                ? new ResponseEntity<>(masterTimetableRulesDataList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/masterTimetableRules/id")
    public ResponseEntity<?> getMasterTimetableRulesByID(@RequestParam(name = "masterID") long masterID,
                                                         @RequestParam(name = "workday") String workday) {
        MasterTimetableRulesKey id = new MasterTimetableRulesKey(masterID, workday);
        final Optional<MasterTimetableRulesData> masterTimetableRulesData = registerService.getById(id);

        return masterTimetableRulesData != null
                ? new ResponseEntity<>(masterTimetableRulesData, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/masterTimetableRules/id")
    public ResponseEntity<?> updateMasterTimetableRules(@RequestParam(name = "masterID") long masterID,
                                                        @RequestParam(name = "workday") String workday,
                                                        @RequestBody MasterTimetableRulesData masterTimetableRulesData) {
        MasterTimetableRulesKey id = new MasterTimetableRulesKey(masterID, workday);
        final boolean updated = registerService.update(masterTimetableRulesData, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/masterTimetableRules/id")
    public ResponseEntity<?> deleteMasterTimetableRules(@RequestParam(name = "masterID") long masterID,
                                                        @RequestParam(name = "workday") String workday) {

        MasterTimetableRulesKey id = new MasterTimetableRulesKey(masterID, workday);
        return registerService.delete(id)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
