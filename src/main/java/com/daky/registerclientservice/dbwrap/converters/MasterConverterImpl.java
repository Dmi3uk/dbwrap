package com.daky.registerclientservice.dbwrap.converters;

import com.daky.registerclientservice.dbwrap.dto.MasterData;
import com.daky.registerclientservice.dbwrap.dto.SkillsPrices;
import com.daky.registerclientservice.dbwrap.entries.Master;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MasterConverterImpl implements AbstractConverter<MasterData, Master> {

    @Override
    public MasterData populateData(final Master master) {
        MasterData masterData = new MasterData();
        masterData.setId(master.getId());
        masterData.setName(master.getName());
        masterData.setSurname(master.getSurname());
        masterData.setEmail(master.getEmail());
        masterData.setPhone(master.getPhone());
        masterData.setNickName(master.getNickName());
        masterData.setSkillsPricesSet(skillsPricesConverter(master));
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

    public Set<SkillsPrices> skillsPricesConverter(Master master) {

        return master.getMasterSkillPriceSet().stream().
                map(item -> {
                    SkillsPrices skillsPrices = new SkillsPrices(item.getSkill().getTitle(), item.getPrice());
                    return skillsPrices;
                }).collect(Collectors.toSet());

    }
}
