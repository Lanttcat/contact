package tw.contact.contact.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tw.contact.contact.domain.Contact;
import tw.contact.contact.domain.User;
import tw.contact.contact.repository.ContactStorage;
import tw.contact.contact.repository.UserStorage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class UserControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = standaloneSetup(new UserController()).build();
        UserStorage.clear();
        ContactStorage.clear();
    }

    @Test
    public void should_add_contact_in_user_by_id() throws Exception {
        UserStorage.add(new User(5, "lan"));
        Contact contact = new Contact(1, "wang", 23, "man", "123");

        mockMvc.perform(post("/api/users/5/contact")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(contact)))
                // TODO: 2018/9/20 yichang
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("lan"))
                .andExpect(jsonPath("$.contacts.length()").value(1))
                .andExpect(jsonPath("$.contacts.wang").value(1));

        assertEquals(1, ContactStorage.size());
        assertEquals(1, UserStorage.get(5).getContacts().size());
    }

    @Test
    public void should_get_contact_by_user_id() throws Exception {
        User user = new User(5, "lan");
        Contact contact = new Contact(1, "wang", 23, "man", "123");
        UserStorage.add(user);
        user.getContacts().put(contact.getName(), contact.getId());

        // TODO: 2018/9/20
        mockMvc.perform(get("/api/users/5/contact"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));

        assertEquals(java.util.Optional.of(1).get(), UserStorage.get(5).getContacts().get("wang"));
    }

    @Test
    public void should_update_contact() throws Exception {
        User user = new User(5, "lan");
        Contact contact = new Contact(1, "wang", 23, "man", "123");
        UserStorage.add(user);
        user.getContacts().put(contact.getName(), contact.getId());

        Contact updateContact = new Contact(1, "wang", 23, "woman", "13323");

        mockMvc.perform(put("/api/users/5/contact")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(updateContact)))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.name").value("lan"))
                .andExpect(jsonPath("$.id").value(5));

        assertEquals("woman", ContactStorage.get(1).getSex());
    }

    @Test
    public void should_delete_one_contact() throws Exception {
        User user = new User(5, "lan");
        Contact contact = new Contact(1, "wang", 23, "man", "123");
        UserStorage.add(user);
        user.getContacts().put(contact.getName(), contact.getId());

        Contact deleteContact = new Contact(1, "wang", 23, "man", "123");
        mockMvc.perform(delete("/api/users/5/contact")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(deleteContact)))
                .andExpect(status().isNoContent());
        assertEquals(0, ContactStorage.size());
        assertEquals(null, UserStorage.get(5).getContacts().get("wang"));
    }

    @Test
    public void should_get_one_contact_by_user_id_and_contact_name() throws Exception {
        User user = new User(5, "lan");
        Contact contact = new Contact(1, "wang", 23, "man", "123");
        UserStorage.add(user);
        ContactStorage.add(contact);

        user.getContacts().put(contact.getName(), contact.getId());

        mockMvc.perform(get("/api/users/lan/contact/wang"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("wang"))
                .andExpect(jsonPath("$.sex").value("man"));
    }
}
