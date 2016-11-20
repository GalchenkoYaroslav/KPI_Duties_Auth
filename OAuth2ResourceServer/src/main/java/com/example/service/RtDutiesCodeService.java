package com.example.service;



import com.example.domain.RtCodeEntity;
import com.example.domain.RtDutiesCodeEntity;

import java.util.List;

/**
 * @author Olexandr Shevchenko
 * @version 1.0
 * @since 01.09.2016
 */

public interface RtDutiesCodeService extends BaseService<RtDutiesCodeEntity> {

     List<RtDutiesCodeEntity> add(Integer rtDutiesId, List<RtCodeEntity> rtCodeEntities);

     List<RtDutiesCodeEntity> update(Integer rtDutiesId, List<RtCodeEntity> rtCodeEntities);
}
