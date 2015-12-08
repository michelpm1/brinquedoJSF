package br.unisul.eletronico;

import br.unisul.brinquedo.brinquedo;

public class eletronico extends brinquedo{
	private int pilhas;
	private String caracteristica;
	
	public eletronico(){
		this.pilhas=pilhas;
		this.caracteristica=caracteristica;
	}


	public int getPilhas() {
		return pilhas;
	}


	public void setPilhas(int pilhas) {
		this.pilhas = pilhas;
	}


	public String getCaracteristica() {
		return caracteristica;
	}


	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}
	
	
	
}

