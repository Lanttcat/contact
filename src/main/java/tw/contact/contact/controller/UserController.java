package tw.contact.contact.controller;

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
    @PostMapping(value = "/users/{userId}")
    public ResponseEntity<User> createContactById(@PathVariable int userId, @RequestBody Contact contact) {
        return new ResponseEntity<>(userRepository.createContactByUserId(userId, contact), HttpStatus.CREATED);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<Map<String, Contact>> getContactListByUserId(@RequestParam int id) {
        return new ResponseEntity<>(userRepository.getContacts(id), HttpStatus.OK);
    }
}
