package com.daky.registerclientservice.dbwrap.services;

import com.daky.registerclientservice.dbwrap.converters.MasterConverterImpl;
import com.daky.registerclientservice.dbwrap.entries.Master;
import com.daky.registerclientservice.dbwrap.dto.MasterData;
import com.daky.registerclientservice.dbwrap.repositories.MasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("masterService")
public class MasterServiceImpl implements AbstractRegisterService<MasterData, MasterData, Long> {

    @Autowired
    private MasterRepository masterRepository;
    @Autowired
    private MasterConverterImpl masterConverter;


    @Override
    public MasterData create(MasterData masterData) {
        Master master = masterConverter.populateEntity(masterData);
        return masterConverter.populateData(masterRepository.save(master));
    }

    @Override
    public List<MasterData> getAll() {
        List<MasterData> masters = new ArrayList<>();
        List<Master> masterList = masterRepository.findAll();
        masterList.forEach(master -> {
            masters.add(masterConverter.populateData(master));
        });
        return masters;
    }

    @Override
    public Optional<MasterData> getById(Long masterId) {
        Optional<Master> master = masterRepository.findById(masterId);
        if(master.isEmpty()) {
            return null;
        }
        return Optional.of(masterConverter.populateData(master.get()));
    }

    @Override
    public boolean update(MasterData masterData, Long masterId) {
        if (masterRepository.existsById(masterId)) {
            Master master = masterConverter.populateEntity(masterData);
            master.setId(masterId);
            masterRepository.save(master);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long masterId) {
        if (masterRepository.existsById(masterId)) {
            masterRepository.deleteById(masterId);
            return true;
        }
        return false;
    }
}
