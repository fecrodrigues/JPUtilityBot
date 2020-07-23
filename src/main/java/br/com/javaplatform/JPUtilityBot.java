package br.com.javaplatform;

import br.com.javaplatform.actions.JPUtilityActions;
import br.com.javaplatform.enums.MessagesEnum;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.request.SendChatAction;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.SendResponse;

import java.util.List;

public class JPUtilityBot extends TelegramBot {

    JPUtilityActions jpUtilityActions;

    private Integer messagesNotReadIndex = 0;

    public JPUtilityBot(String botToken) {
        super(botToken);
    }

    public void start() {

        this.setUpdatesListener(new UpdatesListener() {

            MessagesEnum activeState;
            //MessagesEnum activeState = MessagesEnum.OLA;

            @Override
            public int process(List<Update> updates) {

                for(Update update: updates) {
                   String message = update.message().text();
                    System.out.println("Recebendo mensagem: " + message);

                    Long chatId = update.message().chat().id();
                    sendAction(chatId, ChatAction.typing);
                    String messageToSend;

                    if(message.indexOf("/") == 0) {
                        jpUtilityActions = new JPUtilityActions();
                        messageToSend = jpUtilityActions.callAction(message);
                    } else {
                        activeState = MessagesEnum.detectNextState(message);
                        messageToSend = activeState.message();
                    }

                    sendMessage(chatId, messageToSend);
                    //activeState = activeState.nextState(message);
                };

                return UpdatesListener.CONFIRMED_UPDATES_ALL;
            }

        });
    }

    public void stop() {
        this.removeGetUpdatesListener();
    }

    private void sendAction(Long chatId, ChatAction action) {
        // Enviando a informação que o bot está digitando a mensagem
        BaseResponse baseResponse = this.execute(new SendChatAction(chatId, action.name()));
        System.out.println("Ação do chat enviada? " + baseResponse.isOk());
    }

    private void sendMessage(Long chatId, String message) {
        SendResponse sendResponse = this.execute(new SendMessage(chatId, message));
        System.out.println("Mensagem enviada? " + sendResponse.isOk());
    }


}
