package com.leandro.digitalbank.modules.clients.domain.services;

import java.util.List;

import com.leandro.digitalbank.modules.clients.domain.dtos.IClientDTO;
import com.leandro.digitalbank.modules.clients.domain.entities.Client;

public interface IClientsService {
	String createClient(IClientDTO client);
	List<Client> listClients();
	Client showClient(String id);
	void updateClient(String id, IClientDTO client);
	void deleteClient(String id);
}
