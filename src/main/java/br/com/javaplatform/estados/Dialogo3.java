package br.com.javaplatform.estados;

import com.pengrad.telegrambot.model.Update;

import br.com.javaplatform.JPUtilityBot;
import br.com.javaplatform.interfaces.IMensagens;

public class Dialogo3 extends IMensagens{

	protected Dialogo3(MaquinaDeMensagens maquinaDeMensagens) {
		super(maquinaDeMensagens);
	}

	@Override
	public void resposta(Update update) {
		// TODO Auto-generated method stub
		
		maquinaDeMensagens.setEstado(maquinaDeMensagens.getDespedida());
	}

}
