package tw.contact.contact.repository.impl;

import tw.contact.contact.domain.Contact;
import tw.contact.contact.domain.User;
import tw.contact.contact.repository.UserRepository;
import tw.contact.contact.repository.UserStorage;

public class UserRepositoryImpl implements UserRepository{
    @Override
    public User createContact(int userId, Contact contact) {
        return UserStorage.createContact(userId, contact);
    }
}
