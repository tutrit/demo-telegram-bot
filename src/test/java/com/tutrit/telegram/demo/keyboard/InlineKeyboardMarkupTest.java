package com.tutrit.telegram.demo.keyboard;

import com.tutrit.telegram.TelegramDemoBotAppTest;
import org.junit.jupiter.api.Test;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

import static com.tutrit.telegram.demo.keyboard.KeyboardUtil.*;
import static com.tutrit.telegram.demo.keyboard.KeyboardUtil.nColumns;

public class InlineKeyboardMarkupTest extends TelegramDemoBotAppTest {

    @Test
    void straightforward() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton showAnswer = new InlineKeyboardButton();
        showAnswer.setText("Show Answer");
        showAnswer.setCallbackData("/answer");

        InlineKeyboardButton nextQuestion = new InlineKeyboardButton();
        nextQuestion.setText("Next");
        nextQuestion.setCallbackData("/next_question");

        InlineKeyboardButton prevQuestion = new InlineKeyboardButton();
        prevQuestion.setText("Prev");
        prevQuestion.setCallbackData("/prev_question");

        InlineKeyboardButton quit = new InlineKeyboardButton();
        quit.setText("Quit");
        quit.setCallbackData("/quit");

        List<InlineKeyboardButton> top = List.of(showAnswer);
        List<InlineKeyboardButton> mid = List.of(prevQuestion, nextQuestion);
        List<InlineKeyboardButton> bot = List.of(quit);

        inlineKeyboardMarkup.setKeyboard(List.of(top, mid, bot));
        send(inlineKeyboardMarkup);
    }


    @Test
    void oneColumnMarkup() {
        send(oneColumn(newInlineButton("top", "/top"),
                newInlineButton("middle", "/middle"),
                newInlineButton("bottom", "/bottom")));
    }

    @Test
    void oneRowMarkup() {
        send(oneRow(newInlineButton("left", "/left"),
                newInlineButton("middle", "/middle"),
                newInlineButton("right", "/right")));
    }

    @Test
    void twoColumnsMarkup() {
        send(twoColumns(newInlineButton("1", "/1"),
                newInlineButton("2", "/2"),
                newInlineButton("3", "/3"),
                newInlineButton("4", "/4")));
    }

    @Test
    void nColumnsMarkup() {
        send(nColumns(3, newInlineButton("1", "/1"),
                newInlineButton("2", "/2"),
                newInlineButton("3", "/3"),
                newInlineButton("4", "/4"),
                newInlineButton("5", "/5"),
                newInlineButton("6", "/6")));
    }
}
