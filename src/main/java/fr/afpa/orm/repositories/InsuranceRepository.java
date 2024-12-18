package fr.afpa.orm.repositories;

import fr.afpa.orm.entities.Insurance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface InsuranceRepository extends CrudRepository<Insurance, Integer> {

}
