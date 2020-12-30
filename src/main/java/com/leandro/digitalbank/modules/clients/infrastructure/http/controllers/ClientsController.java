package com.leandro.digitalbank.modules.clients.infrastructure.http.controllers;

import java.util.List;

import javax.validation.Valid;

import com.leandro.digitalbank.modules.clients.infrastructure.persistance.entities.Client;
import com.leandro.digitalbank.modules.clients.usecases.CreateClient;
import com.leandro.digitalbank.modules.clients.usecases.DeleteClient;
import com.leandro.digitalbank.modules.clients.usecases.ListClients;
import com.leandro.digitalbank.modules.clients.usecases.ShowClient;
import com.leandro.digitalbank.modules.clients.usecases.UpdateClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
@Validated
public class ClientsController {
	
	@Autowired
	private ListClients list;

	@Autowired
	private CreateClient create;

	@Autowired
	private UpdateClient update;

	@Autowired
	private ShowClient show;

	@Autowired
	private DeleteClient delete;

	@GetMapping
	public List<Client> index() {
		return list.execute();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Client> show(@PathVariable Long id) {
		return show.execute(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client create(
	 @Valid	@RequestBody Client client
	) {
		return create.execute(client);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Client> update(
		@Valid @PathVariable Long id,
		@RequestBody Client client
	) {
		return update.execute(id, client);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		return delete.execute(id);
	}
}
