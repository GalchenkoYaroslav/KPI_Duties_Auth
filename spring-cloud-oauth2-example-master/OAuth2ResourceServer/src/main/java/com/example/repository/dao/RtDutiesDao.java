package com.example.repository.dao;


import com.example.domain.RtDutiesEntity;

import java.util.List;
import java.util.Map;

/**
 * @author Olexandr Shevchenko
 * @version 1.0
 * @since 04.09.2016
 */

public interface RtDutiesDao {

    List<RtDutiesEntity> findByFields(Map<String, Object> paramsMap);
}
