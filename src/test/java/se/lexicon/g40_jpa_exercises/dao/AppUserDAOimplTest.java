package se.lexicon.g40_jpa_exercises.dao;

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
@SpringBootTest
@AutoConfigureTestEntityManager
@AutoConfigureTestDatabase
@Transactional

public class AppUserDAOimplTest {

    @Autowired
    AppUserDAOimpl testObject;

    @Autowired
    TestEntityManager entityManager;


    @Test
    void save() {
        AppUser appUser = new AppUser("sam","Samaar","Ahmed"
                ,LocalDate.parse("1985-11-19"),"1234");

        AppUser result = testObject.save(appUser);
        assertNotNull(result);

    }
}
