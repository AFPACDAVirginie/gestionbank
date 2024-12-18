package fr.afpa.orm.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "insurance")
public class Insurance {

	@Column(name = "name")
	private String name;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	// Relation Many-to-Many avec Client
	@ManyToMany(mappedBy = "insurances")
	private Set<Client> clients = new HashSet<>();


	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Set<Client> getClients() {
		return clients;
	}
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
}
