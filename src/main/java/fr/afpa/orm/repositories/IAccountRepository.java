package fr.afpa.orm.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.afpa.orm.entities.Account;

/**
 * Implémenter un "repository" (similaire à un DAO) permettant d'interagir avec les données de la BDD
 * Tutoriel -> https://www.geeksforgeeks.org/spring-boot-crudrepository-with-example/
 */
@Repository
public interface IAccountRepository extends CrudRepository<Account, Long> {
	/**
	 * @return Tous les comptes enregistrés
	 */
	//List<Account> findAll(); inutile car contenu dans CRUD

	/**
	 * @param id Identifiant du compte à retrouver
	 * @return Un objet de compte correspondant à l'identifiant en paramètre
	 */
	//Optional<Account> findById(long id); inutile car contenu dans CRUD

	/**
	 * Enregistre les informations d'un compte
	 * @param account Le compte à enregistrer
	 * @return L'objet enregistré
	 */
	//Account save(Account account); inutile car contenu dans CRUD

	/**
	 * Suppression d'un compte
	 * @param account
	 */
	//void delete(Account account); inutile car contenu dans CRUD

}
