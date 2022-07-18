package com.tutrit.telegram;

import com.tutrit.telegram.service.MessageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TelegramDemoBotAppTest {

    @Value("${chat.id}")
    protected String chatId;
    @Autowired
    protected MessageService messageService;

    @Test
    void main() {
    }

    protected  <T extends ReplyKeyboard> Message send(T keyboard) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("telegram-bot-demo");
        sendMessage.setChatId(chatId);

        sendMessage.setReplyMarkup(keyboard);
        return messageService.sendMessage(sendMessage);
    }

    protected  <T extends ReplyKeyboard> Message send(T keyboard, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);

        sendMessage.setReplyMarkup(keyboard);
        return messageService.sendMessage(sendMessage);
    }
}