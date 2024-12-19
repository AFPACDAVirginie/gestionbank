package fr.afpa.orm.repositories;


import fr.afpa.orm.entities.BankAdvisor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IBankAdvisorRepository extends CrudRepository<BankAdvisor, Integer> {

	Optional<BankAdvisor> findById(UUID bankAdvisorId);
}
