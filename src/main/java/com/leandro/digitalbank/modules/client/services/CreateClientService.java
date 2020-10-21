package com.leandro.digitalbank.modules.client.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.leandro.digitalbank.modules.client.dtos.CreateClientDTO;
import com.leandro.digitalbank.modules.client.infrastructure.persistance.entities.Client;
import com.leandro.digitalbank.modules.client.repositories.IClientsRepository;

public class CreateClientService {
	
	@Autowired
	private IClientsRepository clientsRepository;
	
	public Client execute(CreateClientDTO clientData) {
		return clientsRepository.createClient(clientData);
	}
}
