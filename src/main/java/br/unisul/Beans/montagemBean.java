package br.unisul.Beans;


import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.unisul.automato.automato;
import br.unisul.brinquedoDao.brinquedoDao;
import br.unisul.montagem.montagem;


@ManagedBean(name = "montagem")
public class montagemBean{ 
	private String nome;
	private int idade;
	private int material;
	private int pecas;
	
   public String cadastrarMontagem() throws IOException {
	   montagem montagemObj = new montagem();
	   montagemObj.setNome(nome);
	   montagemObj.setIdade(idade);
	   montagemObj.setMaterial(material);
	   montagemObj.setPecas(pecas);
		  
		 brinquedoDao dao = new brinquedoDao();
		  
		   
		   dao.inserirBrinquedo(montagemObj);
		
	   
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

public int getPecas() {
	return pecas;
}

public void setPecas(int pecas) {
	this.pecas = pecas;
} 
   
   
}