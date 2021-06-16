package com.example.cityexplorer.integration;

import com.example.cityexplorer.facade.MessageFacade;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramIntegration extends TelegramLongPollingBot {

    private final MessageFacade messageFacade;
    @Value("${telegram.api.token}")
    private String token;
    @Value("${telegram.api.name}")
    private String name;

    public TelegramIntegration(MessageFacade messageFacade) {
        this.messageFacade = messageFacade;
    }

    @Override
    public String getBotUsername() {
        return this.name;
    }

    @Override
    public String getBotToken() {
        return this.token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        final Long chatId = update.getMessage().getChatId();
        final String text = update.getMessage().getText();
        final SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));

        if (StringUtils.isBlank(text)) {
            sendMessage.setText(messageFacade.getNotFoundText());
            safeExecute(sendMessage);
            return;
        }
        final String responseText = messageFacade.getRandomFactMessage(text);
        sendMessage.setText(responseText);
        sendMessage.setParseMode("html");
        safeExecute(sendMessage);
    }

    private void safeExecute(SendMessage sendMessage) {
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}