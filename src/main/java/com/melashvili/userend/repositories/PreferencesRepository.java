package com.melashvili.userend.repositories;

import com.melashvili.userend.model.entitites.Preferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreferencesRepository extends JpaRepository<Preferences, Long> {

    List<Preferences> findByEmailOpt(Boolean emailOpt);

    List<Preferences> findBySmsOpt(Boolean smsOpt);

    List<Preferences> findByPromoOpt(Boolean promoOpt);
}
