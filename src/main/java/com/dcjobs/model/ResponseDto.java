package com.dcjobs.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {

    private static final long serialVersionUID = 2L;
    private Object data;
    private String message;
    private boolean isSuccess;
    private int httpStatus;

    public ResponseDto(Object data, String message, boolean isSuccess, int httpStatus) {
        this.data = data;
        this.message = message;
        this.isSuccess = isSuccess;
        this.httpStatus = httpStatus;
    }

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String errorCode;
    private long timestamp = new Timestamp(System.currentTimeMillis()).getTime();



}
