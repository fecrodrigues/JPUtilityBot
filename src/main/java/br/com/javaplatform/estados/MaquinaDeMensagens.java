package br.com.javaplatform.estados;

import br.com.javaplatform.JPUtilityBot;
import br.com.javaplatform.interfaces.IMensagens;

public class MaquinaDeMensagens {
	private IMensagens boasVindas;
	private IMensagens dialogo1;
	private IMensagens dialogo2;
	private IMensagens dialogo3;
	private IMensagens despedida;
		
	private IMensagens estado;
	
	public MaquinaDeMensagens(JPUtilityBot bot){
		boasVindas = new BoasVindas(bot,this);
		dialogo1 = new Dialogo1(bot, this);
		dialogo2 = new Dialogo2(bot, this);
		dialogo3 = new Dialogo3(bot, this);
		despedida = new Despedida(bot, this);
		
		this.estado = boasVindas;
	}

	public IMensagens getEstado() {
		return estado;
	}
	
	public void setEstado(IMensagens estado) {
		this.estado = estado;
	}

	public IMensagens getBoasVindas() {
		return boasVindas;
	}

	public IMensagens getDialogo1() {
		return dialogo1;
	}

	public IMensagens getDialogo2() {
		return dialogo2;
	}

	public IMensagens getDialogo3() {
		return dialogo3;
	}

	public IMensagens getDespedida() {
		return despedida;
	}

}
