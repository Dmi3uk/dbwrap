package com.daky.registerclientservice.dbwrap.repository;

import com.daky.registerclientservice.dbwrap.data.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}