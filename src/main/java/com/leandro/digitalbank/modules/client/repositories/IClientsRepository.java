package com.leandro.digitalbank.modules.client.repositories;

import java.util.List;

import com.leandro.digitalbank.modules.client.dtos.CreateClientDTO;
import com.leandro.digitalbank.modules.client.infrastructure.persistance.entities.Client;

public interface IClientsRepository {
	List<Client> findAllClients();
	Client findById(Long id);
	Client findByEmail(String email);
	Client create(CreateClientDTO cliDTO);
	Client save(Client client);
	Void delete(Long id);
}
