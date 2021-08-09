package com.govt.covid.support.data.service.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString

@NoArgsConstructor
public class TestingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Date date;

    @Column
    private String state;

    public TestingDetails(Date date, String state, String totalSamples, String negative, String positive) {
        this.date = date;
        this.state = state;
        this.totalSamples = totalSamples;
        this.negative = negative;
        this.positive = positive;
    }

    @Column
    private String totalSamples;

    @Column
    private String negative;
    @Column
    private String positive;

}
