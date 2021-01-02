package com.leandro.digitalbank.modules.clients.domain.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;

	private String firstName;
	private String lastName;
	private String email;
	private String dateOfBirth;
	private String cpf;
}
