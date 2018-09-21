package tw.contact.contact.repository;

import tw.contact.contact.domain.Contact;
import tw.contact.contact.domain.User;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ContactStorage {
    private final static HashMap<Integer, Contact> CONTACTS = new HashMap<>();
    static {
        CONTACTS.put(1, new Contact(1, "lan1", 23, "man", "123"));
        CONTACTS.put(2, new Contact(2, "lan2", 23, "man", "123"));
    }
    public static Contact add(Contact contact) {
        CONTACTS.put(contact.getId(), contact);
        return contact;
    }

    public static int size() {
        return CONTACTS.size();
    }

    public static Contact get(int key) {
        return CONTACTS.get(key);
    }

    public static void put(int id, Contact contact) {
        CONTACTS.put(id, contact);
    }

    public static void delete(int contactId) {
        CONTACTS.remove(contactId);
    }

    public static void clear() {
        CONTACTS.clear();
    }
}
