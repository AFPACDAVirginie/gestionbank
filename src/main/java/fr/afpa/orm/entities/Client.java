package fr.afpa.orm.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name="client")
public class Client extends Person {

    /**
     * Identifiant unique de l'utilisateur
     * Article présentant l'utilisation d'UUID -> https://www.baeldung.com/java-hibernate-uuid-primary-key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    /**
     * Association de type "OneToMany" : une personne peut avoir plusieurs comptes
     */
    @JsonIgnore
    @OneToMany(targetEntity = Account.class, mappedBy = "owner")
    private List<Account> accounts;

    /**
     * le conseiller qui suit ce client
     */
    @JsonBackReference // Permet d'éviter une boucle infinie dans les sérialisations JSON
    @ManyToOne
    @JoinColumn(name = "bankadvisor_id", nullable = false)
    private BankAdvisor owner;


    // Relation Many-to-Many avec Insurance
    @ManyToMany
    @JoinTable(
            name = "client_insurance",   // Nom de la table de liaison
            joinColumns = @JoinColumn(name = "client_id"),   // Colonne pour la clé étrangère client
            inverseJoinColumns = @JoinColumn(name = "insurance_id")  // Colonne pour la clé étrangère assurance
    )
    private Set<Insurance> insurances = new HashSet<>();

    public Client() {
        // Constructeur vide.
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Set<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(Set<Insurance> insurances) {
        this.insurances = insurances;
    }

}
