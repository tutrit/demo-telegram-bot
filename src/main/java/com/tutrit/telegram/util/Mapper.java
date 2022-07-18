package com.tutrit.telegram.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class Mapper {
    public static final ObjectMapper MAPPER;
    private static final Logger LOGGER;

    static {
        MAPPER = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        LOGGER = LoggerFactory.getLogger(Mapper.class);
    }

    static void writeValue(File resultFile, Object value) {
        try {
            MAPPER.writeValue(resultFile, value);
        } catch (Exception e) {
            LOGGER.error("Cannot save file: {}", e.getMessage(), e);
        }
    }
}
