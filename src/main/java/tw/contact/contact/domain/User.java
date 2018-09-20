package tw.contact.contact.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    public Map<String, Contact> getContacts() {
        return contacts;
    }

    private int id;
    private String name;

    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setContacts(Map<String, Contact> contacts) {
        this.contacts = contacts;
    }

    private Map<String, Contact> contacts = new HashMap<>();


}
