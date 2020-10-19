package com.leandro.digitalbank.modules.client.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leandro.digitalbank.modules.client.dtos.CreateClientDTO;
import com.leandro.digitalbank.modules.client.infrastructure.persistance.entities.Client;

public class CreateClientService {
	public Client execute(CreateClientDTO clientData) {
		var client = new Client();
		client.setId(1L);
		client.setFisrtName(clientData.getFirstName());
		client.setLastName(clientData.getLastName());
		client.setEmail(clientData.getEmail());
		client.setCpf(clientData.getCpf());
		client.setDateOfBirth(clientData.getDateOfBirth());
		
		// Print client in console
		ObjectMapper mapper = new ObjectMapper();
		String jsonString;
		try {
			jsonString = mapper.writeValueAsString(client);
			System.out.println(jsonString);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return client;
	}
}
