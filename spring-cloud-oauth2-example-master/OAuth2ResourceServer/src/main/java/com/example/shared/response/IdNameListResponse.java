package com.example.shared.response;

import com.example.shared.response.support.IdNameResponse;

import java.util.List;

/**
 * @author Olexandr Shevchenko
 * @version 1.0
 * @since 24.08.2016
 */

public class IdNameListResponse {

    List<IdNameResponse> idNameResponses;

    public List<IdNameResponse> getIdNameResponses() {
        return idNameResponses;
    }

    public void setIdNameResponses(List<IdNameResponse> idNameResponses) {
        this.idNameResponses = idNameResponses;
    }
}
