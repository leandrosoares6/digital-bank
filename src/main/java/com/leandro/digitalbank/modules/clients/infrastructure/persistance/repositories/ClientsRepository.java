package com.leandro.digitalbank.modules.clients.infrastructure.persistance.repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.leandro.digitalbank.modules.clients.dtos.ICreateClientDTO;
import com.leandro.digitalbank.modules.clients.infrastructure.persistance.entities.Client;
import com.leandro.digitalbank.modules.clients.repositories.IClientsRepository;

import org.springframework.stereotype.Repository;

@Repository
public class ClientsRepository implements IClientsRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Client> findAll() {
		return em
				.createQuery("from Client", Client.class)
				.getResultList();
	}

	@Override
	public Optional<Client> findById(Long id) {
		var result = em
				.createQuery("from Client where id=1", Client.class)
				.setParameter(1, id)
				.getResultList();
		
		return Optional.of(result.get(0));
	}

	@Override
	public Optional<Client> findByEmail(String email) {
		var jpql = new StringBuilder();
		jpql.append("from Client where email=1");
		TypedQuery<Client> query = em
				.createQuery(jpql.toString(), Client.class);
		query.setParameter(1, email);
		
		var result = query.getResultList();
		
		return Optional.of(result.get(0));
	}

	@Override
	public Client create(ICreateClientDTO cliDTO) {
		Client client = new Client();
		client.setFirstName(cliDTO.getFirstName());
		client.setLastName(cliDTO.getLastName());
		client.setEmail(cliDTO.getEmail());
		client.setCpf(cliDTO.getCpf());
		client.setDateOfBirth(cliDTO.getDateOfBirth());
		
		em.clear();
		em.persist(client);
		em.flush();
		em.refresh(client);
		
		return client;
	}

	@Override
	public Client save(Client client) {
		em.clear();
		em.persist(client);
		em.flush();
		em.refresh(client);
		
		return client;
	}

	@Override
	public void delete(Long id) {
		em.clear();
		Client client = em.find(Client.class, id);
		em.remove(client);
		em.flush();
	}

}
