package com.tutrit.telegram.demo.keyboard;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KeyboardUtil {
    private KeyboardUtil() {

    }

    public static ReplyKeyboardMarkup oneRow(String... buttons) {
        ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup();
        KeyboardRow row = new KeyboardRow();
        row.addAll(Arrays.stream(buttons).toList());
        keyboard.setKeyboard(List.of(row));
        return keyboard;
    }

    public static ReplyKeyboardMarkup oneColumn(String... buttons) {
        ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup();
        keyboard.setKeyboard(Arrays.stream(buttons)
                .map(button -> {
                    KeyboardRow row = new KeyboardRow();
                    row.add(button);
                    return row;
                }).collect(Collectors.toList()));
        return keyboard;
    }

    public static ReplyKeyboardMarkup twoColumns(String... buttons) {
        List<KeyboardRow> rows = new ArrayList<>();
        for (int i = 0; i < buttons.length; i += 2) {
            KeyboardRow row = new KeyboardRow();
            String[] names = {buttons[i], buttons[i + 1]};
            Arrays.stream(names).forEach(row::add);
            rows.add(row);
        }
        ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup();
        keyboard.setKeyboard(rows);
        return keyboard;
    }

    public static ReplyKeyboardMarkup nColumns(int columnsNumber, String... buttons) {
        List<KeyboardRow> rows = new ArrayList<>();
        for (int i = 0; i < buttons.length; i += columnsNumber) {
            KeyboardRow row = new KeyboardRow();
            int iterator = 0;
            while (columnsNumber > iterator) {
                row.add(buttons[i + iterator]);
                iterator++;
            }
            rows.add(row);
        }
        ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup();
        keyboard.setKeyboard(rows);
        return keyboard;
    }

    public static ReplyKeyboardMarkup oneRow(KeyboardButton... buttons) {
        ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup();
        KeyboardRow row = new KeyboardRow();
        row.addAll(Arrays.stream(buttons).toList());
        keyboard.setKeyboard(List.of(row));
        return keyboard;
    }

    public static ReplyKeyboardMarkup oneColumn(KeyboardButton... buttons) {
        ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup();
        keyboard.setKeyboard(Arrays.stream(buttons)
                .map(button -> {
                    KeyboardRow row = new KeyboardRow();
                    row.add(button);
                    return row;
                }).collect(Collectors.toList()));
        return keyboard;
    }

    public static ReplyKeyboardMarkup twoColumns(KeyboardButton... buttons) {
        List<KeyboardRow> rows = new ArrayList<>();
        for (int i = 0; i < buttons.length; i += 2) {
            KeyboardRow row = new KeyboardRow();
            KeyboardButton[] names = {buttons[i], buttons[i + 1]};
            Arrays.stream(names).forEach(row::add);
            rows.add(row);
        }
        ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup();
        keyboard.setKeyboard(rows);
        return keyboard;
    }

    public static ReplyKeyboardMarkup nColumns(int columnsNumber, KeyboardButton... buttons) {
        List<KeyboardRow> rows = new ArrayList<>();
        for (int i = 0; i < buttons.length; i += columnsNumber) {
            KeyboardRow row = new KeyboardRow();
            int iterator = 0;
            while (columnsNumber > iterator) {
                row.add(buttons[i + iterator]);
                iterator++;
            }
            rows.add(row);
        }
        ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup();
        keyboard.setKeyboard(rows);
        return keyboard;
    }

    public static InlineKeyboardMarkup oneRow(InlineKeyboardButton... buttons) {
        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
        keyboard.setKeyboard(List.of(List.of(buttons)));
        return keyboard;
    }

    public static InlineKeyboardMarkup oneColumn(InlineKeyboardButton... buttons) {
        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
        keyboard.setKeyboard(Arrays.stream(buttons)
                .map(button -> List.of(button))
                .collect(Collectors.toList()));
        return keyboard;
    }

    public static InlineKeyboardMarkup twoColumns(InlineKeyboardButton... buttons) {
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        for (int i = 0; i < buttons.length; i += 2) {
            List<InlineKeyboardButton> row = new ArrayList<>();
            InlineKeyboardButton[] buttonsForRow = {buttons[i], buttons[i + 1]};
            Arrays.stream(buttonsForRow).forEach(row::add);
            rows.add(row);
        }
        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
        keyboard.setKeyboard(rows);
        return keyboard;
    }

    public static InlineKeyboardMarkup nColumns(int columnsNumber, InlineKeyboardButton... buttons) {
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        for (int i = 0; i < buttons.length; i += columnsNumber) {
            List<InlineKeyboardButton> row = new ArrayList<>();
            int iterator = 0;
            while (columnsNumber > iterator) {
                row.add(buttons[i + iterator]);
                iterator++;
            }
            rows.add(row);
        }
        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
        keyboard.setKeyboard(rows);
        return keyboard;
    }

    public static InlineKeyboardButton newInlineButton(String text, String callback) {
        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setText(text);
        inlineKeyboardButton.setCallbackData(callback);
        return inlineKeyboardButton;
    }
}
