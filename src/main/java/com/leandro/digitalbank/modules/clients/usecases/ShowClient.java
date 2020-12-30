package com.leandro.digitalbank.modules.clients.usecases;

import java.util.Optional;

import com.leandro.digitalbank.modules.clients.infrastructure.persistance.entities.Client;
import com.leandro.digitalbank.modules.clients.infrastructure.persistance.repositories.CustomClientsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ShowClient {
	@Autowired
	CustomClientsRepository clientsRepository;
	
	public ResponseEntity<Client> execute(Long id) {
		Optional<Client> client = clientsRepository.findById(id);
		
		if (client.isPresent()) {
			return ResponseEntity.ok(client.get());
		}
		
		return ResponseEntity.notFound().build();
	}
}
