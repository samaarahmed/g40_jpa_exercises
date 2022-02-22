package se.lexicon.g40_jpa_exercises.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.g40_jpa_exercises.model.AppUser;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class AppUserDAOimpl implements AppUserDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public AppUser save(AppUser appuser) {
        if(appuser == null) throw new IllegalArgumentException("Entity was null");
       if(appuser.getUserId() == 0) {
            entityManager.persist(appuser);
        }
        return appuser;
    }

    @Override
    @Transactional
    public AppUser update(AppUser appuser) {
            if(appuser.getUserId()>0) {
                entityManager.merge(appuser);
            }

        return appuser;
    }
    @Override
    @Transactional
    public Optional<AppUser> findById(int id) {
        AppUser appUser = entityManager.find(AppUser.class, id);
        return Optional.ofNullable(appUser);

    }


    @Override
    @Transactional
    public boolean delete(AppUser appuser) {

        if (appuser.getUserId()>0) {
            entityManager.remove(appuser);
            return true;
        }

            return false;
    }
}
