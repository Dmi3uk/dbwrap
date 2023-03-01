package com.daky.registerclientservice.dbwrap.converters;

import com.daky.registerclientservice.dbwrap.dto.MasterSkillPriceData;
import com.daky.registerclientservice.dbwrap.entries.MasterSkillPrice;
import org.springframework.stereotype.Component;

@Component
public class MasterSkillPriceConverterImpl implements AbstractConverter<MasterSkillPriceData, MasterSkillPrice> {

    @Override
    public MasterSkillPriceData populateData(final MasterSkillPrice masterSkillPrice) {
        MasterSkillPriceData masterSkillPriceData = new MasterSkillPriceData();
        masterSkillPriceData.setId(masterSkillPrice.getId());
        masterSkillPriceData.setMaster(masterSkillPrice.getMaster());
        masterSkillPriceData.setSkill(masterSkillPrice.getSkill());
        masterSkillPriceData.setPrice(masterSkillPrice.getPrice());
        return masterSkillPriceData;
    }

    @Override
    public MasterSkillPrice populateEntity(MasterSkillPriceData masterSkillPriceData) {
        MasterSkillPrice masterSkillPrice = new MasterSkillPrice();
        masterSkillPrice.setId(masterSkillPriceData.getId());
        masterSkillPrice.setMaster(masterSkillPriceData.getMaster());
        masterSkillPrice.setSkill(masterSkillPriceData.getSkill());
        masterSkillPrice.setPrice(masterSkillPriceData.getPrice());
        return masterSkillPrice;
    }
}
