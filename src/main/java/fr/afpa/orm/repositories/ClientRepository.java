package fr.afpa.orm.repositories;

import fr.afpa.orm.entities.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {

	Optional<Client> findById(UUID id);
}
