package br.unisul.Beans;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.unisul.brinquedoDao.brinquedoDao;
import br.unisul.minicomputador.minicomputador;
import br.unisul.montagem.montagem;


@ManagedBean(name = "minicomputador")
public class minicomputadorBean{ 
	private String nome;
	private int idade;
	private int material;
	private String funcoes;
	
   public String cadastrarMinicomputador() throws IOException {
	   minicomputador minicomputadorObj = new minicomputador();
	   minicomputadorObj.setNome(nome);
	   minicomputadorObj.setIdade(idade);
	   minicomputadorObj.setMaterial(material);
	   minicomputadorObj.setFuncoes(funcoes);
		  
		 brinquedoDao dao = new brinquedoDao();
		  
		   
		   dao.inserirBrinquedo(minicomputadorObj);
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

public String getFuncoes() {
	return funcoes;
}

public void setFuncoes(String funcoes) {
	this.funcoes = funcoes;
} 
   
   
}