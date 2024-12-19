package fr.afpa.orm.web.controllers;

import fr.afpa.orm.entities.BankAdvisor;
import fr.afpa.orm.service.IBankAdvisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/bankadvisors")
public class BankAdvisorRestController {

	private final IBankAdvisorService bankAdvisorService;

	@Autowired
	public BankAdvisorRestController(IBankAdvisorService bankAdvisorService) {
		this.bankAdvisorService = bankAdvisorService;
	}

	@PostMapping
	public ResponseEntity<BankAdvisor> createBankAdvisor(@RequestBody BankAdvisor bankAdvisor) {
		bankAdvisor.setId(UUID.randomUUID());
		bankAdvisorService.createBankAdvisor(bankAdvisor);
		return ResponseEntity.ok(bankAdvisor);  // Retourner l'advisor créé
	}

	@GetMapping
	public ResponseEntity<Iterable<BankAdvisor>> getAllBankAdvisors() {
		Iterable<BankAdvisor> bankAdvisors = bankAdvisorService.getAllBankAdvisors();
		return ResponseEntity.ok(bankAdvisors);
	}

}
