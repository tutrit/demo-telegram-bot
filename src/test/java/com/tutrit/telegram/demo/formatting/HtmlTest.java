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
public class HtmlTest {

    @Value("${chat.id}")
    String chatId;
    @Autowired
    MessageService messageService;

    @Test
    void sendMessage() {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(UpdateUtil.readResourceFile("demo/formatted/HTML.html"));
        sendMessage.setChatId(chatId);
        sendMessage.setParseMode(ParseMode.HTML);

        Message message = messageService.sendMessage(sendMessage);

        assertEquals(sendMessage.getChatId(), message.getChatId().toString());
    }

    @Test
    void bold() {
        send("[bold]<b>telegram-bot-demo</b> <strong>telegram-bot-demo</strong>");
    }

    @Test
    void italic() {
        send("[italic] <i>telegram-bot-demo</i>, <em>telegram-bot-demo</em>");
    }

    @Test
    void underline() {
        send("[underline] <u>telegram-bot-demo</u>, <ins>telegram-bot-demo</ins>");
    }

    @Test
    void strikethrough() {
        send("[strikethrough] <s>telegram-bot-demo</s>, <strike>telegram-bot-demo</strike>, <del>telegram-bot-demo</del>");
    }

    @Test
    void spoiler() {
        send("[spoiler] <span class=\"tg-spoiler\">telegram-bot-demo</span>, <tg-spoiler>telegram-bot-demo</tg-spoiler>");
    }

    @Test
    void combined() {
        send("[combined] <i><b><u>telegram-bot-demo</u></b></i>");
    }

    @Test
    void urlLink() {
        send("[URL] <a href=\"http://tutrit.com/\">tutrit.com</a>");
    }

    @Test
    void code() {
        send("[code] <pre><code class=\"java\">\n" +
                "package com.tutrit.telegram;\n" +
                "\n" +
                "import com.tutrit.telegram.util.Mapper;\n" +
                "import org.slf4j.Logger;\n" +
                "import org.slf4j.LoggerFactory;\n" +
                "import org.springframework.boot.SpringApplication;\n" +
                "import org.springframework.boot.autoconfigure.SpringBootApplication;\n" +
                "import org.springframework.scheduling.annotation.EnableScheduling;\n" +
                "\n" +
                "@SpringBootApplication\n" +
                "@EnableScheduling\n" +
                "public class TelegramDemoBotApp {\n" +
                "\tpublic static final Logger LOGGER = LoggerFactory.getLogger(Mapper.class);\n" +
                "\n" +
                "\tpublic static void main(String[] args) {\n" +
                "\t\tSpringApplication.run(TelegramDemoBotApp.class, args);\n" +
                "\t}\n" +
                "}\n" +
                "\n" +
                "</code></pre>");
    }

    private Message send(String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(text);
        sendMessage.setChatId(chatId);
        sendMessage.setParseMode(ParseMode.HTML);
        return messageService.sendMessage(sendMessage);
    }
}
