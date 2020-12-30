package com.leandro.digitalbank.modules.clients.usecases;

import com.leandro.digitalbank.modules.clients.infrastructure.persistance.entities.Client;
import com.leandro.digitalbank.modules.clients.infrastructure.persistance.repositories.CustomClientsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateClient {
	@Autowired
	CustomClientsRepository clientsRepository;
	
	public ResponseEntity<Client> execute(Long id, Client client) {
		if (!clientsRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		client.setId(id);
		clientsRepository.save(client);

		return ResponseEntity.ok(client);
	}
}
