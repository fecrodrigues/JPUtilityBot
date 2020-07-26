package br.com.javaplatform.estados;

import com.pengrad.telegrambot.model.Update;

import br.com.javaplatform.JPUtilityBot;
import br.com.javaplatform.interfaces.IMensagens;

public class Despedida extends IMensagens{

	protected Despedida(JPUtilityBot bot, MaquinaDeMensagens maquinaDeMensagens) {
		super(bot, maquinaDeMensagens);
	}

	@Override
	public void respostaBoasVindas(Update update) {
		String msg = "Acho que ja tivemos essa coversa, não?";
		
		MessagePrepare(msg, update);
	}

	@Override
	public void respostaDialogo1(Update update) {
		String msg = "Esta tudo OK";
		
		MessagePrepare(msg, update);
	}

	@Override
	public void respostaDialogo2(Update update) {
		String msg = "Tenho 10 anos a menos que você e 20 a mais do que seu irmão";
		
		MessagePrepare(msg, update);	
	}

	@Override
	public void respostaDialogo3(Update update) {
		String msg = "Recentemente tenho feito artes marciais e natação";
		
		MessagePrepare(msg, update);
	}

	@Override
	public void respostaDespedida(Update update) {
		String msg = "Gostei da coversa. Boa semana";
		
		MessagePrepare(msg, update);
		
		maquinaDeMensagens.setEstado(maquinaDeMensagens.getBoasVindas());
	}

}
