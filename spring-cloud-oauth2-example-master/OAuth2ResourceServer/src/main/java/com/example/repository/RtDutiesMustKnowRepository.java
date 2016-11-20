package com.example.repository;


import com.example.domain.RtDutiesMustKnowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Olexandr Shevchenko
 * @version 1.0
 */

@Repository
public interface RtDutiesMustKnowRepository extends JpaRepository<RtDutiesMustKnowEntity, Integer> {

}