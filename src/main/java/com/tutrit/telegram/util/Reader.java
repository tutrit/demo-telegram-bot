package com.tutrit.telegram.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.nio.file.Files;
import java.nio.file.Path;

import static com.tutrit.telegram.TelegramDemoBotApp.LOGGER;

public class Reader {
    private Reader() {
    }

    public Update readJsonResourceFile(String path) {
        try {
            Resource jsonResource = new ClassPathResource(path, Reader.class.getClass().getClassLoader());

            Path pathToJson = jsonResource.getFile().toPath();
            String update = new String(Files.readAllBytes(pathToJson));
            return new ObjectMapper().readValue(update, Update.class);
        } catch (Exception e) {
            LOGGER.error("Error reading {}", path, e);
            throw new RuntimeException(e);
        }
    }
}
