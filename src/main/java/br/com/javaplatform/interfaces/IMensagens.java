package br.com.javaplatform.interfaces;

import static br.com.javaplatform.enums.MessagesEnum.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.request.SendChatAction;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.SendResponse;

import br.com.javaplatform.JPUtilityBot;
import br.com.javaplatform.enums.MessagesEnum;
import br.com.javaplatform.estados.MaquinaDeMensagens;

public abstract class IMensagens {

	protected JPUtilityBot bot;
	protected MaquinaDeMensagens maquinaDeMensagens;
	
	protected IMensagens(JPUtilityBot bot, MaquinaDeMensagens maquinaDeMensagens) {
		this.bot = bot;
		this.maquinaDeMensagens = maquinaDeMensagens;
	}
	
	public void matcher(Update update) {
	    String message = update.message().text();
	    Boolean isMsgNaoEntendida = true;
	    int contador = 0;
		
		for(MessagesEnum msg : MessagesEnum.values()) {
	        Pattern pattern = Pattern.compile(msg.getRegex());
	        Matcher matcher = pattern.matcher(message.toLowerCase());

	        if(matcher.find() && contador == 0) {
	            switch (msg) {
				case BOAS_VINDAS:
					respostaBoasVindas(update);
					contador++;
					break;
				case DIALOGO1:
					respostaDialogo1(update);
					contador++;
					break;
				case DIALOGO2:
					respostaDialogo2(update);
					contador++;
					break;
				case DIALOGO3:
					respostaDialogo3(update);
					contador++;
					break;
				case DESPEDIDA:
					respostaDespedida(update);
					contador++;
					break;
				case NAO_ENTENDI:
					MessagePrepare("Desculpa, mas não entendi o que você disse! [Teste]", update);
					contador++;
					break;
				}
	        }
		}
	};
	
	public abstract void respostaBoasVindas(Update update);
	public abstract void respostaDialogo1(Update update);
	public abstract void respostaDialogo2(Update update);
	public abstract void respostaDialogo3(Update update);
	public abstract void respostaDespedida(Update update);
	
	protected void MessagePrepare(String msg, Update update) {
        Long chatId = update.message().chat().id();
        
        sendAction(chatId, ChatAction.typing);
        sendMessage(chatId, msg);
	}
	
    private void sendAction(Long chatId, ChatAction action) {
        // Enviando a informação que o bot está digitando a mensagem
        BaseResponse baseResponse = bot.execute(new SendChatAction(chatId, action.name()));
        System.out.println("Ação do chat enviada? " + baseResponse.isOk());
    }

    private void sendMessage(Long chatId, String message) {
        SendResponse sendResponse = bot.execute(new SendMessage(chatId, message));
        System.out.println("Mensagem enviada? " + sendResponse.isOk());
    }
}
