package tw.contact.contact.repository;

import org.springframework.http.ResponseEntity;
import tw.contact.contact.domain.Contact;
import tw.contact.contact.domain.User;

import java.util.HashMap;

public class UserStorage {
    private final static HashMap<Integer, User> USERS = new HashMap<>();
    static {
        USERS.put(1, new User(1, "lan"));
        USERS.put(2, new User(2, "yi"));
    }
    public static User createContact(int userId, Contact contact) {
        User updateUser = USERS.get(userId);
        updateUser.getContacts().put(contact.getName(), contact);

        return updateUser;
    }
}
