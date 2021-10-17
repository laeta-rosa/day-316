package bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class PsychopompBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "d316_bot";
    }

    @Override
    public String getBotToken() {
        return "2073692524:AAEcVN9P5y72r9t_kymnaREDntgMvkQ1x_4";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {

            String message_text = update.getMessage().getText();
            String chat_id = String.valueOf(update.getMessage().getChatId());

            SendMessage message = SendMessage.builder()
                    .chatId(chat_id)
                    .text(message_text)
                    .build();
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
