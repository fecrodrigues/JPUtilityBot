package br.com.javaplatform.estados;

import com.pengrad.telegrambot.model.Update;

import br.com.javaplatform.JPUtilityBot;
import br.com.javaplatform.interfaces.IMensagens;

public class Dialogo1 extends IMensagens{

	protected Dialogo1(JPUtilityBot bot, MaquinaDeMensagens maquinaDeMensagens) {
		super(bot, maquinaDeMensagens);
	}


	@Override
	public void respostaBoasVindas(Update update) {
		String msg = "Nossa, quantas vezes eu preciso falar \"Bom Dia\" hein";
		
		MessagePrepare(msg, update);
	}

	@Override
	public void respostaDialogo1(Update update) {
		String msg = "Não tenho o que reclamar! As coisas estam dando certo utimamente :)";
		
		MessagePrepare(msg, update);
        
		maquinaDeMensagens.setEstado(maquinaDeMensagens.getDialogo2());
	}

	@Override
	public void respostaDialogo2(Update update) {
		String msg = "Não somos tao chegados a esse ponto";
		
		MessagePrepare(msg, update);	
	}

	@Override
	public void respostaDialogo3(Update update) {
		String msg = "Não tenho feito muita coisa devido a pandemia";
		
		MessagePrepare(msg, update);
	}

	@Override
	public void respostaDespedida(Update update) {
		String msg = "Nossa o papo nem começou e você já quer sair. Lamentável isso.";
		
		MessagePrepare(msg, update);
	}

}
