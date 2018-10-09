package com.vn.osp.notarialservices.common.error;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.util.List;
/**
 * Created by longtran on 19/10/2016.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResource {
    private final String code;
    private final String message;
    private List<FieldErrorResource> fieldErrors;

    public ErrorResource(final String code, final String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<FieldErrorResource> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<FieldErrorResource> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}