package com.leandro.digitalbank.modules.client.infrastructure.persistance.repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import com.leandro.digitalbank.modules.client.dtos.CreateClientDTO;
import com.leandro.digitalbank.modules.client.infrastructure.persistance.entities.Client;
import com.leandro.digitalbank.modules.client.repositories.IClientsRepository;

@Repository
public class ClientsRepository extends SimpleJpaRepository<Client, Long> implements IClientsRepository {
	

	

	
	
	@Override
	public List<Client> findAllClients() {
		return this.findAll();
	}

	@Override
	public Optional<Client> findClientById(Long id) {
		return findById(id);
	}

	@Override
	public Optional<Client> findClientByEmail(String email) {
		var jpql = new StringBuilder();
		jpql.append("from Client where email=1");
		TypedQuery<Client> query = this
				.entityManager
				.createQuery(jpql.toString(), Client.class);
		query.setParameter(1, email);
		
		var result = query.getResultList();
		
		return Optional.of(result.get(0));
	}

	@Override
	public Client createClient(CreateClientDTO cliDTO) {
		Client client = new Client();
		client.setFisrtName(cliDTO.getFirstName());
		client.setLastName(cliDTO.getLastName());
		client.setEmail(cliDTO.getEmail());
		client.setCpf(cliDTO.getCpf());
		client.setDateOfBirth(cliDTO.getDateOfBirth());
		return save(client);
	}

	@Override
	public Client saveClient(Client client) {
		return save(client);
	}

	@Override
	public void deleteClient(Long id) {
		deleteById(id);
	}

}
