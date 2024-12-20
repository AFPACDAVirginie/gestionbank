package fr.afpa.orm.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fr.afpa.orm.entities.Account;
import fr.afpa.orm.repositories.IAccountRepository;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Ajouter la/les annotations nécessaires pour faire de "AccountRestController" un contrôleur de REST API
 */
@RestController
@RequestMapping("/accounts")
public class AccountRestController {


private final IAccountRepository IAccountRepository;
    /** 
     * Implémenter un constructeur
     *  
     * Injecter {@link IAccountRepository} en dépendance par injection via le constructeur
     * Plus d'informations https://keyboardplaying.fr/blogue/2021/01/spring-injection-constructeur/
     */
    @Autowired
    public AccountRestController(IAccountRepository IAccountRepository) {
        this.IAccountRepository = IAccountRepository;
    }



    /**
     * Implémenter une méthode qui traite les requêtes GET et qui renvoie une liste de comptes
     *
     * Attention, il manque peut-être une annotation :)
     */
    @GetMapping
    public List<Account> getAll() {
        // Récupération des compte provenant d'un repository
       
        // Renvoyer les objets de la classe "Account"
        return (List<Account>) IAccountRepository.findAll();
    }

    /**
     * Implémenter une méthode qui traite les requêtes GET avec un identifiant "variable de chemin" et qui retourne les informations du compte associé
     * Plus d'informations sur les variables de chemin  https://www.baeldung.com/spring-pathvariable
     */
    @GetMapping("/{id}")
    public ResponseEntity<Account> getOne(@PathVariable long id) {
        // Compléter le code
        Optional<Account> account = IAccountRepository.findById(id);
        if (account.isPresent()) {
            return new ResponseEntity<>(account.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Implémenter une méthode qui traite les requêtes POST
     * Cette méthode doit recevoir les informations d'un compte en tant que "request body", elle doit sauvegarder le compte en mémoire et retourner ses informations (en json)
     * Tutoriel intéressant https://stackabuse.com/get-http-post-body-in-spring/
     * Le serveur devrait retourner un code http de succès (201 Created)
     **/
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Account create(@RequestBody Account account) {
        return IAccountRepository.save(account);
    }

    /**
     * Implémenter une méthode qui traite les requêtes PUT
     * 
     * Attention de bien ajouter les annotations qui conviennent
     */
//    public void update(@PathVariable long id, @RequestBody Account account) {
//        // Compléter le code
//    }
@PutMapping("/{id}")
public ResponseEntity<Account> update(@PathVariable long id, @RequestBody Account account) {
    Optional<Account> existingAccount = IAccountRepository.findById(id);
    if (existingAccount.isPresent()) {
        account.setId(id);  // Assurez-vous que l'id reste intact
        Account updatedAccount = IAccountRepository.save(account);
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

    /**
     * Implémenter une méthode qui traite les requêtes DELETE
     * L'identifiant du compte devra être passé en "variable de chemin" (ou "path variable")
     * Dans le cas d'une suppression effectuée avec succès, le serveur doit retourner un statut http 204 (No content)
     * 
     * Il est possible de modifier la réponse du serveur en utilisant la méthode "setStatus" de la classe HttpServletResponse pour configurer le message de réponse du serveur
     */
//    public void remove(@PathVariable long id, HttpServletResponse response) {
//        // Implémentation
//    }
@DeleteMapping("/{id}")
public ResponseEntity<Void> remove(@PathVariable long id, HttpServletResponse response) {
    Optional<Account> account = IAccountRepository.findById(id);
    if (account.isPresent()) {
        IAccountRepository.delete(account.get());
        response.setStatus(HttpServletResponse.SC_NO_CONTENT); // 204 No Content
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
}
