package tw.contact.contact.repository;

import tw.contact.contact.domain.Contact;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ContactStorage {
    private final static HashMap<Integer, Contact> CONTACTS = new HashMap<>();
    public static Contact add(Contact contact) {
        CONTACTS.put(contact.getId(), contact);
        return contact;
    }

    public static int size() {
        return CONTACTS.size();
    }
}
