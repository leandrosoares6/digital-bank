package com.leandro.digitalbank.modules.clients.usecases;

import com.leandro.digitalbank.modules.clients.infrastructure.persistance.repositories.CustomClientsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteClient {
	@Autowired
	CustomClientsRepository clientsRepository;
	
	public ResponseEntity<Void> execute(Long id) {
		if (!clientsRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		clientsRepository.deleteById(id);

		return ResponseEntity.noContent().build();
	}
}
