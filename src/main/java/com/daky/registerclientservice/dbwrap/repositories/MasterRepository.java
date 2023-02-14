package com.daky.registerclientservice.dbwrap.repositories;

import com.daky.registerclientservice.dbwrap.entries.Master;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterRepository extends BaseRepository<Master, Long> {
}