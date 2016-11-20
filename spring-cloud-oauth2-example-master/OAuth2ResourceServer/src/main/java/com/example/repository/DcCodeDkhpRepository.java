package com.example.repository;


import com.example.domain.DcCodeDkhpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Olexandr Shevchenko
 * @version 1.0
 */

@Repository
public interface DcCodeDkhpRepository extends JpaRepository<DcCodeDkhpEntity, Integer> {

}