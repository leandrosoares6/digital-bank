package com.leandro.digitalbank.modules.clients.infrastructure.repositories.mysql;

import com.leandro.digitalbank.modules.clients.infrastructure.persistance.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataMysqlClientsRepository extends JpaRepository<Client, Long>{
}