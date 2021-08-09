package com.govt.covid.support.data.service;

import com.govt.covid.support.data.service.entity.InfectionDetails;
import com.govt.covid.support.data.service.entity.TestingDetails;
import com.govt.covid.support.data.service.entity.VaccineDetails;
import com.govt.covid.support.data.service.service.DataMapService;
import com.govt.covid.support.data.service.util.CSVHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class DataServiceApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DataServiceApplication.class, args);
		List<InfectionDetails> infectionDetails = CSVHelper.getInfectionDetails();
		List<VaccineDetails> vaccineDetails = CSVHelper.getVaccineDetails();
		List<TestingDetails> testDetails = CSVHelper.getTestDetails();
		DataMapService dataMapService = ctx.getBean(DataMapService.class);
		dataMapService.saveData(infectionDetails,vaccineDetails,testDetails);
	}

}
