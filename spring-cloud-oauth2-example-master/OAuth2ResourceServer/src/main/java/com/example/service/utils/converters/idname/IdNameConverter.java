package com.example.service.utils.converters.idname;

import com.example.shared.response.IdNameListResponse;


import java.util.List;

/**
 * @author Olexandr Shevchenko
 * @version 1.0
 * @since 12.09.2016
 */

public interface IdNameConverter {

    IdNameListResponse toIdNameListResponseFromEntityList(List<? extends Object> list);
}
