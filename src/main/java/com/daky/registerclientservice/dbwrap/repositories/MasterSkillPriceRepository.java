package com.daky.registerclientservice.dbwrap.repositories;

import com.daky.registerclientservice.dbwrap.entries.MasterSkillPrice;
import com.daky.registerclientservice.dbwrap.entries.compositekeys.MasterSkillKey;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterSkillPriceRepository extends BaseRepository<MasterSkillPrice, MasterSkillKey> {
}
