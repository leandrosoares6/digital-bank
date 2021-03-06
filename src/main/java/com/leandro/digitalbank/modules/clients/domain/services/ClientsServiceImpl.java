package com.leandro.digitalbank.modules.clients.domain.services;

import java.util.List;
import java.util.UUID;

import com.leandro.digitalbank.modules.clients.domain.dtos.IClientDTO;
import com.leandro.digitalbank.modules.clients.domain.entities.Client;
import com.leandro.digitalbank.modules.clients.domain.repositories.IClientsRepository;
import com.leandro.digitalbank.shared.exceptions.AppError;

public class ClientsServiceImpl implements IClientsService {
  private final IClientsRepository clientsRepository;

  public ClientsServiceImpl(IClientsRepository clientsRepository) {
    this.clientsRepository = clientsRepository;
  }

  @Override
  public String createClient(IClientDTO clientDTO) {
    var existsByEmail = clientsRepository.existsByEmail(clientDTO.getEmail());

    if (existsByEmail) {
      throw new AppError("Email already in use.");
    }

    var existsByCpf = clientsRepository.existsByCpf(clientDTO.getCpf());

    if (existsByCpf) {
      throw new AppError("Client with specified CPF already in use.");
    }

    final Client client = new Client();
    client.setId(UUID.randomUUID().toString());
    client.setFirstName(clientDTO.getFirstName());
    client.setLastName(clientDTO.getLastName());
    client.setEmail(clientDTO.getEmail());
    client.setDateOfBirth(clientDTO.getDateOfBirth());
    client.setCpf(clientDTO.getCpf());

    clientsRepository.save(client);
    return client.getId();
  }

  public List<Client> listClients() {
    return clientsRepository.findAllClients();
  }

  @Override
  public Client showClient(String id) {
    return clientsRepository
    .findById(id)
    .orElseThrow(() -> new AppError("Client not found"));
  }
  @Override
  public void updateClient(String id, IClientDTO clientDTO) {
    Client client = clientsRepository
      .findById(id)
      .orElseThrow(() -> new AppError("Client not found"));

    client.setFirstName(clientDTO.getFirstName());
    client.setLastName(clientDTO.getLastName());
    client.setEmail(clientDTO.getEmail());
    client.setDateOfBirth(clientDTO.getDateOfBirth());
    client.setCpf(clientDTO.getCpf());

    clientsRepository.save(client);
  }

  @Override
  public void deleteClient(String id) {
    Client client = clientsRepository
      .findById(id)
      .orElseThrow(() -> new AppError("Client not found"));

    clientsRepository.delete(client);
  }
}
