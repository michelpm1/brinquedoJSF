package br.unisul.ex1;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped

@ManagedBean
public class TesteJava {
	
	private int numero;
	private String texto;
	
	public void caixaAlta(){
		this.setTexto(this.getTexto().toUpperCase());
	}
	
	public String getTesteRetorno(){
		return "Acessou o metodo 2";
	}
	
	public void incrementaNumero(){
		this.setNumero(this.getNumero() + 1) ;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
