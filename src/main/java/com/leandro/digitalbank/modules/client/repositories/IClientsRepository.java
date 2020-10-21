package com.leandro.digitalbank.modules.client.repositories;

import java.util.List;
import java.util.Optional;

import com.leandro.digitalbank.modules.client.dtos.CreateClientDTO;
import com.leandro.digitalbank.modules.client.infrastructure.persistance.entities.Client;

public interface IClientsRepository {
	List<Client> findAllClients();
	Optional<Client> findClientById(Long id);
	Optional<Client> findClientByEmail(String email);
	Client createClient(CreateClientDTO cliDTO);
	Client saveClient(Client client);
	void deleteClient(Long id);
}
