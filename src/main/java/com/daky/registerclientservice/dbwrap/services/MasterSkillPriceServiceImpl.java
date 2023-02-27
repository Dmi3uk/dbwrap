package com.daky.registerclientservice.dbwrap.services;

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
public class MasterSkillPriceServiceImpl implements RegisterService<MasterSkillPriceData, MasterSkillPriceData, MasterSkillKey> {

    @Autowired
    private MasterSkillPriceRepository masterSkillPriceRepository;

    @Override
    public MasterSkillPriceData create(MasterSkillPriceData masterSkillPriceData) {
        MasterSkillPrice masterSkillPrice = populateMasterSkillPriceEntity(masterSkillPriceData);
        return populateMasterSkillPriceData(masterSkillPriceRepository.save(masterSkillPrice));
    }

    @Override
    public List<MasterSkillPriceData> getAll() {
        List<MasterSkillPriceData> masterSkillPriceDataList = new ArrayList<>();
        List<MasterSkillPrice> masterSkillPriceList = masterSkillPriceRepository.findAll();
        masterSkillPriceList.forEach(masterSkillPrice -> {
            masterSkillPriceDataList.add(populateMasterSkillPriceData(masterSkillPrice));
        });
        return masterSkillPriceDataList;
    }

    @Override
    public Optional<MasterSkillPriceData> getById(MasterSkillKey id) {
        Optional<MasterSkillPrice> masterSkillPrice = masterSkillPriceRepository.findById(id);
        if(masterSkillPrice.isEmpty()) {
            return null;
        }
        return Optional.of(populateMasterSkillPriceData(masterSkillPrice.get()));
    }

    @Override
    public boolean update(MasterSkillPriceData masterSkillPriceData, MasterSkillKey masterSkillKey) {
        if (masterSkillPriceRepository.existsById(masterSkillKey)) {
            MasterSkillPrice masterSkillPrice = populateMasterSkillPriceEntity(masterSkillPriceData);
            masterSkillPrice.setId(masterSkillKey);
            masterSkillPriceRepository.save(masterSkillPrice);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(MasterSkillKey masterSkillKey) {
        if (masterSkillPriceRepository.existsById(masterSkillKey)) {
            masterSkillPriceRepository.deleteById(masterSkillKey);
            return true;
        }
        return false;
    }

    /**
     * Internal method to convert Customer JPA entity to the DTO object
     * for frontend data
     * @param masterSkillPrice
     * @return masterSkillPriceData
     */
    private MasterSkillPriceData populateMasterSkillPriceData(final MasterSkillPrice masterSkillPrice) {
        MasterSkillPriceData masterSkillPriceData = new MasterSkillPriceData();
        masterSkillPriceData.setId(masterSkillPrice.getId());
        masterSkillPriceData.setMaster(masterSkillPrice.getMaster());
        masterSkillPriceData.setSkill(masterSkillPrice.getSkill());
        masterSkillPriceData.setPrice(masterSkillPrice.getPrice());
        return masterSkillPriceData;
    }

    /**
     * Method to map the front end customer object to the JPA customer entity.
     * @param masterSkillPriceData
     * @return masterSkillPrice
     */
    private MasterSkillPrice populateMasterSkillPriceEntity(MasterSkillPriceData masterSkillPriceData) {
        MasterSkillPrice masterSkillPrice = new MasterSkillPrice();
        masterSkillPrice.setId(masterSkillPriceData.getId());
        masterSkillPrice.setMaster(masterSkillPriceData.getMaster());
        masterSkillPrice.setSkill(masterSkillPriceData.getSkill());
        masterSkillPrice.setPrice(masterSkillPriceData.getPrice());
        return masterSkillPrice;
    }
}
