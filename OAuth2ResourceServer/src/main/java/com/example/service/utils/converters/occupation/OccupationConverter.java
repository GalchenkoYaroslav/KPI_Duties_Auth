package com.example.service.utils.converters.occupation;


import com.example.domain.*;
import com.example.shared.dto.occupation.OccupationGetDto;
import com.example.shared.request.occupation.OccupationGetRequest;
import com.example.shared.request.occupation.OccupationRequest;
import com.example.shared.response.occupation.OccupationsGetResponse;

import java.util.List;
import java.util.Map;

/**
 * @author Olexandr Shevchenko
 * @version 1.0
 * @since 01.09.2016
 */

public interface OccupationConverter {

    RtDutiesEntity toRtDutiesEntityFromOccupationRequest(OccupationRequest occupationRequest, Integer id);

    List<DutiesValidityDateEntity> toDutiesValidityDateEntityListFromOccupationRequest(OccupationRequest request, Integer rtDutiesId);

    List<RtCodeEntity> toRtCodeEntityListFromOccupationRequest(OccupationRequest request, Integer rtDutiesId);

    List<RtDutiesTaskAndResponsibilitiesEntity> toRtDutiesTaskAndResponsibilitiesEntityListFromOccupationRequest(OccupationRequest request, Integer rtDutiesId);

    List<RtDutiesMustKnowEntity> toRtDutiesMustKnowEntityListFromOccupationRequest(OccupationRequest request, Integer rtDutiesId);

    List<RtDutiesQualificationRequirementsEntity> toRtDutiesQualificationRequirementsEntityListFromOccupationRequest(OccupationRequest request, Integer rtDutiesId);

    OccupationGetDto toOccupationDtoFromOccupationGetRequest(OccupationGetRequest request);

    Map<String, Object> toParamMapFromOccupationGetDto(OccupationGetDto dto);

   OccupationsGetResponse toOccupationsGetResponseFromRtDutiesEntityList(List<RtDutiesEntity> list);
}
