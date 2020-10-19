package com.leandro.digitalbank.modules.client.infrastructure.http.controllers;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.leandro.digitalbank.modules.client.dtos.CreateClientDTO;
import com.leandro.digitalbank.modules.client.infrastructure.persistance.entities.Client;
import com.leandro.digitalbank.modules.client.services.CreateClientService;

@RestController
public class ClientsController {

	@GetMapping("/clients")
	public List<Client> list() {
		var client1 = new Client();
		client1.setId(1L);
		client1.setFisrtName("Leandro");
		client1.setLastName("Neves");
		client1.setEmail("leandro@mail.com");
		client1.setCpf("04694757300");
		client1.setDateOfBirth("16/11/1993");
		
		var client2 = new Client();
		client2.setId(2L);
		client2.setFisrtName("Andressa");
		client2.setLastName("Rafaella");
		client2.setEmail("andressa@mail.com");
		client2.setCpf("04443816339");
		client2.setDateOfBirth("22/05/1993");
		
		return Arrays.asList(client1, client2);
	}
	
	@PostMapping("/clients")
	public ResponseEntity<Void> create(@RequestBody CreateClientDTO cliDTO) {
		var createClient = new CreateClientService();
		var cli = createClient.execute(cliDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(cli.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
