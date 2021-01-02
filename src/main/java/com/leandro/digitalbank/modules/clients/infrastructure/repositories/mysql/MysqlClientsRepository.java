package com.leandro.digitalbank.modules.clients.infrastructure.repositories.mysql;

import java.util.List;
import java.util.Optional;

import com.leandro.digitalbank.modules.clients.domain.entities.Client;
import com.leandro.digitalbank.modules.clients.domain.repositories.IClientsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MysqlClientsRepository implements IClientsRepository {
  private final SpringDataMysqlClientsRepository clientsRepository;

  @Autowired
  public MysqlClientsRepository(final SpringDataMysqlClientsRepository clientsRepository) {
    this.clientsRepository = clientsRepository;
  }

  @Override
  public Optional<Client> findById(final Long id) {
    return clientsRepository.findById(id);
  }

  @Override
  public void save(final Client client) {
    clientsRepository.save(client);
  }

  @Override
  public List<Client> findAllClients() {
    return clientsRepository.findAll();
  }

  @Override
  public void delete(Long id) {
    clientsRepository.deleteById(id);
  }

  /**
   * Example of use Exists with Example<T>
   */
  @Override
  public boolean existsByEmail(String email) {
    Client client = new Client();
    client.setEmail(email);

    Example<Client> clientExample = Example.of(client);

    return clientsRepository.exists(clientExample);
  }

  /**
   * Example of use Exists with JPQL
   */
  @Override
  public boolean existsByCpf(String cpf) {
    return clientsRepository.existsByCpf(cpf);
  }
}
