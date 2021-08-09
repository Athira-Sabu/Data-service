package com.govt.covid.support.data.service.util;

import com.govt.covid.support.data.service.entity.InfectionDetails;
import com.govt.covid.support.data.service.entity.TestingDetails;
import com.govt.covid.support.data.service.entity.VaccineDetails;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Component
public class CSVHelper {

    public static List<InfectionDetails> getInfectionDetails() {
        try{
            InputStream in = new ClassPathResource("covid_19_india.csv").getInputStream();
            List<InfectionDetails> infectionDetailsList;
            Iterable<CSVRecord> csvRecords;
            try (CSVParser csvParser = CSVParser.parse(in, Charset.defaultCharset(),
                    CSVFormat.DEFAULT.withFirstRecordAsHeader()
                            .withIgnoreHeaderCase().withTrim())) {

                infectionDetailsList = new ArrayList<InfectionDetails>();

                csvRecords = csvParser.getRecords();
            }

            for (CSVRecord csvRecord : csvRecords) {
                InfectionDetails infectionDetails = new InfectionDetails(
                  Integer.parseInt(csvRecord.get(0)), dateConverter(csvRecord.get(1)),
                        csvRecord.get(2),
                        csvRecord.get(3),csvRecord.get(4),
                        csvRecord.get(5), csvRecord.get(6),
                        csvRecord.get(7), csvRecord.get(8));

                infectionDetailsList.add(infectionDetails);
            }

            return infectionDetailsList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static List<TestingDetails> getTestDetails() {
        try{
            ClassPathResource res = new ClassPathResource("statelist.csv");
            File file = res.getFile();
            Reader in = new FileReader(file);

            List<TestingDetails> testingDetailsList;
            Iterable<CSVRecord> csvRecords;
            try (CSVParser csvParser = new CSVParser(in,
                    CSVFormat.DEFAULT.withFirstRecordAsHeader()
                            .withIgnoreHeaderCase().withTrim())) {

                testingDetailsList = new ArrayList<TestingDetails>();

                csvRecords = csvParser.getRecords();
            }

            for (CSVRecord csvRecord : csvRecords) {
                 TestingDetails infectionDetails = new TestingDetails(
                        dateConverter(csvRecord.get(0)),
                        csvRecord.get(1),
                        csvRecord.get(2),csvRecord.get(3),
                        csvRecord.get(4));

                testingDetailsList.add(infectionDetails);
            }

            return testingDetailsList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static List<VaccineDetails> getVaccineDetails() {
        try{
            ClassPathResource res = new ClassPathResource("list.csv");
            File file = res.getFile();
            Reader in = new FileReader(file);

            List<VaccineDetails> vaccineDetailsList;
            Iterable<CSVRecord> csvRecords;
            try (CSVParser csvParser = new CSVParser(in,
                    CSVFormat.DEFAULT.withFirstRecordAsHeader()
                            .withIgnoreHeaderCase().withTrim())) {

                vaccineDetailsList = new ArrayList<VaccineDetails>();

                csvRecords = csvParser.getRecords();
            }

            for (CSVRecord csvRecord : csvRecords) {
                VaccineDetails vaccineDetails = new VaccineDetails(
                        dateConverterWith(csvRecord.get(0)),
                        csvRecord.get(1),
                        csvRecord.get(2),csvRecord.get(3),
                        csvRecord.get(4),
                        csvRecord.get(5), csvRecord.get(6), csvRecord.get(7));

                vaccineDetailsList.add(vaccineDetails);
            }

            return vaccineDetailsList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
    private static Date dateConverter(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format");
        }
    }

    private static Date dateConverterWith(String date) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format");
        }
    }
}
