package tw.contact.contact.repository.impl;

import tw.contact.contact.domain.Contact;
import tw.contact.contact.domain.User;
import tw.contact.contact.repository.ContactRepository;
import tw.contact.contact.repository.UserRepository;
import tw.contact.contact.repository.UserStorage;

public class UserRepositoryImpl implements UserRepository{
    ContactRepositoryImpl contactRepository = new ContactRepositoryImpl();
    @Override
    public User createContactByUserId(int userId, Contact contact) {
        Contact addContact = contactRepository.add(contact);
        UserStorage.get(userId).getContacts().put(addContact.getName(), addContact);
        return UserStorage.get(userId);
    }
}
