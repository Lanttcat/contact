package tw.contact.contact.repository.impl;

import tw.contact.contact.domain.Contact;
import tw.contact.contact.repository.ContactRepository;
import tw.contact.contact.repository.ContactStorage;

public class ContactRepositoryImpl implements ContactRepository {

    @Override
    public Contact add(Contact contact) {
        return ContactStorage.add(contact);
    }
}
