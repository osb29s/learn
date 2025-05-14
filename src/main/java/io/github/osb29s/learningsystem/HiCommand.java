package io.github.osb29s.learningsystem;

import com.rainett.javagram.action.Action;
import com.rainett.javagram.action.annotations.Command;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Command("/start")
@RequiredArgsConstructor
public class HiCommand implements Action {
    private final DefaultAbsSender bot;

    @Override
    @SneakyThrows
    public void run(Update update) {
        Message message = update.getMessage();
        String name = message.getFrom().getFirstName();
        Long chatId = message.getChatId();
        SendMessage sendMessage = SendMessage.builder()
                .chatId(chatId)
                .text("Привіт, " + name + ". Ти мавпа.")
                .build();
        bot.execute(sendMessage);
    }
}
