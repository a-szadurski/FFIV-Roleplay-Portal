package com.ffivrpportal.dto;

import com.ffivrpportal.model.Job;
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
    private Integer lodestoneId;
    private String description;
    private String bio;
    private String oocInfo;
    private Job mainJob;
    private Job secondaryJob;
    private Job tertiaryJob;
    private String jobInfo;
}
