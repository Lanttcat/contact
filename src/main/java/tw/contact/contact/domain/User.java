package tw.contact.contact.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private int id;

    private String name;
    private Map<String, Integer> contacts = new HashMap<>();

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

    public void setContacts(Map<String, Integer> contacts) {
        this.contacts = contacts;
    }

    public Map<String, Integer> getContacts() {
        return contacts;
    }
}
