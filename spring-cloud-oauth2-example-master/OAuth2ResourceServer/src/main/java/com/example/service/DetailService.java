package com.example.service;


import com.example.domain.Employees2;
import com.example.domain.Passports;

/**
 * Created by Yaroslav on 31.10.2016.
 */
public interface DetailService extends BaseService<Passports> {

     Employees2 getEmployeeByName(String username);

     Passports getPassportsByName(String name);
}
