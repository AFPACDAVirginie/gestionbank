package fr.afpa.orm.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@MappedSuperclass
public class Person {

	/**
	 * Prénom du propriétaire
	 */
	@Column(name = "first_name")
	private String firstName;
	/**
	 * Nom du propriétaire
	 */
	@Column(name = "last_name")
	private String lastName;
	/**
	 * Adresse email (unique) du propriétaire
	 */
	@Column(name = "email")
	private String email;
	/**
	 * Date d'anniversaire du prop
	 */
	@Column(name = "birthdate")
	private LocalDate birthdate;


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthDate() {
		return birthdate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthdate = birthDate;
	}
}
