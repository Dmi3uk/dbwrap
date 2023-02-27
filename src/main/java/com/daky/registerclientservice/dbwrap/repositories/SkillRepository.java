package com.daky.registerclientservice.dbwrap.repositories;

import com.daky.registerclientservice.dbwrap.entries.Skill;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends BaseRepository<Skill, Long> {
}
