package com.tutrit.telegram.util;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.File;

import static com.tutrit.telegram.util.Mapper.writeValue;

public class Saver {

    private Saver() {
    }

    public static void saveAsJson(Update update) {
        writeValue(new File("demoTgBot/src/test/resources/last_update.json"), update);
    }
}
