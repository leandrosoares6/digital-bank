package com.leandro.digitalbank.modules.clients.infrastructure.configuration;

import com.leandro.digitalbank.DigitalBankApplication;
import com.leandro.digitalbank.modules.clients.domain.repositories.IClientsRepository;
import com.leandro.digitalbank.modules.clients.domain.services.ClientsServiceImpl;
import com.leandro.digitalbank.modules.clients.domain.services.IClientsService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = DigitalBankApplication.class)
public class BeanConfiguration {
  
  @Bean
  IClientsService clientsService(final IClientsRepository clientsRepository) {
    return new ClientsServiceImpl(clientsRepository);
  }
}
