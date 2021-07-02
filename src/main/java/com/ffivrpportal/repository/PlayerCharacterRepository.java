package com.ffivrpportal.repository;

import com.ffivrpportal.model.PlayerCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PlayerCharacterRepository extends JpaRepository<PlayerCharacter, Long> {

    @Query("SELECT pc FROM PlayerCharacter pc WHERE pc.user.id = ?1")
    List<PlayerCharacter> findPlayerCharactersByUserId(Long id);
}
