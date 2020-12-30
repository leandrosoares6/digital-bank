package com.leandro.digitalbank.modules.clients.repositories;

import java.util.List;
import java.util.Optional;

import com.leandro.digitalbank.modules.clients.dtos.ICreateClientDTO;
import com.leandro.digitalbank.modules.clients.infrastructure.persistance.entities.Client;

public interface IClientsRepository {
	List<Client> findAll();
	Optional<Client> findById(Long id);
	Optional<Client> findByEmail(String email);
	Client create(ICreateClientDTO cliDTO);
	Client save(Client client);
	void delete(Long id);
}
