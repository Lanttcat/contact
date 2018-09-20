package tw.contact.contact.repository;

import tw.contact.contact.domain.Contact;
import tw.contact.contact.domain.User;

public interface UserRepository {
    public User createContact(int userId, Contact contact);

}
