package fr.afpa.orm.service;

import fr.afpa.orm.entities.Client;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface IClientService {

	List<Client> getAllClients();
	Optional<Client> getClientById(UUID id);
	// Obtenir les assurances d'un client
	Set<String> getClientInsurances(UUID clientId);
	List<Client> getClientsByLastNameAsc();

	void subscribeClientToInsurance(UUID clientId, Long insuranceId);


}
