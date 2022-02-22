package se.lexicon.g40_jpa_exercises.dao;

import se.lexicon.g40_jpa_exercises.model.AppUser;

import java.util.Optional;

public interface AppUserDAO {

    AppUser save(AppUser appuser) ;
    AppUser update(AppUser appuser) ;
    Optional<AppUser> findById(int id) ;
    boolean delete(AppUser appuser);

}
