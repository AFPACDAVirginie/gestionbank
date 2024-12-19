package fr.afpa.orm.repositories;

import fr.afpa.orm.entities.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IClientRepository extends CrudRepository<Client, Integer> {


	Iterable<Client> findAllByOrderByLastNameAsc();

	Optional<Client> findById(UUID clientId);
}
