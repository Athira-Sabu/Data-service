package com.govt.covid.support.data.service.util;

import com.govt.covid.support.data.service.entity.InfectionDetails;
import com.govt.covid.support.data.service.entity.TestingDetails;
import com.govt.covid.support.data.service.entity.VaccineDetails;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class CSVHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERS_INFECTED_DETAILS = { "Sno", "Date", "Time",
            "State/UnionTerritory","ConfirmedIndianNational",
            "ConfirmedForeignNational","Cured", "Deaths","Confirmed" };


    public static List<InfectionDetails> getInfectionDetails() {
        try (Reader in = new FileReader(ResourceUtils.getFile("classpath:covid_19_india.csv"));
             CSVParser csvParser = new CSVParser(in,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader()
                             .withIgnoreHeaderCase().withTrim());) {

            List<InfectionDetails> infectionDetailsList = new ArrayList<InfectionDetails>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                System.out.println(csvRecord.toString());
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

        try (Reader in = new FileReader(ResourceUtils.getFile("classpath:statelist.csv"));
             CSVParser csvParser = new CSVParser(in,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader()
                             .withIgnoreHeaderCase().withTrim())) {

            List<TestingDetails> testingDetailsList = new ArrayList<TestingDetails>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                System.out.println(csvRecord.toString());
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

        try (Reader in = new FileReader(ResourceUtils.getFile("classpath:list.csv"));
             CSVParser csvParser = new CSVParser(in,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader()
                             .withIgnoreHeaderCase().withTrim());) {

            List<VaccineDetails> vaccineDetailsList = new ArrayList<VaccineDetails>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                System.out.println(csvRecord.toString());
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
