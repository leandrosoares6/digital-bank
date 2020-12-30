package com.leandro.digitalbank.modules.clients.usecases;

import com.leandro.digitalbank.modules.clients.infrastructure.persistance.entities.Client;
import com.leandro.digitalbank.modules.clients.infrastructure.persistance.repositories.CustomClientsRepository;
import com.leandro.digitalbank.shared.exceptions.AppError;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateClient {
	@Autowired
	private CustomClientsRepository clientsRepository;
	
	public Client execute(Client client) {
		var email = client.getEmail();
		Client clientFounded = clientsRepository.findByEmail(email);

		if (clientFounded != null && !clientFounded.equals(client)) {
			throw new AppError("Email address already used.");
		}
		return clientsRepository.save(client);
	}
}
