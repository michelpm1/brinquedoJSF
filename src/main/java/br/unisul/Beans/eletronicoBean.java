package br.unisul.Beans;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.unisul.brinquedoDao.brinquedoDao;
import br.unisul.eletronico.eletronico;
import br.unisul.minicomputador.minicomputador;


@ManagedBean(name = "eletronico")
public class eletronicoBean{ 
	private String nome;
	private int idade;
	private int material;
	private int pilhas;
	private String caract;
	
   public String cadastrarEletronico() throws IOException {
	
	   eletronico eletronicoObj = new eletronico();
	   eletronicoObj.setNome(nome);
	   eletronicoObj.setIdade(idade);
	   eletronicoObj.setMaterial(material);
	   eletronicoObj.setCaracteristica(caract);
	   eletronicoObj.setPilhas(pilhas);
		  
		 brinquedoDao dao = new brinquedoDao();
		  
		   
		   dao.inserirBrinquedo(eletronicoObj);
		   
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

public int getPilhas() {
	return pilhas;
}

public void setPilhas(int pilhas) {
	this.pilhas = pilhas;
}

public String getCaract() {
	return caract;
}

public void setCaract(String caract) {
	this.caract = caract;
}


   
   
}