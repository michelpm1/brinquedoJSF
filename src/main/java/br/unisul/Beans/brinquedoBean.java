package br.unisul.Beans;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import br.unisul.automato.automato;
import br.unisul.brinquedo.brinquedo;
import br.unisul.brinquedoDao.brinquedoDao;
import br.unisul.eletronico.eletronico;
import br.unisul.minicomputador.minicomputador;
import br.unisul.montagem.montagem;

@ManagedBean(name = "brinquedo")
public class brinquedoBean {
	private String nome;
	private int idade;
	private int material;
	private String funcoes;
	private int energia;
	private String caract;
	private int pilha;
	private int pecas;
	private int tipo;
	private int panel;
	

private	ArrayList<montagem> auxMontagem = new ArrayList<montagem>();
private	ArrayList<automato> auxAutomato = new ArrayList<automato>();
private	ArrayList<eletronico> auxEletronico = new ArrayList<eletronico>();
private	ArrayList<minicomputador> auxMinicomputador = new ArrayList<minicomputador>();

	
	
	public Object consultaNome(){
		
		brinquedo[] meuArray = new brinquedo[10];
		brinquedoDao dao = new brinquedoDao();
		
		
		meuArray=dao.consultaNome(nome);
		nome = meuArray[0].getNome();
		idade = meuArray[0].getIdade();
		material = meuArray[0].getMaterial();
		energia = ((br.unisul.automato.automato) meuArray[0]).getEnergia();
		pecas = ((br.unisul.montagem.montagem) meuArray[1]).getPecas();
		caract = ((br.unisul.eletronico.eletronico) meuArray[2]).getCaracteristica();
		pilha = ((br.unisul.eletronico.eletronico) meuArray[2]).getPilhas();
		funcoes = ((br.unisul.minicomputador.minicomputador) meuArray[3]).getFuncoes();
		
		
		
		
		
		return null;
		
		
	}

	public void consultarTipo(){
		ArrayList<brinquedo> listBrinquedo = new ArrayList<brinquedo>();
		brinquedoDao dao = new brinquedoDao();
		listBrinquedo=dao.consultarTipo(tipo);
		//for(int i = 0; i < listBrinquedo.size(); i++){
			brinquedo aux = new brinquedo();
			aux = listBrinquedo.get(0);
			
			if (aux instanceof montagem){
				panel=1;
				for (int i1 = 0; i1 < listBrinquedo.size(); i1++){
					auxMontagem.add((montagem) listBrinquedo.get(i1));
				}
			} else if (aux instanceof automato){
				panel=2;
				for (int i1 = 0; i1 < listBrinquedo.size(); i1++){
					auxAutomato.add((automato) listBrinquedo.get(i1));
				}
			} else if (aux instanceof eletronico){
				panel=3;
				for (int i1 = 0; i1 < listBrinquedo.size(); i1++){
					auxEletronico.add((eletronico) listBrinquedo.get(i1));
				}
			}	else{
				panel=4;
				for (int i1 = 0; i1 < listBrinquedo.size(); i1++){
					auxMinicomputador.add((minicomputador) listBrinquedo.get(i1));
			
			}
		}
		
		}
	//}

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


	public int getEnergia() {
		return energia;
	}


	public void setEnergia(int energia) {
		this.energia = energia;
	}


	public String getCaract() {
		return caract;
	}


	public void setCaract(String caract) {
		this.caract = caract;
	}


	public int getPilha() {
		return pilha;
	}


	public void setPilha(int pilha) {
		this.pilha = pilha;
	}


	public int getPecas() {
		return pecas;
	}


	public void setPecas(int pecas) {
		this.pecas = pecas;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public ArrayList<montagem> getAuxMontagem() {
		return auxMontagem;
	}

	public void setAuxMontagem(ArrayList<montagem> auxMontagem) {
		this.auxMontagem = auxMontagem;
	}

	public ArrayList<automato> getAuxAutomato() {
		return auxAutomato;
	}

	public void setAuxAutomato(ArrayList<automato> auxAutomato) {
		this.auxAutomato = auxAutomato;
	}

	public ArrayList<eletronico> getAuxEletronico() {
		return auxEletronico;
	}

	public void setAuxEletronico(ArrayList<eletronico> auxEletronico) {
		this.auxEletronico = auxEletronico;
	}

	public ArrayList<minicomputador> getAuxMinicomputador() {
		return auxMinicomputador;
	}

	public void setAuxMinicomputador(ArrayList<minicomputador> auxMinicomputador) {
		this.auxMinicomputador = auxMinicomputador;
	}

	public int getPanel() {
		return panel;
	}

	public void setPanel(int panel) {
		this.panel = panel;
	}


	
	
	
}
