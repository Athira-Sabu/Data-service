package com.govt.covid.support.data.service.domain;

import com.govt.covid.support.data.service.entity.InfectionDetails;
import com.govt.covid.support.data.service.entity.TestingDetails;
import com.govt.covid.support.data.service.entity.VaccineDetails;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@ToString
@Getter
public class Response {
    private List<InfectionDetails> infectionDetails;
    private List<TestingDetails> testingDetails;
    private  List<VaccineDetails> vaccineDetails;
}
