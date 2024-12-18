package fr.afpa.orm.web.controllers;

import fr.afpa.orm.entities.Client;
import fr.afpa.orm.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/clients")
public class ClientRestController {

private final ClientRepository clientRepository;

	@Autowired
	public ClientRestController(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@GetMapping
	public List<Client> getAllClients() {
		return (List<Client>) clientRepository.findAll();
	}

	// Méthode pour récupérer un client par ID
	@GetMapping("/{id}")
	public List<Client> getClients(@PathVariable int id) {
		Optional<Client> client = clientRepository.findById(id);
		List<Client> clients = new ArrayList<>();
		if (client.isPresent()) {
			clients.add(client.get());
		} else {
			return null; // ou retournez une réponse appropriée comme une exception
		}
		return clients;
	}
}
