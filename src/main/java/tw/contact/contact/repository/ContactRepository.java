package tw.contact.contact.repository;

import tw.contact.contact.domain.Contact;

public interface ContactRepository {
    Contact add(Contact contact);
}
