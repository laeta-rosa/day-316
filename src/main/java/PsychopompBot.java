import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class PsychopompBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "Day316PsychopompBot";
    }

    @Override
    public String getBotToken() {
        return "2089412411:AAGfUCuExYStyhhEJzPjLl49QHlfPl03hr8";
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
