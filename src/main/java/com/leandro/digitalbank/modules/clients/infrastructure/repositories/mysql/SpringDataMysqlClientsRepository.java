package com.leandro.digitalbank.modules.clients.infrastructure.repositories.mysql;

import java.util.Optional;

import com.leandro.digitalbank.modules.clients.domain.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataMysqlClientsRepository extends JpaRepository<Client, String> {
  @Query("select case when count(c)> 0 then true else false end from Client c where c.cpf = :cpf")
  boolean existsByCpf(@Param("cpf") String cpf);

  @Query("select c from Client c where c.id = :id")
  Optional<Client> findById(@Param("id") String id);
}