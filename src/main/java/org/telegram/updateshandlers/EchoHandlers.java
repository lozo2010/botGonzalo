package org.telegram.updateshandlers;

import org.telegram.BotConfig;
import org.telegram.Commands;
import org.telegram.services.BotLogger;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.methods.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import java.io.InvalidObjectException;

/**
 * Created by David on 03/02/2016.
 */
public class EchoHandlers extends TelegramLongPollingBot {
    private static final String LOGTAG = "ECHOHANDLERS";

    @Override
    public void onUpdateReceived(Update update) {

        //Aqui se recibe todo lo que le escribas al bot

        Message message = update.getMessage();

        //System.out.println(String.valueOf(p.size()));
        if (message != null && message.hasText()) {
            try {
                System.out.println(message.getFrom().getId());
                SendMessage sendMessageRequest = new SendMessage();
                sendMessageRequest.setChatId(message.getChatId() + "");
                sendMessageRequest.setText(message.getText());
                try {
                    sendMessage(sendMessageRequest);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                handleEcho(update);
            } catch (InvalidObjectException e) {
                BotLogger.error(LOGTAG, e);

            }
        }
    }

    @Override
    public String getBotToken() {
        return BotConfig.TOKEN;
    }


    @Override
    public String getBotUsername() {
        return BotConfig.USERNAMEBOT;
    }

    private void handleEcho(Update update) throws InvalidObjectException {
        Message message = update.getMessage();

        if (message.getText().startsWith(Commands.startCommand)) {
            System.out.println(message.getText());
        }


    }


}