package br.com.javaplatform.estados;

import com.pengrad.telegrambot.model.Update;

import br.com.javaplatform.JPUtilityBot;
import br.com.javaplatform.interfaces.IMensagens;

public class Dialogo2 extends IMensagens{

	protected Dialogo2(JPUtilityBot bot, MaquinaDeMensagens maquinaDeMensagens) {
		super(bot, maquinaDeMensagens);
	}

	@Override
	public void respostaBoasVindas(Update update) {
		String msg = "Acredito que ja tenha falado \"Oi\" para voc� hoje";
		
		MessagePrepare(msg, update);
	}

	@Override
	public void respostaDialogo1(Update update) {
		String msg = "Esta tudo bem. Confesso que gostaria de sair de casa, mas tenho que respeitar a quarentena";
		
		MessagePrepare(msg, update);
	}

	@Override
	public void respostaDialogo2(Update update) {
		String msg = "Acabei de nascer! Tenho poucas horas de vida.";
		
		MessagePrepare(msg, update);	
		
		maquinaDeMensagens.setEstado(maquinaDeMensagens.getDialogo3());
	}

	@Override
	public void respostaDialogo3(Update update) {
		String msg = "N�o tenho feito muita coisa, mas seria bom prativar uma atividade f�sica";
		
		MessagePrepare(msg, update);
	}

	@Override
	public void respostaDespedida(Update update) {
		String msg = "Caso voc� n�o queria mais papo, pode ir embora";
		
		MessagePrepare(msg, update);
	}
}
