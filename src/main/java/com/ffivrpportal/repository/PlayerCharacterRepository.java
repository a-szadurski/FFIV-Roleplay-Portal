package com.ffivrpportal.repository;

import com.ffivrpportal.model.PlayerCharacter;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PlayerCharacterRepository extends JpaRepository<PlayerCharacter, Long> {
}
