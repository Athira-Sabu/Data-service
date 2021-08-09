package com.govt.covid.support.data.service.repo;

import com.govt.covid.support.data.service.entity.TestingDetails;
import com.govt.covid.support.data.service.entity.VaccineDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VaccineDetailsRepo extends JpaRepository<VaccineDetails, Long> {
    List<VaccineDetails> findAllByUpdatedOn(Date date);
    List<VaccineDetails> findAllByState(String state);
    List<VaccineDetails> findAllByStateAndUpdatedOn(String state, Date date);
}
