package com.tutrit.telegram.demo.keyboard;

import com.tutrit.telegram.TelegramDemoBotAppTest;
import org.junit.jupiter.api.Test;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ForceReplyKeyboard;

public class ForceReplyTest extends TelegramDemoBotAppTest {

    @Test
    public void forceReply() {
        ForceReplyKeyboard forceReplyKeyboard = new ForceReplyKeyboard();
        forceReplyKeyboard.setForceReply(true);
        send(forceReplyKeyboard);
    }

    /**
     * either user should be mentioned in message or message is replying
     */
    @Test
    public void forceReplyForOneUser() {
        ForceReplyKeyboard forceReplyKeyboard = new ForceReplyKeyboard();
        forceReplyKeyboard.setForceReply(true);
        forceReplyKeyboard.setSelective(true);
        send(forceReplyKeyboard, "telegram-bot-demo @jrrby");
    }

    @Test
    public void forceReplyWithInputField() {
        ForceReplyKeyboard forceReplyKeyboard = new ForceReplyKeyboard();
        forceReplyKeyboard.setInputFieldPlaceholder("User Input Here");
        send(forceReplyKeyboard);
    }
}
