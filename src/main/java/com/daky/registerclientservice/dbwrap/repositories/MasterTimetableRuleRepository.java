package com.daky.registerclientservice.dbwrap.repositories;

import com.daky.registerclientservice.dbwrap.entries.MasterTimetableRule;
import com.daky.registerclientservice.dbwrap.entries.compositekeys.MasterTimetableRuleKey;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterTimetableRuleRepository extends BaseRepository<MasterTimetableRule, MasterTimetableRuleKey> {
}
