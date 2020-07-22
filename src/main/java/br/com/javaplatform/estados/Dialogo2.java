package br.com.javaplatform.estados;

import com.pengrad.telegrambot.model.Update;

import br.com.javaplatform.JPUtilityBot;
import br.com.javaplatform.interfaces.IMensagens;

public class Dialogo2 extends IMensagens{

	protected Dialogo2(MaquinaDeMensagens maquinaDeMensagens) {
		super(maquinaDeMensagens);
	}

	@Override
	public void resposta(Update update) {
		// TODO Auto-generated method stub
		maquinaDeMensagens.setEstado(maquinaDeMensagens.getDialogo3());
	}

}
