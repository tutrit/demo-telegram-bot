package com.tutrit.telegram.demo.command;

import com.tutrit.telegram.demo.Dispatcher;
import com.tutrit.telegram.util.UpdateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.telegram.telegrambots.meta.api.objects.Update;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://core.telegram.org/bots#commands
 * Bot should process global commands
 */
@SpringBootTest
class GlobalCommandProcessorTest {
    @Autowired
    Dispatcher dispatcher;
    @Value("${bot.username}")
    private String botUsername;

    @Test
    void processStart() {
        Update update = UpdateUtil.readUpdateJsonResourceFile("demo/command/start.json");
        assertTrue(dispatcher.dispatch(update));
    }

    @Test
    void processHelp() {
        Update update = UpdateUtil.readUpdateJsonResourceFile("demo/command/help.json");
        assertTrue(dispatcher.dispatch(update));
    }

    @Test
    void processSettings() {
        Update update = UpdateUtil.readUpdateJsonResourceFile("demo/command/settings.json");
        assertTrue(dispatcher.dispatch(update));
    }

    @Test
    void processStartWithBotName() {
        Update update = UpdateUtil.readUpdateJsonResourceFile("demo/command/start@bot_name.json");
        assertTrue(dispatcher.dispatch(update));
    }

    @Test
    void processHelpWithBotName() {
        Update update = UpdateUtil.readUpdateJsonResourceFile("demo/command/help@bot_name.json");
        assertTrue(dispatcher.dispatch(update));
    }

    @Test
    void processSettingsWithBotName() {
        Update update = UpdateUtil.readUpdateJsonResourceFile("demo/command/settings@bot_name.json");
        assertTrue(dispatcher.dispatch(update));
    }
}
