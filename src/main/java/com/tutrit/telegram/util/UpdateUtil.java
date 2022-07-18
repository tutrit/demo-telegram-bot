package com.tutrit.telegram.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import static com.tutrit.telegram.TelegramDemoBotApp.LOGGER;

public class UpdateUtil {

    public static Optional<String> extractChatId(Update update) {
        try {
            return Optional.of(update.getMessage().getChatId().toString());
        } catch (Exception e) {
            LOGGER.error("Cannot extract chat id", e);
            return Optional.empty();
        }
    }

    public static Optional<Boolean> isPrivateChat(Update update) {
        try {
            return Optional.of(update.getMessage().getChat().getType().equals("private"));
        } catch (Exception e) {
            LOGGER.error("Cannot extract chat type", e);
            return Optional.empty();
        }
    }

    public static Update readUpdateJsonResourceFile(String path) {
        try {
            String update = readResourceFile(path);
            return new ObjectMapper().readValue(update, Update.class);
        } catch (Exception e) {
            LOGGER.error("Error reading {}", path, e);
            throw new RuntimeException(e);
        }
    }

    public static Optional<String> extractCommand(Update update) {
        try {
            MessageEntity messageEntity = update.getMessage().getEntities().get(0);
            if (messageEntity.getType().equals("bot_command")) {
                return Optional.of(messageEntity.getText());
            }
        } catch (Exception e) {
            LOGGER.error("Cannot process update as bot command {}", update, e);
        }
        return Optional.empty();
    }

    public static String removeBotNameFromCommand(String command, String botName) {
        if (command.contains("@"+botName)) {
            return command.replace("@"+botName, "");
        }
        return command;
    }

    public static String readResourceFile(String path) {
        try {
            Resource jsonResource = new ClassPathResource(path, UpdateUtil.class.getClass().getClassLoader());

            Path pathToJson = jsonResource.getFile().toPath();
            return new String(Files.readAllBytes(pathToJson));
        } catch (Exception e) {
            LOGGER.error("Error reading {}", path, e);
            throw new RuntimeException(e);
        }
    }
}
