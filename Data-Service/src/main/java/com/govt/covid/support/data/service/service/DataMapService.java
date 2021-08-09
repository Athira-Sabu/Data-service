package com.govt.covid.support.data.service.service;

import com.govt.covid.support.data.service.entity.InfectionDetails;
import com.govt.covid.support.data.service.entity.TestingDetails;
import com.govt.covid.support.data.service.entity.VaccineDetails;
import com.govt.covid.support.data.service.repo.InfectionDetailsRepo;
import com.govt.covid.support.data.service.repo.TestingDetailsRepo;
import com.govt.covid.support.data.service.repo.VaccineDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataMapService {
    @Autowired
    private InfectionDetailsRepo infectionDetailsRepo;

    @Autowired
    private TestingDetailsRepo testingDetailsRepo;

    @Autowired
    private VaccineDetailsRepo vaccineDetailsRepo;

    public void saveData(List<InfectionDetails> infectionDetails, List<VaccineDetails> vaccineDetails,
                    List<TestingDetails> testDetails) {
        infectionDetailsRepo.saveAll(infectionDetails);
        testingDetailsRepo.saveAll(testDetails);
        vaccineDetailsRepo.saveAll(vaccineDetails);
    }
}
