package com.daky.registerclientservice.dbwrap.converters;

import com.daky.registerclientservice.dbwrap.dto.MasterTimetableRuleData;
import com.daky.registerclientservice.dbwrap.entries.MasterTimetableRule;
import org.springframework.stereotype.Component;

@Component
public class MasterTimetableRuleConverterImpl implements AbstractConverter<MasterTimetableRuleData, MasterTimetableRule> {
    @Override
    public MasterTimetableRuleData populateData(MasterTimetableRule masterTimetableRule) {
        MasterTimetableRuleData masterTimetableRuleData = new MasterTimetableRuleData();
        masterTimetableRuleData.setId(masterTimetableRule.getId());
        masterTimetableRuleData.setMaster(masterTimetableRule.getMaster());
        masterTimetableRuleData.setWorkday(masterTimetableRule.getWorkday());
        masterTimetableRuleData.setStartTime(masterTimetableRule.getStartTime());
        masterTimetableRuleData.setEndTime(masterTimetableRule.getEndTime());
        return masterTimetableRuleData;
    }

    @Override
    public MasterTimetableRule populateEntity(MasterTimetableRuleData masterTimetableRuleData) {
        MasterTimetableRule masterTimetableRule = new MasterTimetableRule();
        masterTimetableRule.setId(masterTimetableRuleData.getId());
        masterTimetableRule.setMaster(masterTimetableRuleData.getMaster());
        masterTimetableRule.setWorkday(masterTimetableRuleData.getWorkday());
        masterTimetableRule.setStartTime(masterTimetableRuleData.getStartTime());
        masterTimetableRule.setEndTime(masterTimetableRuleData.getEndTime());
        return masterTimetableRule;
    }
}
