package com.melashvili.userend.repositories;

import com.melashvili.userend.model.entitites.Preferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferencesRepository extends JpaRepository<Preferences, Long> {
}
