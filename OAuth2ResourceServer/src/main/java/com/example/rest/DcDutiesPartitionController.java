package com.example.rest;


import com.example.domain.DcDutiesPartitionEntity;
import com.example.service.DcDutiesPartitionService;
import com.example.service.utils.converters.idname.IdNameConverter;
import com.example.shared.request.NewValueRequest;
import com.example.shared.response.IdNameListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author Olexandr Shevchenko
 * @version 1.0
 * @since 12.09.2016
 */

@Path("/partition")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Component
public class DcDutiesPartitionController {

    @Autowired
    private DcDutiesPartitionService dcDutiesPartitionEntityService;

    @Autowired
    private IdNameConverter idNameConverter;

    @POST
    public Response add(@NotNull NewValueRequest request){

        DcDutiesPartitionEntity entity = new DcDutiesPartitionEntity();
        entity.setName(request.getNewVal());

        dcDutiesPartitionEntityService.add(entity);

        return Response.ok().entity(entity).build();
    }

    @GET
    public Response getAll() {

        List<DcDutiesPartitionEntity> all = dcDutiesPartitionEntityService.getAll();
        IdNameListResponse response = idNameConverter.toIdNameListResponseFromEntityList(all);

        return Response.ok(response).build();
    }
}
