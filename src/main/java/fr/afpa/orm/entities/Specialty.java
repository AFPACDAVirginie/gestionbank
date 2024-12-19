package fr.afpa.orm.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "specialties")
public class Specialty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// Relation ManyToOne : chaque spécialité est liée à un seul bankadvisor
	@ManyToOne
	@JoinColumn(name = "bankadvisor_id", nullable = false)  // La colonne bankadvisor_id dans specialties
	@JsonBackReference
	private BankAdvisor bankAdvisor;

	@Enumerated(EnumType.STRING)
	@Column(name = "specialty")
	private SpecialtyType specialty;

	// Enum pour définir les types de spécialités
	public enum SpecialtyType {
		Assurance, Placement_Prêt, immobilier, Crédit_consommation
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BankAdvisor getBankAdvisor() {
		return bankAdvisor;
	}

	public void setBankAdvisor(BankAdvisor bankAdvisor) {
		this.bankAdvisor = bankAdvisor;
	}

	public SpecialtyType getSpecialty() {
		return specialty;
	}

	public void setSpecialty(SpecialtyType specialty) {
		this.specialty = specialty;
	}
}
