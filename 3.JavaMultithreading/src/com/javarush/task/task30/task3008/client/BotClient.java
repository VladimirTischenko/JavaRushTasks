package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Vladimir on 23.05.2017.
 */
public class BotClient extends Client {

    public class BotSocketThread extends SocketThread {
        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String[] strings = message.split(": ");
            if (strings.length > 1) {
                String stringDateFormat = null;
                switch (strings[1]) {
                    case "дата": stringDateFormat = "d.MM.YYYY";
                        break;
                    case "день": stringDateFormat = "d";
                        break;
                    case "месяц": stringDateFormat = "MMMM";
                        break;
                    case "год": stringDateFormat = "YYYY";
                        break;
                    case "время": stringDateFormat = "H:mm:ss";
                        break;
                    case "час": stringDateFormat = "H";
                        break;
                    case "минуты": stringDateFormat = "m";
                        break;
                    case "секунды": stringDateFormat = "s";
                        break;
                }
                if (stringDateFormat != null) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat(stringDateFormat);
                    Calendar calendar = Calendar.getInstance();
                    Date time = calendar.getTime();
                    sendTextMessage("Информация для " + strings[0] + ": " + dateFormat.format(time));
                }
            }
        }

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int) (Math.random() * 100);
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
