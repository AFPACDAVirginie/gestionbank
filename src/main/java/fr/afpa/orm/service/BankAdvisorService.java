package fr.afpa.orm.service;

import fr.afpa.orm.entities.BankAdvisor;
import fr.afpa.orm.repositories.IBankAdvisorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BankAdvisorService implements IBankAdvisorService {

	private IBankAdvisorRepository bankAdvisorRepository;

	@Autowired
	public BankAdvisorService(IBankAdvisorRepository bankAdvisorRepository) {
		this.bankAdvisorRepository = bankAdvisorRepository;
	}

	@Override
	public Iterable<BankAdvisor> getAllBankAdvisors() {
		return bankAdvisorRepository.findAll();
	}

	@Override
	public void createBankAdvisor(BankAdvisor bankAdvisor) {
		bankAdvisorRepository.save(bankAdvisor);
	}

}
