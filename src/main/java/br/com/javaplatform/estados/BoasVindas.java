package br.com.javaplatform.estados;

import com.pengrad.telegrambot.model.Update;
import br.com.javaplatform.JPUtilityBot;
import br.com.javaplatform.interfaces.IMensagens;
import com.vdurmont.emoji.EmojiParser;

public class BoasVindas extends IMensagens{

	protected BoasVindas(JPUtilityBot bot, MaquinaDeMensagens maquinaDeMensagens) {
		super(bot, maquinaDeMensagens);
	}

	@Override
	public void respostaBoasVindas(Update update) {
		String msg = EmojiParser.parseToUnicode("Olá! Eu sou um BOT aprendiz :alien:, prazer em conhecer você :smile:");
		//String msg = EmojiParser.parseToUnicode("Here is a smile emoji: :smile:\\n\\n Here is alien emoji: :alien:");

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
		String msg = "Acho que antes de falarmos de idade, poderiamos come�ar com um \"Bom Dia!\", não?";
		
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
