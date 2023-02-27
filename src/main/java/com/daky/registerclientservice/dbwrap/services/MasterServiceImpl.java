package com.daky.registerclientservice.dbwrap.services;

import com.daky.registerclientservice.dbwrap.entries.Master;
import com.daky.registerclientservice.dbwrap.dto.MasterData;
import com.daky.registerclientservice.dbwrap.repositories.MasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("masterService")
public class MasterServiceImpl implements RegisterService<MasterData, MasterData, Long> {

    @Autowired
    private MasterRepository masterRepository;


    @Override
    public MasterData create(MasterData masterData) {
        Master master = populateMasterEntity(masterData);
        return populateMasterData(masterRepository.save(master));
    }

    @Override
    public List<MasterData> getAll() {
        List<MasterData> masters = new ArrayList<>();
        List<Master> masterList = masterRepository.findAll();
        masterList.forEach(master -> {
            masters.add(populateMasterData(master));
        });
        return masters;
    }

    @Override
    public Optional<MasterData> getById(Long masterId) {
        Optional<Master> master = masterRepository.findById(masterId);
        if(master.isEmpty()) {
            return null;
        }
        return Optional.of(populateMasterData(master.get()));
    }

    @Override
    public boolean update(MasterData masterData, Long masterId) {
        if (masterRepository.existsById(masterId)) {
            Master master = populateMasterEntity(masterData);
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

    /**
     * Internal method to convert Customer JPA entity to the DTO object
     * for frontend data
     * @param master
     * @return masterData
     */
    private MasterData populateMasterData(final Master master) {
        MasterData masterData = new MasterData();
        masterData.setId(master.getId());
        masterData.setName(master.getName());
        masterData.setSurname(master.getSurname());
        masterData.setEmail(master.getEmail());
        masterData.setPhone(master.getPhone());
        masterData.setNickName(master.getNickName());
        return masterData;
    }

    /**
     * Method to map the front end customer object to the JPA customer entity.
     * @param masterData
     * @return master
     */
    private Master populateMasterEntity(MasterData masterData) {
        Master master = new Master();
        master.setName(masterData.getName());
        master.setSurname(masterData.getSurname());
        master.setEmail(masterData.getEmail());
        master.setPhone(masterData.getPhone());
        master.setNickName(masterData.getNickName());
        return master;
    }
}
