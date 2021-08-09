package com.govt.covid.support.data.service.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class InfectionDetails {
    @Id
    private Integer id;


    @Column
    private Date date;


    @Column
    private String time;

    @Column
    private String state;


    @Column
    private String confirmedIndianNational;


    @Column
    private String confirmedForeignNational;

    @Column
    private String cured;

    @Column
    private String deaths;

    @Column
    private String confirmed;
}
