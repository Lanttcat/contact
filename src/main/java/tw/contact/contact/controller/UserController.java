package tw.contact.contact.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tw.contact.contact.domain.Contact;
import tw.contact.contact.domain.User;
import tw.contact.contact.repository.impl.UserRepositoryImpl;

import java.util.List;
import java.util.Map;

@RequestMapping(value = "/api")
@RestController
public class UserController {
    UserRepositoryImpl userRepository =  new UserRepositoryImpl();
    @PostMapping(value = "/users/{userId}/contact")
    public ResponseEntity<User> createContactById(@PathVariable int userId, @RequestBody Contact contact) {
        return new ResponseEntity<>(userRepository.createContactByUserId(userId, contact), HttpStatus.CREATED);
    }

    @GetMapping(value = "/users/{userId}/contact")
    public ResponseEntity<Map<String, Contact>> getContactListByUserId(@PathVariable int userId) {
        return new ResponseEntity<>(userRepository.getContacts(userId), HttpStatus.OK);
    }

    @PutMapping(value = "users/{userId}/contact")
    public ResponseEntity<User> updateContact(@PathVariable int userId, @RequestBody Contact contact) {
        return new ResponseEntity<>(userRepository.updateContact(userId, contact), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/users/{userId}/contact")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContact(@PathVariable int userId, @RequestBody Contact contact) {
        userRepository.deleteContact(userId, contact);
    }
    @GetMapping(value = "/users/{userName}/contact/{contactName}")
    public ResponseEntity<Contact> getOneContact(@PathVariable String userName, @PathVariable String contactName) {
        return new ResponseEntity<>(userRepository.getOneContact(userName, contactName), HttpStatus.OK);
    }

}
