package fr.afpa.orm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "advisor")
public class BankAdvisor extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(name = "hiringDate")
	private LocalDate hiringDate;

	//Specialty : Assurance Placement Prêt immobilier Crédit consommation
	public enum Specialty {
		Assurance, Placement_Prêt, immobilier, Crédit_consommation
	}

	@Column(name = "specialty")
	private Specialty specialty;

	/**
	 * Association de type "OneToMany" : un conseiller peut suivre plusieurs clients
	 */
	@JsonIgnore
	@OneToMany(targetEntity = Client.class, mappedBy = "owner")
	private List<Client> clients;


	public BankAdvisor() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public LocalDate getHiringDate() {
		return hiringDate;
	}

	public void setHiringDate(LocalDate hiringDate) {
		this.hiringDate = hiringDate;
	}

	public Specialty getSpecialty() {
		return specialty;
	}

	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}
}
