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

//Criando um novo Bot do Telegram herdando as funcionalidades da classe Padrão TelegramBot
public class JPUtilityBot extends TelegramBot {

    //Instanciado a maquina de estados com o primeiro estado da conversa.
    private MaquinaDeMensagens maquinaDeMensagens = new MaquinaDeMensagens(this);
    
    JPUtilityActions jpUtilityActions;

    public JPUtilityBot(String botToken) {
        super(botToken);
    }

    //Inicia o bot, escutando as novas mensagens enviadas pelo uusuário e delegando as tratativas as classes responsaveis
    public void start() {

        //Criando um Listener para escutar as novas mensagens enviadas
        this.setUpdatesListener(new UpdatesListener() {

            //Sobrescrevendo o método padrão que trata as mensagens recebidas para um costumizado
            @Override
            public int process(List<Update> updates) {

                //Percorrendo a lista de updates(mensagens) recebidas
                for(Update update: updates) {
                	try {
                		String message = update.message().text();
                		System.out.println("Recebendo mensagem: " + message);

                		//Pegando o id do chat e enviando uma ação para o usuário saber que o bot está tratando a resposta
                		Long chatId = update.message().chat().id();
                		sendAction(chatId, ChatAction.typing);
                		String messageToSend;

                		//Verifica se a mensagem recebida é um comando ou uma mensagem comum
                		if(message.indexOf("/") == 0) {
                		    //Chamando a ação solicitada na mensagem e retornando o resultado para o usuário
                			jpUtilityActions = new JPUtilityActions();
                			messageToSend = jpUtilityActions.callAction(message);
                			sendMessage(chatId, messageToSend);
                		} else {
                		    //Verificando na máquina de estados qual a mensagem correta a ser respondida para o usuário
                			maquinaDeMensagens.getEstado().matcher(update);
                		}
					} catch (Exception e) {
                	    //Caso de algum problema na tratativa da resposta a ser enviada, é enviada uma mensagem padrão.
                		Long chatId = update.message().chat().id();
                		sendAction(chatId, ChatAction.typing);
            			sendMessage(chatId, "Desculpe, mas não entendi vossa mensagem");
					}
                };

                return UpdatesListener.CONFIRMED_UPDATES_ALL;
            }

        });
    }

    //Método que envia uma ação para um chat especifico
    private void sendAction(Long chatId, ChatAction action) {
        // Enviando a informação que o bot está digitando a mensagem
        BaseResponse baseResponse = this.execute(new SendChatAction(chatId, action.name()));
        System.out.println("Ação do chat enviada? " + baseResponse.isOk());
    }

    //Método que envia uma mensagem para um chat especifico
    private void sendMessage(Long chatId, String message) {
        SendResponse sendResponse = this.execute(new SendMessage(chatId, message));
        System.out.println("Mensagem enviada? " + sendResponse.isOk());
    }

    //Para a execução do bot
    public void stop() {
        this.removeGetUpdatesListener();
    }

}
