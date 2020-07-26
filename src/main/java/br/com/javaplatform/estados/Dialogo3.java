package br.com.javaplatform.estados;

import com.pengrad.telegrambot.model.Update;

import br.com.javaplatform.JPUtilityBot;
import br.com.javaplatform.interfaces.IMensagens;

public class Dialogo3 extends IMensagens{

	protected Dialogo3(JPUtilityBot bot, MaquinaDeMensagens maquinaDeMensagens) {
		super(bot, maquinaDeMensagens);
	}

	@Override
	public void respostaBoasVindas(Update update) {
		String msg = "Por que você gosta de falar tantos \"Oi\"?";
		
		MessagePrepare(msg, update);
	}

	@Override
	public void respostaDialogo1(Update update) {
		String msg = "Não tenho feito nada de novo recentemente, mas gostaria de fazer uma viajem";
		
		MessagePrepare(msg, update);
	}

	@Override
	public void respostaDialogo2(Update update) {
		String msg = "Acredito que ja tenha respodido essa pergunta. Você ja esqueceu?";
		
		MessagePrepare(msg, update);	
	}

	@Override
	public void respostaDialogo3(Update update) {
		String msg = "Tenho apenas trabalhado recentemente";
		
		MessagePrepare(msg, update);
		
		maquinaDeMensagens.setEstado(maquinaDeMensagens.getDialogo2());
	}

	@Override
	public void respostaDespedida(Update update) {
		String msg = "Att";
		
		MessagePrepare(msg, update);
	}
}
