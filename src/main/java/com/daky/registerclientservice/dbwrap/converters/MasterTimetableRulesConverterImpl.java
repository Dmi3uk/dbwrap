package com.daky.registerclientservice.dbwrap.converters;

import com.daky.registerclientservice.dbwrap.dto.MasterTimetableRulesData;
import com.daky.registerclientservice.dbwrap.entries.MasterTimetableRules;
import org.springframework.stereotype.Component;

@Component
public class MasterTimetableRulesConverterImpl implements AbstractConverter<MasterTimetableRulesData, MasterTimetableRules> {
    @Override
    public MasterTimetableRulesData populateData(MasterTimetableRules masterTimetableRules) {
        MasterTimetableRulesData masterTimetableRulesData = new MasterTimetableRulesData();
        masterTimetableRulesData.setId(masterTimetableRules.getId());
        masterTimetableRulesData.setMaster(masterTimetableRules.getMaster());
        masterTimetableRulesData.setWorkday(masterTimetableRules.getWorkday());
        masterTimetableRulesData.setStartTime(masterTimetableRules.getStartTime());
        masterTimetableRulesData.setEndTime(masterTimetableRules.getEndTime());
        return masterTimetableRulesData;
    }

    @Override
    public MasterTimetableRules populateEntity(MasterTimetableRulesData masterTimetableRulesData) {
        MasterTimetableRules masterTimetableRules = new MasterTimetableRules();
        masterTimetableRules.setId(masterTimetableRulesData.getId());
        masterTimetableRules.setMaster(masterTimetableRulesData.getMaster());
        masterTimetableRules.setWorkday(masterTimetableRulesData.getWorkday());
        masterTimetableRules.setStartTime(masterTimetableRulesData.getStartTime());
        masterTimetableRules.setEndTime(masterTimetableRulesData.getEndTime());
        return masterTimetableRules;
    }
}
