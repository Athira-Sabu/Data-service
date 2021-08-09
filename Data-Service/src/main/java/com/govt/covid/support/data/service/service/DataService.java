package com.govt.covid.support.data.service.service;

import com.govt.covid.support.data.service.domain.Response;
import com.govt.covid.support.data.service.entity.InfectionDetails;
import com.govt.covid.support.data.service.entity.TestingDetails;
import com.govt.covid.support.data.service.entity.VaccineDetails;
import com.govt.covid.support.data.service.repo.InfectionDetailsRepo;
import com.govt.covid.support.data.service.repo.TestingDetailsRepo;
import com.govt.covid.support.data.service.repo.VaccineDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DataService {

    @Autowired
    private InfectionDetailsRepo infectionDetailsRepo;

    @Autowired
    private TestingDetailsRepo testingDetailsRepo;

    @Autowired
    private VaccineDetailsRepo vaccineDetailsRepo;

    public String getDetailsBasedOnDate(Date date) {
     List<InfectionDetails> infectionDetailsList = infectionDetailsRepo.findAllByDate(date);
     List<TestingDetails> testingDetails = testingDetailsRepo.findAllByDate(date);
     List<VaccineDetails> vaccineDetails = vaccineDetailsRepo.findAllByUpdatedOn(date);
        Response response = new Response();
        response.setInfectionDetails(!infectionDetailsList.isEmpty()? infectionDetailsList: null);
        response.setTestingDetails(!testingDetails.isEmpty()? testingDetails: null);
        response.setVaccineDetails(!vaccineDetails.isEmpty()? vaccineDetails: null);
        return response.toString();
    }

    public String getDetailsBasedOnState(String state) {
        List<InfectionDetails> infectionDetailsList = infectionDetailsRepo.findAllByState(state);
        List<TestingDetails> testingDetails = testingDetailsRepo.findAllByState(state);
        List<VaccineDetails> vaccineDetails = vaccineDetailsRepo.findAllByState(state);
        Response response = new Response();
        if(!infectionDetailsList.isEmpty()) {
          infectionDetailsList.sort((o1,o2) -> o1.getDate().compareTo(o2.getDate()));
          response.setInfectionDetails(infectionDetailsList);
        }
        if(!testingDetails .isEmpty()) {
            testingDetails.sort((o1,o2) -> o1.getDate().compareTo(o2.getDate()));
            response.setTestingDetails(testingDetails);
        }
        if(!vaccineDetails.isEmpty()) {
            vaccineDetails.sort((o1,o2) -> o1.getUpdatedOn().compareTo(o2.getUpdatedOn()));
            response.setVaccineDetails(vaccineDetails);
        }

        return response.toString();
    }

    public String getDetailsBasedOnDateAndState(String state, Date date) {
        List<InfectionDetails> infectionDetailsList = infectionDetailsRepo.findAllByStateAndDate(state,date);
        List<TestingDetails> testingDetails = testingDetailsRepo.findAllByStateAndDate(state,date);
        List<VaccineDetails> vaccineDetails = vaccineDetailsRepo.findAllByStateAndUpdatedOn(state, date);
        Response response = new Response();
        response.setInfectionDetails(!infectionDetailsList.isEmpty()? infectionDetailsList: null);
        response.setTestingDetails(!testingDetails.isEmpty()? testingDetails: null);
        response.setVaccineDetails(!vaccineDetails.isEmpty()? vaccineDetails: null);
        return response.toString();
    }
}
