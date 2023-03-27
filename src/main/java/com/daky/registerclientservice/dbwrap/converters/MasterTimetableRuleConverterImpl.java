package com.daky.registerclientservice.dbwrap.converters;

import com.daky.registerclientservice.dbwrap.dto.MasterTimetableRuleData;
import com.daky.registerclientservice.dbwrap.dto.compositedata.MasterTimetableRuleKeyData;
import com.daky.registerclientservice.dbwrap.entries.MasterTimetableRule;
import com.daky.registerclientservice.dbwrap.entries.compositekeys.MasterTimetableRuleKey;
import org.springframework.stereotype.Component;

@Component
public class MasterTimetableRuleConverterImpl implements AbstractConverter<MasterTimetableRuleData, MasterTimetableRule> {
    @Override
    public MasterTimetableRuleData populateData(MasterTimetableRule masterTimetableRule) {
        MasterTimetableRuleData masterTimetableRuleData = new MasterTimetableRuleData();
        masterTimetableRuleData.setId(populateKeyData(masterTimetableRule.getId()));
        masterTimetableRuleData.setMaster(masterTimetableRule.getMaster());
        masterTimetableRuleData.setWorkday(masterTimetableRule.getWorkday());
        masterTimetableRuleData.setStartTime(masterTimetableRule.getStartTime());
        masterTimetableRuleData.setEndTime(masterTimetableRule.getEndTime());
        return masterTimetableRuleData;
    }

    @Override
    public MasterTimetableRule populateEntity(MasterTimetableRuleData masterTimetableRuleData) {
        MasterTimetableRule masterTimetableRule = new MasterTimetableRule();
        masterTimetableRule.setId(populateKeyEntity(masterTimetableRuleData.getId()));
        masterTimetableRule.setMaster(masterTimetableRuleData.getMaster());
        masterTimetableRule.setWorkday(masterTimetableRuleData.getWorkday());
        masterTimetableRule.setStartTime(masterTimetableRuleData.getStartTime());
        masterTimetableRule.setEndTime(masterTimetableRuleData.getEndTime());
        return masterTimetableRule;
    }

    public MasterTimetableRuleKeyData populateKeyData(MasterTimetableRuleKey masterTimetableRuleKey) {
        MasterTimetableRuleKeyData masterTimetableRuleKeyData = new MasterTimetableRuleKeyData();
        masterTimetableRuleKeyData.setMasterID(masterTimetableRuleKey.getMasterID());
        masterTimetableRuleKeyData.setWorkday(masterTimetableRuleKey.getWorkday());
        return masterTimetableRuleKeyData;
    }

    public MasterTimetableRuleKey populateKeyEntity(MasterTimetableRuleKeyData masterTimetableRuleKeyData) {
        MasterTimetableRuleKey masterTimetableRuleKey = new MasterTimetableRuleKey();
        masterTimetableRuleKey.setMasterID(masterTimetableRuleKeyData.getMasterID());
        masterTimetableRuleKey.setWorkday(masterTimetableRuleKeyData.getWorkday());
        return masterTimetableRuleKey;
    }
}
