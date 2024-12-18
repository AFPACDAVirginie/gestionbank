package fr.afpa.orm.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import fr.afpa.orm.entities.Account;
import fr.afpa.orm.entities.Client;

/**
 * Implémenter un DTO (uniquement à partir de l'implémentation de la relation "OneToMany")
 * 
 * Attention : il faudra peut-être 1 DTO par classe métier ?
 * 
 * Plus d'informations sur le pattern DTO : https://medium.com/@zubeyrdamar/java-spring-boot-handling-infinite-recursion-a95fe5a53c92
 */
/**
 * DTO pour la classe Account. Ce DTO est utilisé pour éviter la sérialisation
 * circulaire et fournir des informations pertinentes au client via l'API REST.
 */
public class AccountDto {

	private long id;
	private BigDecimal balance;
	private LocalDateTime creationtime;
	private List<ClientDto> clients;

	public AccountDto() {
		// Constructeur sans argument (utile pour la deserialization)
	}

	// Constructeur avec arguments pour initialiser les champs
	public AccountDto(Account account) {
		this.id = account.getId();
		this.balance = account.getBalance();
		this.creationtime = account.getCreationtime();
		this.clients=clients;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public LocalDateTime getCreationtime() {
		return creationtime;
	}
	public void setCreationtime(LocalDateTime creationtime) {
		this.creationtime = creationtime;
	}

	public List<ClientDto> getClients() {
		return clients;
	}

	public void setClients(List<ClientDto> clients) {
		this.clients = clients;
	}

	@Override
	public String toString() {
		return STR."AccountDto [id=\{id}, balance=\{balance}, creationtime=\{creationtime}, clients=\{clients}]";
	}
}
