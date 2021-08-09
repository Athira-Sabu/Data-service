package com.govt.covid.support.data.service.entity;

import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString

@NoArgsConstructor
public class VaccineDetails {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Date updatedOn;

    public VaccineDetails(Date updatedOn, String state, String totalDosesAdmit, String sessionConducted, String totalSites, String firstDose, String secondDose, String maleCount) {
        this.updatedOn = updatedOn;
        this.state = state;
        this.totalDosesAdmit = totalDosesAdmit;
        this.sessionConducted = sessionConducted;
        this.totalSites = totalSites;
        this.firstDose = firstDose;
        this.secondDose = secondDose;
        this.maleCount = maleCount;
    }

    @Column
    private String state;
    @Column
    private String totalDosesAdmit;
    @Column
    private String sessionConducted;
    @Column
    private String totalSites;
    @Column
    private String firstDose;
    @Column
    private String secondDose;
    @Column
    private String maleCount;
    @Column
    private String femaleCount;
    @Column
    private String transgender;
    @Column
    private String covaxinCount;
    @Column
    private String coviShield;
    @Column
    private String Sputnik;
    @Column
    private String aefi;
    @Column
    private String youngAge;
    @Column
    private  String middleAge;
    @Column
    private String elderly;
    @Column
    private String totalVaccinated;
}
