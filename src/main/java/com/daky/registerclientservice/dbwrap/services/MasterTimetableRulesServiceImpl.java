package com.daky.registerclientservice.dbwrap.services;

import com.daky.registerclientservice.dbwrap.converters.MasterTimetableRulesConverterImpl;
import com.daky.registerclientservice.dbwrap.dto.MasterTimetableRulesData;
import com.daky.registerclientservice.dbwrap.entries.MasterTimetableRules;
import com.daky.registerclientservice.dbwrap.entries.compositekeys.MasterTimetableRulesKey;
import com.daky.registerclientservice.dbwrap.repositories.MasterTimetableRulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("masterTimetableRulesService")
public class MasterTimetableRulesServiceImpl implements AbstractRegisterService<MasterTimetableRulesData, MasterTimetableRulesData, MasterTimetableRulesKey> {

    @Autowired
    private MasterTimetableRulesRepository masterTimetableRulesRepository;
    @Autowired
    MasterTimetableRulesConverterImpl masterTimetableRulesConverter;

    @Override
    public MasterTimetableRulesData create(MasterTimetableRulesData masterTimetableRulesData) {
        MasterTimetableRules masterTimetableRules = masterTimetableRulesConverter.populateEntity(masterTimetableRulesData);
        return masterTimetableRulesConverter.populateData(masterTimetableRulesRepository.save(masterTimetableRules));
    }

    @Override
    public List<MasterTimetableRulesData> getAll() {
        List<MasterTimetableRulesData> masterTimetableRulesDataList = new ArrayList<>();
        List<MasterTimetableRules> masterTimetableRulesList = masterTimetableRulesRepository.findAll();
        masterTimetableRulesList.forEach(masterTimetableRules -> {
            masterTimetableRulesDataList.add(masterTimetableRulesConverter.populateData(masterTimetableRules));
        });
        return masterTimetableRulesDataList;
    }

    @Override
    public Optional<MasterTimetableRulesData> getById(MasterTimetableRulesKey id) {
        Optional<MasterTimetableRules> masterTimetableRules = masterTimetableRulesRepository.findById(id);
        if(masterTimetableRules.isEmpty()) {
            return null;
        }
        return Optional.of(masterTimetableRulesConverter.populateData(masterTimetableRules.get()));
    }

    @Override
    public boolean update(MasterTimetableRulesData masterTimetableRulesData, MasterTimetableRulesKey id) {
        if (masterTimetableRulesRepository.existsById(id)) {
            MasterTimetableRules masterTimetableRules = masterTimetableRulesConverter.populateEntity(masterTimetableRulesData);
            masterTimetableRules.setId(id);
            masterTimetableRulesRepository.save(masterTimetableRules);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(MasterTimetableRulesKey id) {
        if (masterTimetableRulesRepository.existsById(id)) {
            masterTimetableRulesRepository.deleteById(id);
            return true;
        }
        return false;
    }


}