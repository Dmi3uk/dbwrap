package com.daky.registerclientservice.dbwrap.repositories;

import com.daky.registerclientservice.dbwrap.entries.MasterTimetableRules;
import com.daky.registerclientservice.dbwrap.entries.compositekeys.MasterTimetableRulesKey;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterTimetableRulesRepository extends BaseRepository<MasterTimetableRules, MasterTimetableRulesKey> {
}
