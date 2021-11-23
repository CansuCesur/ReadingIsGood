package com.example.ReadingIsGood.Validation;

import com.example.ReadingIsGood.Utils.JsonFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class Error implements JsonFormat {

    @JsonProperty
    public List<Map<String, String>> errors;

    public Error(List<ErrorCode> code) {
        errors = new ArrayList<Map<String, String>>();

        for (ErrorCode e : code) {
            Map<String, String> item = new HashMap<String, String>();
            item.put("code", e.name());
            item.put("message", e.message());
            errors.add(item);
        }
    }

    public Error(ErrorCode code) {
        errors = new ArrayList<Map<String, String>>();
        Map<String, String> item = new HashMap<String, String>();
        item.put("code", code.name());
        item.put("message", code.message());
        errors.add(item);
    }

    public Error(String code, String message) {
        Map<String, String> item = new HashMap<String, String>();
        item.put("code", code);
        item.put("message", message);
        errors.add(item);
    }
}
