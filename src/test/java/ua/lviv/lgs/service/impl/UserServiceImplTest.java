package ua.lviv.lgs.service.impl;

import org.junit.jupiter.api.*;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import ua.lviv.lgs.SpringMagazineApplication;
import ua.lviv.lgs.controller.enumeration.UserRole;
import ua.lviv.lgs.entity.User;
import ua.lviv.lgs.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    private static ApplicationContext context;

    private UserService userService;
    private List<User> userList;
    private int userListSize;

    @BeforeAll
    static void init() {
        context = SpringApplication.run(SpringMagazineApplication.class);
    }

    @AfterAll
    static void cleanUp() {
    }

    @BeforeEach
    void setUp() {
        this.userService = context.getBean(UserService.class);
        this.userService.deleteAll();
        this.userListSize = 100;
        this.userList = new ArrayList<>(userListSize);
        fillWithUsers();
    }

    private void fillWithUsers() {
        IntStream.range(0, userListSize)
                .mapToObj((i) -> User.builder()
                    .firstName("Name #"+i)
                    .lastName("Surname #"+i)
                    .email("name#"+i+"@mail.com")
                    .password("pass-"+i)
                    .role(UserRole.USER.toString())
                    .build())
                .forEach((user) -> {
                    this.userList.add(user);
                    this.userService.save(user);
                });
    }

    @AfterEach
    void tearDown() {
        this.userList.clear();
        this.userService.deleteAll();
    }

    @Test
    void save() {
        User user = User.builder()
                .firstName("Steve")
                .lastName("Jobs")
                .email("steve.jobs@gmail.com")
                .password("apple")
                .role(UserRole.USER.toString())
                .build();

        userService.save(user);

        List<User> allUsers = userService.findAll();

        int expected = userList.size();
        int actual = allUsers.size()-1;
        assertEquals(expected, actual);

        User actualUser = allUsers.get(userList.size());
        assertEquals(user, actualUser);
    }

    @Test
    void findById() {

    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findByEmail() {
        String email = "steve.jobs@gmail.com";

        User user = User.builder()
                .firstName("Steve")
                .lastName("Jobs")
                .email("steve.jobs@gmail.com")
                .password("apple")
                .role(UserRole.USER.toString())
                .build();

        userService.save(user);

        Optional<User> byEmail = userService.findByEmail(email);
        if (byEmail.isPresent()) {
            User foundUserByEmail = byEmail.get();
            assertEquals(user, foundUserByEmail);
        } else {
            fail(new NullPointerException());
        }
    }

}