package com.leandro.digitalbank.modules.clients.domain.services;

import java.util.List;

import com.leandro.digitalbank.modules.clients.domain.dtos.IClientDTO;
import com.leandro.digitalbank.modules.clients.domain.entities.Client;

public interface IClientsService {
	Long createClient(IClientDTO client);
	List<Client> listClients();
	Client showClient(Long id);
	void updateClient(Long id, IClientDTO client);
	void deleteClient(Long id);
}
