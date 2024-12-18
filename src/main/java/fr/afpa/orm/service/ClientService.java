package fr.afpa.orm.service;

import fr.afpa.orm.entities.Client;
import fr.afpa.orm.entities.Insurance;
import fr.afpa.orm.repositories.ClientRepository;
import fr.afpa.orm.repositories.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ClientService implements IClientService {

	private final ClientRepository clientRepository;

	@Autowired
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	@Autowired
	private InsuranceRepository insuranceRepository;

	@Override
	public List<Client> getAllClients() {
		Iterable<Client> allClients = clientRepository.findAll();
		return StreamSupport.stream(allClients.spliterator(), false)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<Client> getClientById(UUID id) {
		return Optional.empty();
	}

	@Override
	public List<Client> getClientsByLastNameAsc() {
		return (List<Client>) clientRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public void subscribeClientToInsurance(UUID clientId, Long insuranceId) {
		Client client = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));
		Insurance insurance = insuranceRepository.findById(Math.toIntExact(insuranceId)).orElseThrow(() -> new RuntimeException("Insurance not found"));

		client.getInsurances().add(insurance);  // Ajouter l'assurance au client
		clientRepository.save(client);  // Sauvegarder le client (avec les assurances mises à jour)
	}

	@Override
	public Set<String> getClientInsurances(UUID clientId) {
		// Récupérer le client
		Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new RuntimeException("Client not found"));

		// Retourner les noms des assurances souscrites par ce client
		return client.getInsurances().stream()
				.map(Insurance::getName)
				.collect(Collectors.toSet());
	}

}
