package com.leandro.digitalbank.modules.clients.usecases;

import java.util.List;

import com.leandro.digitalbank.modules.clients.infrastructure.persistance.entities.Client;
import com.leandro.digitalbank.modules.clients.infrastructure.persistance.repositories.CustomClientsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListClients {
	@Autowired
	CustomClientsRepository clientsRepository;
	
	public List<Client> execute() {
		return clientsRepository.findAll();
	}
}
