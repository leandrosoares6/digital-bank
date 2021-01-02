package com.leandro.digitalbank.modules.clients.repositories;
import java.util.List;
import java.util.Optional;

import com.leandro.digitalbank.modules.clients.infrastructure.persistance.entities.Client;

public interface IClientsRepository {
	Optional<Client> findById(Long id);
	List<Client> findAllClients();
	void save(Client client);
	void delete(Long id);
	boolean existsByEmail(String email);
	boolean existsByCpf(String cpf);
}
