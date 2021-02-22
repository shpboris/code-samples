package org.users;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.users.domain.User;
import org.users.repository.UsersRepository;
import org.users.service.UserNamePrefixService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UsersApplicationIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserNamePrefixService userNamePrefixService;

    @BeforeEach
    void setUp(){
        usersRepository.deleteAll();
        when(userNamePrefixService.getPrefix()).thenReturn("prefix");
    }

    @Test
    @SneakyThrows
    void testCreateUser() {
        User user = new User("1", "test-user");

        mockMvc.perform(post("/users")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isCreated());

        Optional<User> res = usersRepository.findById("1");
        assertEquals(res.get().getName(), user.getName());
    }

    @Test
    @SneakyThrows
    void testGetUser() {
        User user = new User("1", "test-user");
        usersRepository.save(user);
        user.setName("prefix" + user.getName());

        mockMvc.perform(get("/users/1")
                .accept("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(user)));
    }
}
