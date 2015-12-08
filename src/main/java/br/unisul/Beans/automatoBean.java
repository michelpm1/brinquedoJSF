package br.unisul.Beans;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.unisul.automato.automato;
import br.unisul.brinquedoDao.brinquedoDao;


@ManagedBean(name = "automato")

public class automatoBean{ 
	private String nome;
	private int idade;
	private int material;
	private int energia;
	
   public String cadastrarAutomato() throws IOException {
	  automato automatoObj = new automato();
	  automatoObj.setNome(nome);
	  automatoObj.setIdade(idade);
	  automatoObj.setMaterial(material);
	  automatoObj.setEnergia(energia);
	  
	 brinquedoDao dao = new brinquedoDao();
	  
	   
	   dao.inserirBrinquedo(automatoObj);
	
	   return null;
        
   }

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public int getIdade() {
	return idade;
}

public void setIdade(int idade) {
	this.idade = idade;
}

public int getMaterial() {
	return material;
}

public void setMaterial(int material) {
	this.material = material;
}

public int getEnergia() {
	return energia;
}

public void setEnergia(int energia) {
	this.energia = energia;
}


   
   
}