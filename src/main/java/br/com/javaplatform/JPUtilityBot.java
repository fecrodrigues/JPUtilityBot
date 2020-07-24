package br.com.javaplatform;

import java.util.List;

import br.com.javaplatform.actions.JPUtilityActions;
import br.com.javaplatform.enums.MessagesEnum;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendChatAction;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.SendResponse;

import br.com.javaplatform.estados.MaquinaDeMensagens;

public class JPUtilityBot extends TelegramBot {

	private Integer messagesNotReadIndex = 0;
    private MaquinaDeMensagens maquinaDeMensagens = new MaquinaDeMensagens(this);
    
    JPUtilityActions jpUtilityActions;

    public JPUtilityBot(String botToken) {
        super(botToken);
    }

    public void start() {

        this.setUpdatesListener(new UpdatesListener() {

            @Override
            public int process(List<Update> updates) {
            	 
                for(Update update: updates) {
//                	maquinaDeMensagens.getEstado().matcher(update);

                	String message = update.message().text();
                    System.out.println("Recebendo mensagem: " + message);

//                    Long chatId = update.message().chat().id();
//                    sendAction(chatId, ChatAction.typing);
                    String messageToSend;

                    if(message.indexOf("/") == 0) {
                        jpUtilityActions = new JPUtilityActions();
                        messageToSend = jpUtilityActions.callAction(message);
                    } else {
//                        activeState = MessagesEnum.detectNextState(message);
//                        messageToSend = activeState.message();
                    	maquinaDeMensagens.getEstado().matcher(update);
                    }

//                    sendMessage(chatId, messageToSend);
                    //activeState = activeState.nextState(message);
                };

                return UpdatesListener.CONFIRMED_UPDATES_ALL;
            }

        });
    }

    public void stop() {
        this.removeGetUpdatesListener();
    }

}
