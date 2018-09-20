package tw.contact.contact.repository.impl;

import tw.contact.contact.domain.Contact;
import tw.contact.contact.domain.User;
import tw.contact.contact.repository.ContactStorage;
import tw.contact.contact.repository.UserRepository;
import tw.contact.contact.repository.UserStorage;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository{
    ContactRepositoryImpl contactRepository = new ContactRepositoryImpl();
    @Override
    public User createContactByUserId(int userId, Contact contact) {
        Contact addContact = contactRepository.add(contact);
        UserStorage.get(userId).getContacts().put(addContact.getName(), addContact.getId());
        return UserStorage.get(userId);
    }

    @Override
    public Map<String, Contact> getContacts(int id) {
        Map<String, Integer> userContacts = UserStorage.get(id).getContacts();
        Map<String, Contact> contacts = new HashMap<>();
        userContacts.forEach((key, value) -> {
            contacts.put(key, ContactStorage.get(value));
        });
        return contacts;
    }

    @Override
    public User updateContact(int userId, Contact contact) {
        User user = UserStorage.get(userId);
        int contactId = user.getContacts().get(contact.getName());
        ContactStorage.put(contactId, contact);
        return user;
    }

    @Override
    public void deleteContact(int userId, Contact contact) {
        User user = UserStorage.get(userId);
        int contactId = user.getContacts().get(contact.getName());
        user.getContacts().remove(contact.getName());
        ContactStorage.delete(contactId);
    }
}
