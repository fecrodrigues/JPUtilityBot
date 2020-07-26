package br.com.javaplatform.estados;

import com.pengrad.telegrambot.model.Update;

import br.com.javaplatform.JPUtilityBot;
import br.com.javaplatform.interfaces.IMensagens;

public class BoasVindas extends IMensagens{

	protected BoasVindas(JPUtilityBot bot, MaquinaDeMensagens maquinaDeMensagens) {
		super(bot, maquinaDeMensagens);
	}

	@Override
	public void respostaBoasVindas(Update update) {
		String msg = "Ol�! Eu sou o Utility bot, prazer em conhecer voc�";
		
		MessagePrepare(msg, update);
        
		maquinaDeMensagens.setEstado(maquinaDeMensagens.getDialogo1());
	}

	@Override
	public void respostaDialogo1(Update update) {
		String msg = "Vou bem, mas poderia estar melhor com um \"Bom Dia!\" antes!";
		
		MessagePrepare(msg, update);
	}

	@Override
	public void respostaDialogo2(Update update) {
		String msg = "Acho que antes de falarmos de idade, poderiams come�ar com um \"Bom Dia!\", n�o?";
		
		MessagePrepare(msg, update);	
	}

	@Override
	public void respostaDialogo3(Update update) {
		String msg = "Nada de novo! Bom Dia para voc� tamb�m";
		
		MessagePrepare(msg, update);
	}

	@Override
	public void respostaDespedida(Update update) {
		String msg = "Nem come�amos e voc� ja quer ir embora?";
		
		MessagePrepare(msg, update);
	}

}
