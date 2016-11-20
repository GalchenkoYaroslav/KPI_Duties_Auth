package com.example.service.impl;


import com.example.domain.RtCodeEntity;
import com.example.domain.RtDutiesCodeEntity;
import com.example.repository.RtDutiesCodeRepository;
import com.example.service.RtDutiesCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Olexandr Shevchenko
 * @version 1.0
 * @since 01.09.2016
 */

@Service
public class RtDutiesCodeServiceImpl extends BaseServiceImpl<RtDutiesCodeEntity> implements RtDutiesCodeService {

    @Autowired
    RtDutiesCodeRepository repository;

    @Override
    @Transactional
    public List<RtDutiesCodeEntity> add(Integer rtDutiesId, List<RtCodeEntity> rtCodeEntities) {

        List<RtDutiesCodeEntity> list = new ArrayList<>();
        for (RtCodeEntity rtCodeEntity : rtCodeEntities) {
            RtDutiesCodeEntity entity = new RtDutiesCodeEntity();

            entity.setRtCodeId(rtCodeEntity.getId());
            entity.setRtDutiesId(rtDutiesId);

            entity.setDateStart(rtCodeEntity.getDateStart());
            entity.setDateStop(rtCodeEntity.getDateStop());

            list.add(repository.saveAndFlush(entity));
        }
        return list;
    }

    @Override
    @Transactional
    public List<RtDutiesCodeEntity> update(Integer rtDutiesId, List<RtCodeEntity> rtCodeEntities) {
        List<RtDutiesCodeEntity> list = new ArrayList<>();
        for (RtCodeEntity rtCodeEntity : rtCodeEntities) {
            RtDutiesCodeEntity entity = new RtDutiesCodeEntity();

            entity.setRtCodeId(rtCodeEntity.getId());
            entity.setRtDutiesId(rtDutiesId);

            entity.setDateStart(rtCodeEntity.getDateStart());
            entity.setDateStop(rtCodeEntity.getDateStop());

            list.add(repository.saveAndFlush(entity));
        }
        return list;
    }
}
