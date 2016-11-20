package com.example.service.impl;


import com.example.domain.RtDutiesEntity;
import com.example.repository.dao.RtDutiesDao;
import com.example.service.RtDutiesService;
import com.example.service.utils.converters.occupation.OccupationConverter;
import com.example.shared.dto.occupation.OccupationGetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Olexandr Shevchenko
 * @version 1.0
 */

@Service
public class RtDutiesServiceImpl extends BaseServiceImpl<RtDutiesEntity> implements RtDutiesService {

    @Autowired
    RtDutiesDao dao;

    @Autowired
    OccupationConverter converter;


    @Override
    @Transactional(readOnly = true)
    public List<RtDutiesEntity> getByParams(OccupationGetDto dto) {
        List<RtDutiesEntity> occupations = dao.findByFields(converter.toParamMapFromOccupationGetDto(dto));

        return occupations;
    }
}