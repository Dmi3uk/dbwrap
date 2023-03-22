package com.daky.registerclientservice.dbwrap.controllers;

import com.daky.registerclientservice.dbwrap.dto.MasterTimetableRuleData;
import com.daky.registerclientservice.dbwrap.entries.compositekeys.MasterTimetableRuleKey;
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
public class MasterTimetableRuleController {

    @Resource(name = "masterTimetableRulesService")
    private AbstractRegisterService registerService;

    @PostMapping(value = "/masterTimetableRules")
    public ResponseEntity<?> create(@RequestBody MasterTimetableRuleData masterTimetableRuleData) {
        registerService.create(masterTimetableRuleData);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/masterTimetableRules")
    public ResponseEntity<List<MasterTimetableRuleData>> getAllMasterTimetableRules() {
        final List<MasterTimetableRuleData> masterTimetableRuleDataList = registerService.getAll();

        return masterTimetableRuleDataList != null &&  !masterTimetableRuleDataList.isEmpty()
                ? new ResponseEntity<>(masterTimetableRuleDataList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/masterTimetableRules/id")
    public ResponseEntity<?> getMasterTimetableRuleByID(@RequestParam(name = "masterID") long masterID,
                                                         @RequestParam(name = "workday") String workday) {
        MasterTimetableRuleKey id = new MasterTimetableRuleKey(masterID, workday);
        final Optional<MasterTimetableRuleData> masterTimetableRulesData = registerService.getById(id);

        return masterTimetableRulesData != null
                ? new ResponseEntity<>(masterTimetableRulesData, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/masterTimetableRules/id")
    public ResponseEntity<?> updateMasterTimetableRule(@RequestParam(name = "masterID") long masterID,
                                                        @RequestParam(name = "workday") String workday,
                                                        @RequestBody MasterTimetableRuleData masterTimetableRuleData) {
        MasterTimetableRuleKey id = new MasterTimetableRuleKey(masterID, workday);
        final boolean updated = registerService.update(masterTimetableRuleData, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/masterTimetableRules/id")
    public ResponseEntity<?> deleteMasterTimetableRule(@RequestParam(name = "masterID") long masterID,
                                                        @RequestParam(name = "workday") String workday) {

        MasterTimetableRuleKey id = new MasterTimetableRuleKey(masterID, workday);
        return registerService.delete(id)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
