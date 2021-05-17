package com.ffivrpportal.model;

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

}
