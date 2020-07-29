package br.com.javaplatform.estados;

import static br.com.javaplatform.utils.Constantes.MSG_BOAS_VINDAS_1;
import static br.com.javaplatform.utils.Constantes.MSG_DIALOGO1_1;
import static br.com.javaplatform.utils.Constantes.MSG_DIALOGO2_1;
import static br.com.javaplatform.utils.Constantes.MSG_DIALOGO3_1;
import static br.com.javaplatform.utils.Constantes.MSG_DESPEDIDA_1;

import com.pengrad.telegrambot.model.Update;
import br.com.javaplatform.JPUtilityBot;
import br.com.javaplatform.interfaces.IMensagens;

public class BoasVindas extends IMensagens{

	protected BoasVindas(JPUtilityBot bot, MaquinaDeMensagens maquinaDeMensagens) {
		super(bot, maquinaDeMensagens);
	}

	@Override
	public void respostaBoasVindas(Update update) {
		MessagePrepare(MSG_BOAS_VINDAS_1, update);
        
		maquinaDeMensagens.setEstado(maquinaDeMensagens.getDialogo1());
	}

	@Override
	public void respostaDialogo1(Update update) {
		MessagePrepare(MSG_DIALOGO1_1, update);
	}

	@Override
	public void respostaDialogo2(Update update) {
		MessagePrepare(MSG_DIALOGO2_1, update);	
	}

	@Override
	public void respostaDialogo3(Update update) {
		MessagePrepare(MSG_DIALOGO3_1, update);
	}

	@Override
	public void respostaDespedida(Update update) {		
		MessagePrepare(MSG_DESPEDIDA_1, update);
	}

}
