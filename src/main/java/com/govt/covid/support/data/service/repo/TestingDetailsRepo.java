package com.govt.covid.support.data.service.repo;

import com.govt.covid.support.data.service.entity.InfectionDetails;
import com.govt.covid.support.data.service.entity.TestingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TestingDetailsRepo extends JpaRepository<TestingDetails, Long> {
    List<TestingDetails> findAllByDate(Date date);
    List<TestingDetails> findAllByState(String state);
    List<TestingDetails> findAllByStateAndDate(String state, Date date);
}
