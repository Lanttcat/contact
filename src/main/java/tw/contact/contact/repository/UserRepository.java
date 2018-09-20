package tw.contact.contact.repository;

import tw.contact.contact.domain.Contact;
import tw.contact.contact.domain.User;

import java.util.Map;

public interface UserRepository {
    public User createContactByUserId(int userId, Contact contact);

    public Map<String, Contact> getContacts(int id);

    public User updateContact(int userId, Contact contact);

    void deleteContact(int userId, Contact contact);

    Contact getOneContact(String userName, String contactName);
}
