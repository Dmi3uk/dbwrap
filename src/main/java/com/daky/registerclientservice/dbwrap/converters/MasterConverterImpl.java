package com.daky.registerclientservice.dbwrap.converters;

import com.daky.registerclientservice.dbwrap.dto.MasterData;
import com.daky.registerclientservice.dbwrap.dto.MasterSkillPriceData;
import com.daky.registerclientservice.dbwrap.dto.MasterTimetableRuleData;
import com.daky.registerclientservice.dbwrap.dto.OrderData;
import com.daky.registerclientservice.dbwrap.entries.Master;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MasterConverterImpl implements AbstractConverter<MasterData, Master> {

    @Autowired
    MasterSkillPriceConverterImpl masterSkillPriceConverter;
    @Autowired
    MasterTimetableRuleConverterImpl masterTimetableRuleConverter;
    @Autowired
    OrderConverterImpl orderConverter;

    @Override
    public MasterData populateData(final Master master) {
        MasterData masterData = new MasterData();
        masterData.setId(master.getId());
        masterData.setName(master.getName());
        masterData.setSurname(master.getSurname());
        masterData.setEmail(master.getEmail());
        masterData.setPhone(master.getPhone());
        masterData.setNickName(master.getNickName());
        masterData.setMasterSkillPriceDataSet(masterSkillPriceDataSetConverter(master));
        masterData.setMasterTimetableRuleDataSet(masterTimetableRuleDataSetConverter(master));
        masterData.setOrderDataSet(orderConverters(master));
        return masterData;
    }

    @Override
    public Master populateEntity(MasterData masterData) {
        Master master = new Master();
        master.setName(masterData.getName());
        master.setSurname(masterData.getSurname());
        master.setEmail(masterData.getEmail());
        master.setPhone(masterData.getPhone());
        master.setNickName(masterData.getNickName());
        return master;
    }

    public Set<MasterSkillPriceData> masterSkillPriceDataSetConverter(Master master) {

        return master.getMasterSkillPriceSet().stream().
                map(item -> masterSkillPriceConverter.populateData(item)).collect(Collectors.toSet());

    }

    public Set<MasterTimetableRuleData> masterTimetableRuleDataSetConverter(Master master) {

        return master.getMasterTimetableRuleSet().stream().
                map(item -> masterTimetableRuleConverter.populateData(item)).collect(Collectors.toSet());

    }

    public Set<OrderData> orderConverters(Master master) {

       return master.getOrderSet().stream().map(item -> orderConverter.populateData(item)).collect(Collectors.toSet());

    }


}
