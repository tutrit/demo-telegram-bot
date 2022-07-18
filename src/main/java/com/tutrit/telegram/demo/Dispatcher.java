package com.tutrit.telegram.demo;

import com.tutrit.telegram.demo.command.GlobalCommandProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.tutrit.telegram.demo.command.GlobalCommands.*;
import static com.tutrit.telegram.util.UpdateUtil.extractCommand;
import static com.tutrit.telegram.util.UpdateUtil.removeBotNameFromCommand;

@Service
public class Dispatcher {
    @Value("${bot.username}")
    private String botUsername;

    private final GlobalCommandProcessor globalCommandProcessor;

    public Dispatcher(final GlobalCommandProcessor globalCommandProcessor) {
        this.globalCommandProcessor = globalCommandProcessor;
    }

    public boolean dispatch(Update update) {
        String dirtyCommand = extractCommand(update).get();
        String command = removeBotNameFromCommand(dirtyCommand, botUsername);
        if (START.getCommand().equals(command)) {
            return globalCommandProcessor.processStart();
        } else if (HELP.getCommand().equals(command)) {
            return globalCommandProcessor.processHelp();
        } else if (SETTINGS.getCommand().equals(command)) {
            return globalCommandProcessor.processSettings();
        }
        return false;
    }
}
