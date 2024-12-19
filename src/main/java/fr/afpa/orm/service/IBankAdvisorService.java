package fr.afpa.orm.service;

import fr.afpa.orm.entities.BankAdvisor;

public interface IBankAdvisorService {

	void createBankAdvisor(BankAdvisor bankAdvisor);

	Iterable<BankAdvisor> getAllBankAdvisors();
}
