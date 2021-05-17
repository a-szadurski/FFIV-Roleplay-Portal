package com.ffivrpportal.service;

import com.ffivrpportal.repository.PlayerCharacterRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerCharacterServiceImpl implements PlayerCharacterService{

    private final PlayerCharacterRepository playerCharacterRepository;

    public PlayerCharacterServiceImpl(PlayerCharacterRepository playerCharacterRepository) {
        this.playerCharacterRepository = playerCharacterRepository;
    }
}
