package se.lexicon.g40_jpa_exercises.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.g40_jpa_exercises.model.AppUser;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootTest
@AutoConfigureTestEntityManager
@AutoConfigureTestDatabase
@Transactional

public class AppUserDAOimplTest {

    @Autowired
    AppUserDAOimpl testObject;

    @Autowired
    TestEntityManager entityManager;
    public List<AppUser> appUserList(){
        return Arrays.asList(
                new AppUser("ab1","Abdul","Rehman",LocalDate.parse("1900-01-01"),"1234"),
                new AppUser("wa1","Waqar","Ahmed",LocalDate.parse("1920-01-01"),"3214"),
                new AppUser("ma1","Mian","Riaz",LocalDate.parse("1975-01-01"),"4561")

        );
    }
    private List<AppUser> addedUsers;

    @BeforeEach
    void setUp() {
        addedUsers = appUserList().stream()
                .map(entityManager::persist)
                .collect(Collectors.toList());

    }
    @Test
    void save() {
        AppUser appUser = new AppUser("sam","Samaar","Ahmed"
                ,LocalDate.parse("1900-01-19"),"1234");

        AppUser result = testObject.save(appUser);

        assertNotNull(result);
        System.out.println(result);

    }

    @Test
    void update() {
        AppUser appUser = new AppUser("Arb","Arib","Ahmed"
                ,LocalDate.parse("2000-01-03"),"1235");

        AppUser result = testObject.update(appUser);
        assertNotNull(result);
        System.out.println(result);


    }

    @Test
    void findById() {

        int id = addedUsers.get(0).getUserId();
        System.out.println(id);
        Optional<AppUser> foundUsers = testObject.findById(id);
        assertTrue(foundUsers.isPresent());

    }

    @Test
    void delete() {

        AppUser appUser = addedUsers.remove(2);

        assertNull(entityManager.find(AppUser.class,appUser));
    }
}
