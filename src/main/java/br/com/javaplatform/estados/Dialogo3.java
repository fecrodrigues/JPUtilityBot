package br.com.javaplatform.estados;

import static br.com.javaplatform.utils.Constantes.MSG_BOAS_VINDAS_5;
import static br.com.javaplatform.utils.Constantes.MSG_DIALOGO1_5;
import static br.com.javaplatform.utils.Constantes.MSG_DIALOGO2_5;
import static br.com.javaplatform.utils.Constantes.MSG_DIALOGO3_5;
import static br.com.javaplatform.utils.Constantes.MSG_DESPEDIDA_5;

import com.pengrad.telegrambot.model.Update;

import br.com.javaplatform.JPUtilityBot;
import br.com.javaplatform.interfaces.IMensagens;

public class Dialogo3 extends IMensagens{

	protected Dialogo3(JPUtilityBot bot, MaquinaDeMensagens maquinaDeMensagens) {
		super(bot, maquinaDeMensagens);
	}

	@Override
	public void respostaBoasVindas(Update update) {
		MessagePrepare(MSG_BOAS_VINDAS_5, update);
	}

	@Override
	public void respostaDialogo1(Update update) {
		MessagePrepare(MSG_DIALOGO1_5, update);
	}

	@Override
	public void respostaDialogo2(Update update) {
		MessagePrepare(MSG_DIALOGO2_5, update);	
	}

	@Override
	public void respostaDialogo3(Update update) {
		MessagePrepare(MSG_DIALOGO3_5, update);
		
		maquinaDeMensagens.setEstado(maquinaDeMensagens.getDialogo2());
	}

	@Override
	public void respostaDespedida(Update update) {
		MessagePrepare(MSG_DESPEDIDA_5, update);
	}
}
