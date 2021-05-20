package com.ffivrpportal.dto;

import com.ffivrpportal.model.Job;
import com.ffivrpportal.model.PlayerCharacter;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlayerCharacterDto {

    private Long id;

    private String firstName;
    private String lastName;
    private String server;
    private String dataCenter;
    private String lodestoneId;
    private String description;
    private String bio;
    private String oocInfo;
    private Job mainJob;
    private Job secondaryJob;
    private Job tertiaryJob;
    private String jobInfo;

    public PlayerCharacterDto(PlayerCharacter playerCharacter){
        this.id = playerCharacter.getId();
        this.firstName = playerCharacter.getFirstName();
        this.lastName = playerCharacter.getLastName();
        this.server = playerCharacter.getServer();
        this.dataCenter = playerCharacter.getDataCenter();
        this.bio = playerCharacter.getBio();
        this.oocInfo = playerCharacter.getOocInfo();
        this.mainJob = playerCharacter.getMainJob();
        this.secondaryJob = playerCharacter.getSecondaryJob();
        this.tertiaryJob = playerCharacter.getTertiaryJob();
        this.jobInfo = playerCharacter.getJobInfo();
    }
}
