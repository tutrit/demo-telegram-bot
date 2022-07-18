package com.tutrit.telegram.demo.formatting;

import com.tutrit.telegram.service.MessageService;
import com.tutrit.telegram.util.UpdateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MarkdownV2Test {

    @Value("${chat.id}")
    String chatId;
    @Autowired
    MessageService messageService;
    char[] charactersThatShouldBeEscaped = {'_', '*', '[', ']', '(', ')', '~', '`', '>', '#', '+', '-', '=', '|', '{', '}', '.', '!'};

    @Test
    void sendMessage() {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(UpdateUtil.readResourceFile("demo/formatted/MarkdownV2.md"));
        sendMessage.setChatId(chatId);
        sendMessage.setParseMode(ParseMode.MARKDOWNV2);

        Message message = messageService.sendMessage(sendMessage);

        assertEquals(sendMessage.getChatId(), message.getChatId().toString());
    }

    @Test
    void bold() {
        send("[bold] *telegram\\-bot\\-demo*");
    }

    @Test
    void italic() {
        send("[italic] _telegram\\-bot\\-demo_");
    }

    @Test
    void underline() {
        send("[underline] __telegram\\-bot\\-demo__");
    }

    @Test
    void strikethrough() {
        send("[strikethrough] ~telegram\\-bot\\-demo~");
    }

    @Test
    void italicUnderline() {
        send("[italicUnderline] ___telegram\\-bot\\-demo_\r__");
    }

    @Test
    void italicBold() {
        send("[italicBold] _*telegram\\-bot\\-demo*_");
    }

    @Test
    void italicBoldUnderline() {
        send("[italicBoldUnderline] *___telegram\\-bot\\-demo_\r__*");
    }

    @Test
    void italicBoldUnderline2() {
        send("[italicBoldUnderline] __*_telegram\\-bot\\-demo_*__");
    }

    @Test
    void urlLink() {
        send("[URL] [tutrit\\.com](http://tutrit.com/)");
    }

    @Test
    void code() {
        send("[code] ```java" +
                "public class TelegramDemoBotApp {\n" +
                "\tpublic static final Logger LOGGER = LoggerFactory.getLogger(Mapper.class);\n" +
                "\n" +
                "\tpublic static void main(String[] args) {\n" +
                "\t\tSpringApplication.run(TelegramDemoBotApp.class, args);\n" +
                "\t}\n" +
                "}" +
                "```");
    }

    private Message send(String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(text);
        sendMessage.setChatId(chatId);
        sendMessage.setParseMode(ParseMode.MARKDOWNV2);
        return messageService.sendMessage(sendMessage);
    }
}
