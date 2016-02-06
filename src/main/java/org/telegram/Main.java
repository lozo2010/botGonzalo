package org.telegram;

import org.telegram.services.BotLogger;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.updateshandlers.EchoHandlers;

/**
 * @author David
 * @version 1.0
 * @brief Main class to create all bots
 * @date 6 of Febrero of 2016
 */
public class Main {
    private static final String LOGTAG = "MAIN";

    public static void main(String[] args) {

        /**Creamos el Bot y lo registramos en la clase EchoHandlers**/

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new EchoHandlers());
        } catch (TelegramApiException e) {
            BotLogger.error(LOGTAG, e);
        }
    }
}
