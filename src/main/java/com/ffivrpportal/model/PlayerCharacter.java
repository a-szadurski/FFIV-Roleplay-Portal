package com.ffivrpportal.model;

import com.ffivrpportal.dto.PlayerCharacterDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "characters")
@Data
@NoArgsConstructor
public class PlayerCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String server;
    private String dataCenter;
    private Integer lodestoneId;
    private String description;
    private String bio;
    private String oocInfo;

    @ManyToOne
    private Job mainJob;

    @ManyToOne
    private Job secondaryJob;

    @ManyToOne
    private Job tertiaryJob;

    private String jobInfo;

    @ManyToOne
    private User user;

    public PlayerCharacter(PlayerCharacterDto playerCharacterDto) {
        this.id = playerCharacterDto.getId();
        this.firstName = playerCharacterDto.getFirstName();
        this.lastName = playerCharacterDto.getLastName();
        this.server = playerCharacterDto.getServer();
        this.dataCenter = playerCharacterDto.getDataCenter();
        this.bio = playerCharacterDto.getBio();
        this.oocInfo = playerCharacterDto.getOocInfo();
        this.mainJob = playerCharacterDto.getMainJob();
        this.secondaryJob = playerCharacterDto.getSecondaryJob();
        this.tertiaryJob = playerCharacterDto.getTertiaryJob();
        this.jobInfo = playerCharacterDto.getJobInfo();
        this.user = playerCharacterDto.getUser();
    }

}
