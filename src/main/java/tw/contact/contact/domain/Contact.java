package tw.contact.contact.domain;

public class Contact {
    private int id;
    private String name;
    private int age;
    private String string;

    public Contact() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getString() {
        return string;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact(int id, String name, int age, String string, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.string = string;
        this.phone = phone;
    }

    private String phone;
}
