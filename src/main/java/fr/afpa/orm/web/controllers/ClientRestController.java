package fr.afpa.orm.web.controllers;

import fr.afpa.orm.dto.ClientDto;
import fr.afpa.orm.entities.Client;

import fr.afpa.orm.entities.Insurance;
import fr.afpa.orm.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clients")
public class ClientRestController {

	private final IClientService clientService;

	@Autowired
	public ClientRestController(IClientService clientService) {
		this.clientService = clientService;
	}

	@GetMapping
	public List<ClientDto> getAllClients() {
		List<Client> clients = clientService.getAllClients();
		return clients.stream()
			.map(client -> new ClientDto(client.getId(), client.getFirstName(), client.getLastName(), client.getEmail(), client.getBirthDate()))
			.collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public Optional<ClientDto> getClient(@PathVariable UUID id) {
		Optional<Client> client = clientService.getClientById(id);
		return client.map(c -> new ClientDto(c.getId(), c.getFirstName(), c.getLastName(), c.getEmail(), c.getBirthDate()));
	}

	@GetMapping("/sorted")
	public List<ClientDto> getClientsSortedByLastName() {
		return clientService.getClientsByLastNameAsc().stream()
				.map(client -> new ClientDto(client.getId(), client.getFirstName(), client.getLastName(), client.getEmail(), client.getBirthDate()))
				.collect(Collectors.toList());
	}

	@PostMapping("/{clientId}/subscribe/{insuranceId}")
	public String subscribeToInsurance(@PathVariable UUID clientId, @PathVariable Long insuranceId) {
		clientService.subscribeClientToInsurance(clientId, insuranceId);
		return "Souscription réussie";
	}
	// Endpoint pour récupérer les assurances souscrites par un client
	@GetMapping("/{clientId}/insurances")
	public Set<String> getClientInsurances(@PathVariable UUID clientId) {
		// Appel du service pour récupérer les assurances
		return clientService.getClientInsurances(clientId);
	}

}
