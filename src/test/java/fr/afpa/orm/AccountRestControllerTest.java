//package fr.afpa.orm;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//import fr.afpa.orm.entities.Account;
//import fr.afpa.orm.repositories.AccountRepository;
//import fr.afpa.orm.web.controllers.AccountRestController;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.web.context.WebApplicationContext;
//
//import java.util.List;
//import java.util.Optional;
//
///**
// * Test unitaire pour AccountRestController
// */
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(AccountRestController.class)
//public class AccountRestControllerTest {
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@MockBean
//	private AccountRepository accountRepository;
//
//	private Account account;
//
//	@BeforeEach
//	public void setUp() {
//		// Initialisation d'un compte pour les tests
//		account = new Account();
//		account.setId(1L);
//		account.setLastName("John Doe");
//	}
//
//	@Test
//	public void testGetAccount() throws Exception {
//		when(accountRepository.findById(1L)).thenReturn(Optional.of(account));
//
//		mockMvc.perform(get("/accounts/{id}", 1L))
//				.andExpect(status().isOk())
//				.andExpect(jsonPath("$.id").value(1L))
//				.andExpect(jsonPath("$.lastName").value("John Doe"));
//	}
//
//	@Test
//	public void testGetAccountNotFound() throws Exception {
//		when(accountRepository.findById(1L)).thenReturn(Optional.empty());
//
//		mockMvc.perform(get("/accounts/{id}", 1L))
//				.andExpect(status().isNotFound());
//	}
//
//	@Test
//	public void testGetAllAccounts() throws Exception {
//		when(accountRepository.findAll()).thenReturn(List.of(account));
//
//		mockMvc.perform(get("/accounts"))
//				.andExpect(status().isOk())
//				.andExpect(jsonPath("$[0].id").value(1L))
//				.andExpect(jsonPath("$[0].lastName").value("John Doe"));
//	}
//
//	@Test
//	public void testCreateAccount() throws Exception {
//		when(accountRepository.save(any(Account.class))).thenReturn(account);
//
//		mockMvc.perform(post("/accounts")
//						.contentType("application/json")
//						.content("{ \"lastName\": \"John Doe\" }"))
//				.andExpect(status().isCreated())
//				.andExpect(jsonPath("$.id").value(1L))
//				.andExpect(jsonPath("$.lastName").value("John Doe"));
//	}
//
//	@Test
//	public void testUpdateAccount() throws Exception {
//		// Préparer l'objet account existant
//		Account existingAccount = new Account();
//		existingAccount.setId(1L);
//		existingAccount.setLastName("John Doe");
//
//		// Simuler la récupération du compte existant par l'ID
//		when(accountRepository.findById(1L)).thenReturn(Optional.of(existingAccount));
//
//		// Créer l'objet account mis à jour
//		Account updatedAccount = new Account();
//		updatedAccount.setId(1L);
//		updatedAccount.setLastName("John Updated");
//
//		// Simuler la sauvegarde de l'account mis à jour
//		when(accountRepository.save(any(Account.class))).thenReturn(updatedAccount);
//
//		// Effectuer la requête PUT
//		mockMvc.perform(put("/accounts/{id}", 1L)
//						.contentType("application/json")
//						.content("{ \"lastName\": \"John Updated\" }"))
//				.andExpect(status().isOk())
//				.andExpect(jsonPath("$.lastName").value("John Updated"))
//				.andExpect(jsonPath("$.id").value(1L));
//	}
//
//	@Test
//	public void testDeleteAccount() throws Exception {
//		when(accountRepository.findById(1L)).thenReturn(Optional.of(account));
//
//		mockMvc.perform(delete("/accounts/{id}", 1L))
//				.andExpect(status().isNoContent());
//	}
//
//	@Test
//	public void testDeleteAccountNotFound() throws Exception {
//		when(accountRepository.findById(1L)).thenReturn(Optional.empty());
//
//		mockMvc.perform(delete("/accounts/{id}", 1L))
//				.andExpect(status().isNotFound());
//	}
//}
