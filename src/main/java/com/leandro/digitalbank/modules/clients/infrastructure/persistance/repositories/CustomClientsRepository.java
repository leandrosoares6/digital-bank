package com.leandro.digitalbank.modules.clients.infrastructure.persistance.repositories;

import java.util.List;

import com.leandro.digitalbank.modules.clients.dtos.ICreateClientDTO;
import com.leandro.digitalbank.modules.clients.infrastructure.persistance.entities.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomClientsRepository extends JpaRepository<Client, Long> {

	default Client create(ICreateClientDTO clientData) {
		Client client = new Client();
		client.setFirstName(clientData.getFirstName());
		client.setLastName(clientData.getLastName());
		client.setEmail(clientData.getEmail());
		client.setCpf(clientData.getCpf());
		client.setDateOfBirth(clientData.getDateOfBirth());
		
		return save(client);
	}
	
	List<Client> findByFirstName(String name);
	Client findByEmail(String email);
	
}
