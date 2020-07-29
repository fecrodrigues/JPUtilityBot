package br.com.javaplatform.estados;

import static br.com.javaplatform.utils.Constantes.MSG_BOAS_VINDAS_3;
import static br.com.javaplatform.utils.Constantes.MSG_DIALOGO1_3;
import static br.com.javaplatform.utils.Constantes.MSG_DIALOGO2_3;
import static br.com.javaplatform.utils.Constantes.MSG_DIALOGO3_3;
import static br.com.javaplatform.utils.Constantes.MSG_DESPEDIDA_3;

import com.pengrad.telegrambot.model.Update;

import br.com.javaplatform.JPUtilityBot;
import br.com.javaplatform.interfaces.IMensagens;

public class Dialogo2 extends IMensagens{

	protected Dialogo2(JPUtilityBot bot, MaquinaDeMensagens maquinaDeMensagens) {
		super(bot, maquinaDeMensagens);
	}

	@Override
	public void respostaBoasVindas(Update update) {
		MessagePrepare(MSG_BOAS_VINDAS_3, update);
	}

	@Override
	public void respostaDialogo1(Update update) {
		MessagePrepare(MSG_DIALOGO1_3, update);
	}

	@Override
	public void respostaDialogo2(Update update) {
		MessagePrepare(MSG_DIALOGO2_3, update);	
		
		maquinaDeMensagens.setEstado(maquinaDeMensagens.getDialogo3());
	}

	@Override
	public void respostaDialogo3(Update update) {
		MessagePrepare(MSG_DIALOGO3_3, update);
	}

	@Override
	public void respostaDespedida(Update update) {
		MessagePrepare(MSG_DESPEDIDA_3, update);
	}
}
