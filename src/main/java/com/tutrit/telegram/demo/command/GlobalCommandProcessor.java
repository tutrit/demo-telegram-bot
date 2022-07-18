package com.tutrit.telegram.demo.command;
import org.springframework.stereotype.Service;

import static com.tutrit.telegram.TelegramDemoBotApp.LOGGER;

@Service
public class GlobalCommandProcessor {

    public boolean processStart() {
        LOGGER.info("processing start");
        return true;
    }

    public boolean processHelp() {
        LOGGER.info("processing help");
        return true;
    }

    public boolean processSettings() {
        LOGGER.info("processing settings");
        return true;
    }
}
