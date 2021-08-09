package com.govt.covid.support.data.service.repo;

import com.govt.covid.support.data.service.entity.InfectionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

@Repository
public interface InfectionDetailsRepo extends JpaRepository<InfectionDetails, Integer> {
    List<InfectionDetails> findAllByDate(Date date);
    List<InfectionDetails> findAllByState(String state);
    List<InfectionDetails> findAllByStateAndDate(String state, Date date);
}
