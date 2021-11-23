package com.example.ReadingIsGood.Utils;

import org.apache.logging.log4j.LogManager;

import com.fasterxml.jackson.databind.ObjectMapper;

public interface JsonFormat {

    default String toJson() {
        String response = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            response = mapper.writeValueAsString(this);
        } catch (Exception e) {
            LogManager.getLogger(this.getClass()).error(e);
        }
        return response;
    }

}
