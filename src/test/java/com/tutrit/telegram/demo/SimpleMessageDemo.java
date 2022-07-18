package com.tutrit.telegram.demo;

import com.tutrit.telegram.service.MessageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SimpleMessageDemo {

    @Value("${chat.id}")
    String chatId;
    @Autowired
    MessageService messageService;

    @Test
    void sendMessage() {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Hello World!");
        sendMessage.setChatId(chatId);

        Message message = messageService.sendMessage(sendMessage);

        assertEquals(sendMessage.getText(), message.getText());
        assertEquals(sendMessage.getChatId(), message.getChatId().toString());
    }
}
