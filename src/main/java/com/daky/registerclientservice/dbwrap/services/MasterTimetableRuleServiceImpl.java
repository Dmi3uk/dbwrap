package com.daky.registerclientservice.dbwrap.services;

import com.daky.registerclientservice.dbwrap.converters.MasterTimetableRuleConverterImpl;
import com.daky.registerclientservice.dbwrap.dto.MasterTimetableRuleData;
import com.daky.registerclientservice.dbwrap.entries.MasterTimetableRule;
import com.daky.registerclientservice.dbwrap.entries.compositekeys.MasterTimetableRuleKey;
import com.daky.registerclientservice.dbwrap.repositories.MasterTimetableRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("masterTimetableRulesService")
public class MasterTimetableRuleServiceImpl implements AbstractRegisterService<MasterTimetableRuleData, MasterTimetableRuleData, MasterTimetableRuleKey> {

    @Autowired
    private MasterTimetableRuleRepository masterTimetableRuleRepository;
    @Autowired
    private MasterTimetableRuleConverterImpl masterTimetableRulesConverter;

    @Override
    public MasterTimetableRuleData create(MasterTimetableRuleData masterTimetableRuleData) {
        MasterTimetableRule masterTimetableRule = masterTimetableRulesConverter.populateEntity(masterTimetableRuleData);
        return masterTimetableRulesConverter.populateData(masterTimetableRuleRepository.save(masterTimetableRule));
    }

    @Override
    public List<MasterTimetableRuleData> getAll() {
        List<MasterTimetableRuleData> masterTimetableRuleDataList = new ArrayList<>();
        List<MasterTimetableRule> masterTimetableRuleList = masterTimetableRuleRepository.findAll();
        masterTimetableRuleList.forEach(masterTimetableRule -> {
            masterTimetableRuleDataList.add(masterTimetableRulesConverter.populateData(masterTimetableRule));
        });
        return masterTimetableRuleDataList;
    }

    @Override
    public Optional<MasterTimetableRuleData> getById(MasterTimetableRuleKey id) {
        Optional<MasterTimetableRule> masterTimetableRules = masterTimetableRuleRepository.findById(id);
        if(masterTimetableRules.isEmpty()) {
            return null;
        }
        return Optional.of(masterTimetableRulesConverter.populateData(masterTimetableRules.get()));
    }

    @Override
    public boolean update(MasterTimetableRuleData masterTimetableRuleData, MasterTimetableRuleKey id) {
        if (masterTimetableRuleRepository.existsById(id)) {
            MasterTimetableRule masterTimetableRule = masterTimetableRulesConverter.populateEntity(masterTimetableRuleData);
            masterTimetableRule.setId(id);
            masterTimetableRuleRepository.save(masterTimetableRule);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(MasterTimetableRuleKey id) {
        if (masterTimetableRuleRepository.existsById(id)) {
            masterTimetableRuleRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
