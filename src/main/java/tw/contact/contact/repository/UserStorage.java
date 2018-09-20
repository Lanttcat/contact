package tw.contact.contact.repository;

import org.springframework.http.ResponseEntity;
import tw.contact.contact.domain.Contact;
import tw.contact.contact.domain.User;

import java.util.HashMap;

public class UserStorage {
    private final static HashMap<Integer, User> USERS = new HashMap<>();
    static {
        User user1 = new User(1, "lan1");
        user1.getContacts().put("lan1", 1);
        USERS.put(1, user1);

        User user2 = new User(2, "lan2");
        user1.getContacts().put("lan2", 2);
        USERS.put(2, user2);
    }
    public static User get(int id) {
        return USERS.get(id);
    }
}
