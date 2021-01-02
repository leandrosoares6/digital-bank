package com.leandro.digitalbank.modules.clients.services;

import java.util.List;

import com.leandro.digitalbank.modules.clients.dtos.ClientDTO;
import com.leandro.digitalbank.modules.clients.infrastructure.persistance.entities.Client;

public interface IClientsService {
	Long createClient(ClientDTO client);
	List<Client> listClients();
	Client showClient(Long id);
	void updateClient(Long id, ClientDTO client);
	void deleteClient(Long id);
}
