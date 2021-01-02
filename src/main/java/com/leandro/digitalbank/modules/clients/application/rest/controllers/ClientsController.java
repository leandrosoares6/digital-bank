package com.leandro.digitalbank.modules.clients.application.rest.controllers;

import java.util.List;

import javax.validation.Valid;

import com.leandro.digitalbank.modules.clients.domain.dtos.IClientDTO;
import com.leandro.digitalbank.modules.clients.domain.entities.Client;
import com.leandro.digitalbank.modules.clients.domain.services.IClientsService;
import com.leandro.digitalbank.shared.exceptions.AppError;

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

	private final IClientsService clientsService;

	public ClientsController(IClientsService clientsService) {
		this.clientsService = clientsService;
	}

	@GetMapping
	public List<Client> index() {
		return clientsService.listClients();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Client> show(@PathVariable Long id) {
		try {
			Client client = clientsService.showClient(id);
			return ResponseEntity.ok(client);
		} catch (AppError e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Long create(@Valid @RequestBody IClientDTO clientDTO) {
		return clientsService.createClient(clientDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Client> update(@Valid @PathVariable Long id, @RequestBody IClientDTO client) {
		try {
			clientsService.updateClient(id, client);
			return ResponseEntity.noContent().build();
		} catch (AppError e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		try {
			clientsService.deleteClient(id);
			return ResponseEntity.noContent().build();
		} catch (AppError e) {
			return ResponseEntity.notFound().build();
		}
	}
}
