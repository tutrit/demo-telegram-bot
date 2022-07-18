package com.tutrit.telegram.demo.keyboard;

import com.tutrit.telegram.TelegramDemoBotAppTest;
import org.junit.jupiter.api.Test;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButtonPollType;

import static com.tutrit.telegram.demo.keyboard.KeyboardUtil.oneColumn;
import static com.tutrit.telegram.demo.keyboard.KeyboardUtil.oneRow;

public class ReplyKeyboardFeaturesTest extends TelegramDemoBotAppTest {

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

    @Test
    void requestPoll() {
        KeyboardButton keyboardButton = new KeyboardButton();
        keyboardButton.setText("Make Poll");
        keyboardButton.setRequestPoll(KeyboardButtonPollType.builder().build());
        send(oneColumn(keyboardButton));
    }

    @Test
    void requestQuizPoll() {
        KeyboardButton keyboardButton = new KeyboardButton();
        keyboardButton.setText("Make Poll");
        keyboardButton.setRequestPoll(KeyboardButtonPollType.builder().type("quiz").build());
        send(oneColumn(keyboardButton));
    }

    @Test
    void requestRegularPoll() {
        KeyboardButton keyboardButton = new KeyboardButton();
        keyboardButton.setText("Make Poll");
        keyboardButton.setRequestPoll(KeyboardButtonPollType.builder().type("regular").build());
        send(oneColumn(keyboardButton));
    }

    @Test
    void keyboardResizeable() throws InterruptedException {
        ReplyKeyboardMarkup keyboard = oneColumn("up", "middle", "down");
        keyboard.setResizeKeyboard(false);
        send(keyboard);
        Thread.sleep(1000);
        keyboard.setResizeKeyboard(true);
        send(keyboard);
        Thread.sleep(1000);

        keyboard = oneRow("up", "middle", "down");
        keyboard.setResizeKeyboard(false);
        send(keyboard);
        Thread.sleep(1000);
        keyboard.setResizeKeyboard(true);
        send(keyboard);
        Thread.sleep(1000);
    }

    @Test
    void removeAfterPressButton() {
        ReplyKeyboardMarkup keyboard = oneColumn("up", "middle", "down");
        keyboard.setOneTimeKeyboard(true);
        send(keyboard);
    }

    /**
     * either user should be mentioned in message or message is replying
     */
    @Test
    void removeAfterPressButtonForOneUserInChat() {
        ReplyKeyboardMarkup keyboard = oneColumn("up", "middle", "down");
        keyboard.setOneTimeKeyboard(true);
        keyboard.setSelective(true);

        send(keyboard, "telegram-bot-demo @jrrby");
    }

    @Test
    void sendCommandToRemoveKeyboard() throws InterruptedException {
        ReplyKeyboardMarkup keyboard = oneColumn("up", "middle", "down");
        send(keyboard);
        Thread.sleep(1000);

        ReplyKeyboardRemove replyKeyboardRemove = ReplyKeyboardRemove.builder().removeKeyboard(true).build();
        send(replyKeyboardRemove);
    }


    /**
     * either user should be mentioned in message or message is replying
     */
    @Test
    // TODO: 2/18/22 add reply example
    void sendCommandToRemoveKeyboardForOneUserInChat() throws InterruptedException {
        ReplyKeyboardMarkup keyboard = oneColumn("up", "middle", "down");
        send(keyboard);
        Thread.sleep(1000);

        ReplyKeyboardRemove replyKeyboardRemove = ReplyKeyboardRemove.builder()
                .removeKeyboard(true)
                .selective(true)
                .build();
        send(replyKeyboardRemove, "telegram-bot-demo @jrrby");
    }

    @Test
    void withInputField() {
        ReplyKeyboardMarkup keyboard = oneColumn("up", "middle", "down");
        keyboard.setInputFieldPlaceholder("User Input");
        send(keyboard);
    }
}
