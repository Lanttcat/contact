package tw.contact.contact.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tw.contact.contact.domain.Contact;
import tw.contact.contact.repository.ContactStorage;
import tw.contact.contact.repository.UserStorage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class UserControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = standaloneSetup(new UserController()).build();

    }

    @Test
    public void should_add_contact_in_user_by_id() throws Exception {
        Contact contact = new Contact(1, "lan", 23, "man", "123");
        mockMvc.perform(post("/api/users/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(contact)))
                // TODO: 2018/9/20
                .andExpect(status().isCreated());

        assertEquals(1, ContactStorage.size());
        assertEquals(3, UserStorage.get(1).getContacts().size());
    }

    @Test
    public void should_get_contact_by_user_id() throws Exception {
        // TODO: 2018/9/20
        mockMvc.perform(get("/api/users").param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$.lan1.name").value("lan1"))
                .andExpect(jsonPath("$.lan2.name").value("lan2"));
    }
}
