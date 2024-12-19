package fr.afpa.orm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "bankadvisor")
public class BankAdvisor extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(name = "hiring_date")
	private LocalDate hiringDate;

	//Specialty : Assurance Placement Prêt immobilier Crédit consommation
	// Relation OneToMany : un bankadvisor peut avoir plusieurs specialties
	@OneToMany(mappedBy = "bankAdvisor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<Specialty> specialties = new ArrayList<>();


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

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<Specialty> getSpecialties() {
		return specialties;
	}

	public void setSpecialties(List<Specialty> specialties) {
		this.specialties = specialties;
	}
}
