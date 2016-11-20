package com.example.service.impl;//package com.example.service.impl;


import com.example.domain.Employees2;
import com.example.domain.Passports;
import com.example.repository.EmployeeRepository;
import com.example.repository.PermissionsRepository;
import com.example.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by Yaroslav on 31.10.2016.
 */
@Service
public class DetailServiceImpl  implements DetailService {

    @Autowired
    private PermissionsRepository permissionsRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Passports getPassportsByName(String name) {

        return permissionsRepository.getPassportsByName(name);
    }

    @Override
    public Employees2 getEmployeeByName(String username) {
        return employeeRepository.getEmployeeByName(username);
    }

    @Override
    public Passports add(Passports entity) {
        return null;
    }

    @Override
    public List<Passports> add(List<Passports> entity) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void delete(List<Passports> entity) {

    }

    @Override
    public Passports update(Passports entity) {
        return null;
    }

    @Override
    public List<Passports> update(List<Passports> entity) {
        return null;
    }

    @Override
    public Passports getById(Integer id) {
        return null;
    }

    @Override
    public List<Passports> getAll() {
        return null;
    }
}