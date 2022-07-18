package com.tutrit.telegram.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final TelegramBot telegramBot;

    public Message sendMessage(SendMessage sendMessage) {
        try {
            return telegramBot.execute(sendMessage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
