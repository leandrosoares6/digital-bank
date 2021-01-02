package com.leandro.digitalbank.modules.clients.infrastructure.configuration;

import com.leandro.digitalbank.modules.clients.infrastructure.repositories.mysql.SpringDataMysqlClientsRepository;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackageClasses = SpringDataMysqlClientsRepository.class)
public class MySqlDbConfiguration {
}
