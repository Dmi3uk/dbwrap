package com.daky.registerclientservice.dbwrap.converters;

import com.daky.registerclientservice.dbwrap.dto.MasterSkillPriceData;
import com.daky.registerclientservice.dbwrap.dto.compositedata.MasterSkillKeyData;
import com.daky.registerclientservice.dbwrap.entries.MasterSkillPrice;
import com.daky.registerclientservice.dbwrap.entries.compositekeys.MasterSkillKey;
import org.springframework.stereotype.Component;

@Component
public class MasterSkillPriceConverterImpl implements AbstractConverter<MasterSkillPriceData, MasterSkillPrice> {

    @Override
    public MasterSkillPriceData populateData(final MasterSkillPrice masterSkillPrice) {
        MasterSkillPriceData masterSkillPriceData = new MasterSkillPriceData();
        masterSkillPriceData.setId(populateKeyData(masterSkillPrice.getId()));
        masterSkillPriceData.setMaster(masterSkillPrice.getMaster());
        masterSkillPriceData.setSkill(masterSkillPrice.getSkill());
        masterSkillPriceData.setPrice(masterSkillPrice.getPrice());
        return masterSkillPriceData;
    }

    @Override
    public MasterSkillPrice populateEntity(MasterSkillPriceData masterSkillPriceData) {
        MasterSkillPrice masterSkillPrice = new MasterSkillPrice();
        masterSkillPrice.setId(populateKeyEntity(masterSkillPriceData.getId()));
        masterSkillPrice.setMaster(masterSkillPriceData.getMaster());
        masterSkillPrice.setSkill(masterSkillPriceData.getSkill());
        masterSkillPrice.setPrice(masterSkillPriceData.getPrice());
        return masterSkillPrice;
    }

    public MasterSkillKeyData populateKeyData(final MasterSkillKey masterSkillKey) {
        MasterSkillKeyData masterSkillKeyData = new MasterSkillKeyData();
        masterSkillKeyData.setMasterID(masterSkillKey.getMasterID());
        masterSkillKeyData.setSkillID(masterSkillKey.getSkillID());
        return masterSkillKeyData;
    }

    public MasterSkillKey populateKeyEntity(MasterSkillKeyData masterSkillKeyData) {
        MasterSkillKey masterSkillKey = new MasterSkillKey();
        masterSkillKey.setMasterID(masterSkillKeyData.getMasterID());
        masterSkillKey.setSkillID(masterSkillKeyData.getSkillID());
        return masterSkillKey;
    }


}
