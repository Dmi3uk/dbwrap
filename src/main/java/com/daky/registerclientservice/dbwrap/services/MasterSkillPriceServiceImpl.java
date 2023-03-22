package com.daky.registerclientservice.dbwrap.services;

import com.daky.registerclientservice.dbwrap.converters.MasterSkillPriceConverterImpl;
import com.daky.registerclientservice.dbwrap.dto.MasterSkillPriceData;
import com.daky.registerclientservice.dbwrap.entries.MasterSkillPrice;
import com.daky.registerclientservice.dbwrap.entries.compositekeys.MasterSkillKey;
import com.daky.registerclientservice.dbwrap.repositories.MasterSkillPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("masterSkillPriceService")
public class MasterSkillPriceServiceImpl implements AbstractRegisterService<MasterSkillPriceData, MasterSkillPriceData, MasterSkillKey> {

    @Autowired
    private MasterSkillPriceRepository masterSkillPriceRepository;
    @Autowired
    MasterSkillPriceConverterImpl masterSkillPriceConverter;

    @Override
    public MasterSkillPriceData create(MasterSkillPriceData masterSkillPriceData) {
        MasterSkillPrice masterSkillPrice = masterSkillPriceConverter.populateEntity(masterSkillPriceData);
        return masterSkillPriceConverter.populateData(masterSkillPriceRepository.save(masterSkillPrice));
    }

    @Override
    public List<MasterSkillPriceData> getAll() {
        List<MasterSkillPriceData> masterSkillPriceDataList = new ArrayList<>();
        List<MasterSkillPrice> masterSkillPriceList = masterSkillPriceRepository.findAll();
        masterSkillPriceList.forEach(masterSkillPrice -> {
            masterSkillPriceDataList.add(masterSkillPriceConverter.populateData(masterSkillPrice));
        });
        return masterSkillPriceDataList;
    }

    @Override
    public Optional<MasterSkillPriceData> getById(MasterSkillKey id) {
        Optional<MasterSkillPrice> masterSkillPrice = masterSkillPriceRepository.findById(id);
        if(masterSkillPrice.isEmpty()) {
            return null;
        }
        return Optional.of(masterSkillPriceConverter.populateData(masterSkillPrice.get()));
    }

    @Override
    public boolean update(MasterSkillPriceData masterSkillPriceData, MasterSkillKey id) {
        if (masterSkillPriceRepository.existsById(id)) {
            MasterSkillPrice masterSkillPrice = masterSkillPriceConverter.populateEntity(masterSkillPriceData);
            masterSkillPrice.setId(id);
            masterSkillPriceRepository.save(masterSkillPrice);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(MasterSkillKey id) {
        if (masterSkillPriceRepository.existsById(id)) {
            masterSkillPriceRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
