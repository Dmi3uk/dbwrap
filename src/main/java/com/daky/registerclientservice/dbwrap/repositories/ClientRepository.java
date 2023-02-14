package com.daky.registerclientservice.dbwrap.repositories;

import com.daky.registerclientservice.dbwrap.entries.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends BaseRepository<Client, Long> {
}