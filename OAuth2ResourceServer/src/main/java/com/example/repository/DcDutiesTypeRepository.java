package com.example.repository;


import com.example.domain.DcDutiesTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Olexandr Shevchenko
 * @version 1.0
 */

@Repository
public interface DcDutiesTypeRepository extends JpaRepository<DcDutiesTypeEntity, Integer> {

}