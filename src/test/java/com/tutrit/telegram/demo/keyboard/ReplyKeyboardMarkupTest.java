package com.tutrit.telegram.demo.keyboard;

import com.tutrit.telegram.TelegramDemoBotAppTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;
import java.util.stream.Stream;

import static com.tutrit.telegram.demo.keyboard.KeyboardUtil.*;

@SpringBootTest
class ReplyKeyboardMarkupTest extends TelegramDemoBotAppTest {

    @Test
    public void straightforward() {
        ReplyKeyboardMarkup calculator = new ReplyKeyboardMarkup();

        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        KeyboardRow row3 = new KeyboardRow();
        KeyboardRow row4 = new KeyboardRow();

        Stream.of("0", ".", "=", "+").forEach(button -> row1.add(button));
        Stream.of("1", "2", "3", "-").forEach(button -> row2.add(button));
        Stream.of("4", "5", "6", "/").forEach(button -> row3.add(button));
        Stream.of("7", "8", "9", "*").forEach(button -> row4.add(button));

        calculator.setKeyboard(List.of(row1, row2, row3, row4));

        send(calculator);
    }

    @Test
    void oneColumnMarkup() {
        send(oneColumn("up", "middle", "down"));
    }

    @Test
    void oneRowMarkup() {
        send(oneRow("left", "middle", "right"));
    }

    @Test
    void twoColumnsMarkup() {
        send(twoColumns("1", "2", "3", "4"));
    }

    @Test
    void nColumnsMarkup() {
        send(nColumns(3, "1", "2", "3", "4", "5", "6", "7", "8", "9"));
    }

    @Test
    void calculator() {
        send(nColumns(4, "7", "8", "9", "*", "4", "5", "6", "/", "1", "2", "3", "-", "0", ".", "=", "+"));
    }

    @Test
    void requestContact() {
        KeyboardButton keyboardButton = new KeyboardButton();
        keyboardButton.setText("Contact");
        keyboardButton.setRequestContact(true);
        send(oneColumn(keyboardButton));
    }

    @Test
    void requestLocation() {
        KeyboardButton keyboardButton = new KeyboardButton();
        keyboardButton.setText("Location");
        keyboardButton.setRequestLocation(true);
        send(oneColumn(keyboardButton));
    }
}
