package com.example.repository.dao.impl;


import com.example.domain.RtDutiesEntity;
import com.example.repository.RtDutiesRepository;
import com.example.repository.dao.RtDutiesDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Olexandr Shevchenko
 * @version 1.0
 * @since 04.09.2016
 */

@Repository
public class RtDutiesDaoImpl implements RtDutiesDao {

    @Autowired
    RtDutiesRepository repository;

    @Autowired
    HibernateTemplate hibernateTemplate;

    @Override
    @Transactional(readOnly = true)
    public List<RtDutiesEntity> findByFields(Map<String, Object> paramsMap) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(RtDutiesEntity.class, "rtDuties");
        Criteria criteriaForDatesInState = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(RtDutiesEntity.class, "rtDuties");
        Criteria criteriaForDatesInKpi = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(RtDutiesEntity.class, "rtDuties");
        criteria.createAlias("rtDuties.dutiesValidityDateEntities", "dates");
        criteriaForDatesInState.createAlias("rtDuties.dutiesValidityDateEntities", "dates");
        criteriaForDatesInKpi.createAlias("rtDuties.dutiesValidityDateEntities", "dates");
        if (paramsMap == null || paramsMap.isEmpty()) {
            return repository.findAll();
        } else {
            for (String paramName : paramsMap.keySet()) {
                Object value = paramsMap.get(paramName);
                if (value != null) {
                    switch (paramName) {
                        case "rtDutiesName":
                            if (paramsMap.get("searchType").equals("MATCH_STRING")) {
                                criteria.add(Restrictions.ilike("name", (String) value, MatchMode.EXACT));
                            }
                            if (paramsMap.get("searchType").equals("CONTAINS_STRING")) {
                                criteria.add(Restrictions.ilike("name", (String) value, MatchMode.ANYWHERE));
                            }
                            break;
                        case "dcDutiesPartitionId":
                            criteria.add(Restrictions.in("dcDutiesPartitionId", (ArrayList) value));
                            break;
                        case "dcDutiesNames":
                            //OR LIKE
                            if (paramsMap.get("searchType").equals("SOME_TAGS")) {
                                Disjunction disjunction = Restrictions.disjunction();
                                for (String keyword : (List<String>) paramsMap.get(paramName)) {
                                    disjunction.add(Restrictions.ilike("name", keyword, MatchMode.ANYWHERE));
                                }
                                criteria.add(disjunction);
                            }
                            //AND LIKE
                            if (paramsMap.get("searchType").equals("ALL_TAGS")) {
                                Conjunction conjunction = Restrictions.conjunction();
                                for (String keyword : (List<String>) paramsMap.get(paramName)) {
                                    conjunction.add(Restrictions.ilike("name", keyword, MatchMode.ANYWHERE));
                                }
                                criteria.add(conjunction);
                            }
                            break;
                        case "startFrom":
                            criteria.add(Restrictions.ge("dates.start", value));
                            break;
                        case "startTo":
                            criteria.add(Restrictions.le("dates.start", value));
                            break;
                        case "stopFrom":
                            criteria.add(Restrictions.ge("dates.stop", value));
                            break;
                        case "stopTo":
                            criteria.add(Restrictions.le("dates.stop", value));
                            break;

                        /*case "offset":
                            offset = (Integer) value;
                            break;
                        case "limit":
                            limit = (Integer) value;
                            break;*/
                    }
                }
            }

           /* if (offset > 0) {
                criteria.setFirstResult(offset);
            }
            if (limit >= 0) {
                criteria.setMaxResults(limit);
            }*/
        }
        /*Так як приналежність до КПІ відноситься до дат, то потрібно перевірити щоб всі дати посади
        відповідали критеріям пошуку*/
        criteriaForDatesInKpi.add(Restrictions.eq("dates.isInKpi", true)); //Знаходжу посади, які містять дату З приналежністю до КПІ
        criteriaForDatesInState.add(Restrictions.eq("dates.isInKpi", false)); //Знаходжу посади, які містять дату БЕЗ приналежності до КПІ
        List listByKpi = null;
        List listTemp;
        if (paramsMap.get("inKpi") != null) {
            switch ((String)paramsMap.get("inKpi")){
                case "ONLY_IN_KPI" :
                    listByKpi = criteriaForDatesInKpi.list();
                    listTemp = criteriaForDatesInState.list();
                    if (!listTemp.isEmpty()) {
                        listByKpi.removeAll(listTemp);  //Видаляю посади, які містять дати БЕЗ приналежності до КПІ
                    }
                    break;
                case "ONLY_IN_STATE" :
                    listByKpi = criteriaForDatesInState.list();
                    listTemp = criteriaForDatesInKpi.list();
                    if (!listTemp.isEmpty()) {
                        listByKpi.removeAll(listTemp); //Видаляю посади, які містять дати З приналежністю до КПІ
                    }
                    break;
            }
        }

        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

        List result = criteria.list();
        if (listByKpi != null) {
            result.retainAll(listByKpi); //Знаходжу перетин посад знайдених по параметрах пошуку і посад, які знайдені по умові належності/неналежності до КПІ
        }

        return result;
    }
}
