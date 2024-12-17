package fr.afpa.orm.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

/**
 * Classe représentant le compte bancaire d'un utilisateur
 * 
 * Faire de cette classe une entité
 * Plus d'informations sur les entités -> https://gayerie.dev/epsi-b3-orm/javaee_orm/jpa_entites.html
 * Attention de bien choisir les types en fonction de ceux du script SQL.
 */
@Entity
@Table(name = "Account")
public class Account {
    /**
     * Identifiant unique du compte
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Le solde du compte
     */
    @Column(name = "balance", precision = 15, scale = 2)
    private BigDecimal balance;

    /**
     * La date de création du compte
     */
    @Column(name = "creationtime")
    private LocalDateTime creationtime;

    /**
     * L'utilisateur auquel ce compte appartient
     */
    @JsonBackReference // Permet d'éviter une boucle infinie dans les sérialisations JSON
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client owner;

    /**
     * Indicateur de l'état du compte (actif ou non)
     */
    @Column(name = "active", nullable = false)
    private boolean active;

    /*
     * Implémenter un constructeur vide obligatoire pour l'utilisation d'un ORM
     */
    public Account() {
        this.creationtime = LocalDateTime.now();
    }


    /*
     * Implémenter les getters et les setters
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public LocalDateTime getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(LocalDateTime creationtime) {
        this.creationtime = creationtime;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
