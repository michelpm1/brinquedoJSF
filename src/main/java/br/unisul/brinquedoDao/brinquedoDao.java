package br.unisul.brinquedoDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.unisul.automato.automato;
import br.unisul.brinquedo.brinquedo;
import br.unisul.eletronico.eletronico;
import br.unisul.factory.Factory;
import br.unisul.minicomputador.minicomputador;
import br.unisul.montagem.montagem;


public class brinquedoDao {

public void inserirBrinquedo(brinquedo brinquedo) {
		
		
		try{	
		new Factory();
		Connection con = Factory.getConexaoMySQL();
		if(brinquedo instanceof montagem){
			String sql = "insert into brinquedo" +
		            " (nome, idade, material, pecas)" +
		            " values (?,?,?,?)";
		    PreparedStatement stmt = con.prepareStatement(sql);
	       
		  stmt.setString(1, brinquedo.getNome());
		  stmt.setInt(2, brinquedo.getIdade());
		  stmt.setInt(3, brinquedo.getMaterial());
		   int aux = 0;
		  aux = ((montagem) brinquedo).getPecas();
		  stmt.setInt(4, aux);

			    // executa
		  	stmt.execute();
		    stmt.close();
		    con.close();
		}
	    // cria um preparedStatement
		else if (brinquedo instanceof automato){
	    String sql = "insert into brinquedo" +
	            " (nome, idade, material, energia)" +
	            " values (?,?,?,?)";
	    PreparedStatement stmt = con.prepareStatement(sql);
       
	  stmt.setString(1, brinquedo.getNome());
	  stmt.setInt(2, brinquedo.getIdade());
	  stmt.setInt(3, brinquedo.getMaterial());
	   int aux = 0;
	  aux = ((automato) brinquedo).getEnergia();
	  stmt.setInt(4, aux);

		    // executa
	  	stmt.execute();
	    stmt.close();
	    con.close();
				} else if(brinquedo instanceof minicomputador){
					String sql = "insert into brinquedo" +
				            " (nome, idade, material, funcoes)" +
				            " values (?,?,?,?)";
				    PreparedStatement stmt = con.prepareStatement(sql);
			       
				  stmt.setString(1, brinquedo.getNome());
				  stmt.setInt(2, brinquedo.getIdade());
				  stmt.setInt(3, brinquedo.getMaterial());
				   String aux = "";
				  aux = ((minicomputador) brinquedo).getFuncoes();
				  stmt.setString(4, aux);

					    // executa
				  	stmt.execute();
				    stmt.close();
				    con.close();
				} else{
					String sql = "insert into brinquedo" +
				            " (nome, idade, material, caract, pilha)" +
				            " values (?,?,?,?,?)";
				    PreparedStatement stmt = con.prepareStatement(sql);
			       
				  stmt.setString(1, brinquedo.getNome());
				  stmt.setInt(2, brinquedo.getIdade());
				  stmt.setInt(3, brinquedo.getMaterial());
				   String aux = "";
				   int aux1 = 0;
				  aux = ((eletronico) brinquedo).getCaracteristica();
				  stmt.setString(4, aux);
				  aux1 = ((eletronico) brinquedo).getPilhas();
				  stmt.setInt(5, aux1);
					    // executa
				  	stmt.execute();
				    stmt.close();
				    con.close();
				}
		}
		
		catch(SQLException e){
					
					System.out.println("Não foi possível Gravar os dados no banco contate o administrador");
				} 
		    
	
		}

public  brinquedo[] consultaNome(String nome) {
	
	automato aux1 = new automato();
	montagem aux2 = new montagem();
	eletronico aux3 = new eletronico();
	minicomputador aux4 = new minicomputador();
	ArrayList<brinquedo> brinquedoArray = new ArrayList<brinquedo>();
	brinquedo[] meuArray = new brinquedo[10];
	
	
	try{	new Factory();
	Connection con = Factory.getConexaoMySQL();

	String sql = "select nome, idade, material ,funcoes, energia, caract, pilha, pecas from brinquedo where nome = ?";

	java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
	preparedStatement.setString(1, nome);

	// execute select SQL stetement
	ResultSet rs = preparedStatement.executeQuery();
	
	while (rs.next()) {
		
		
		 aux1.setNome((rs.getString("nome")));
		 aux1.setIdade((rs.getInt("idade")));
		 aux1.setMaterial((rs.getInt("material")));
		 aux1.setEnergia((rs.getInt("energia")));
		 aux2.setPecas((rs.getInt("pecas")));
		 aux3.setCaracteristica((rs.getString("caract")));
		 aux3.setPilhas((rs.getInt("pilha")));
		 aux4.setFuncoes((rs.getString("funcoes")));
		 
		 meuArray[0] = aux1;
		 meuArray[1] = aux2;
		 meuArray[2] = aux3;
		 meuArray[3] = aux4;
		
	}
	con.close();
	} catch(SQLException e){
		System.out.println("Nome não encontrato tente novamente");
	 
	}


return meuArray;
} 

public ArrayList<brinquedo> consultarTipo(int tipo){
	ArrayList<brinquedo> List = new ArrayList<brinquedo>();
	
	try{	new Factory();
	Connection con = Factory.getConexaoMySQL();
	if (tipo ==1){
		
		
	String sql = "select nome, idade, material, pecas from brinquedo where pecas is not null";

	java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
	

	// execute select SQL stetement
	ResultSet rs = preparedStatement.executeQuery();
	
	while (rs.next()) {
		montagem aux = new montagem();
		
		 aux.setNome((rs.getString("nome")));
		 aux.setIdade((rs.getInt("idade")));
		 aux.setMaterial((rs.getInt("material")));
		 aux.setPecas((rs.getInt("pecas")));
		
		 
	   List.add(aux);
	
		}

			}
	else if(tipo==2){
		
		
		String sql = "select nome, idade, material, energia from brinquedo where energia is not null";

		java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
		

		// execute select SQL stetement
		ResultSet rs = preparedStatement.executeQuery();
		
		while (rs.next()) {
			automato aux = new automato();
			 aux.setNome((rs.getString("nome")));
			 aux.setIdade((rs.getInt("idade")));
			 aux.setMaterial((rs.getInt("material")));
			 aux.setEnergia((rs.getInt("energia")));
		
			 
			 List.add(aux);
			
			
		}
		
		} 
	
	
	else if(tipo ==3){
		
		

		String sql = "select nome, idade, material, caract, pilha from brinquedo where caract is not null";

		java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
		

		// execute select SQL stetement
		ResultSet rs = preparedStatement.executeQuery();
		
		while (rs.next()) {
			eletronico aux = new eletronico();
			
			 aux.setNome((rs.getString("nome")));
			 aux.setIdade((rs.getInt("idade")));
			 aux.setMaterial((rs.getInt("material")));
			 aux.setCaracteristica((rs.getString("caract")));
			 aux.setPilhas((rs.getInt("pilha")));
		
			 
			 List.add(aux);
			
			
		}
	
			
	} else{
		
		

		String sql = "select nome, idade, material ,funcoes from brinquedo where funcoes is not null";

		java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
		

		// execute select SQL stetement
		ResultSet rs = preparedStatement.executeQuery();
		
		while (rs.next()) {
			minicomputador aux = new minicomputador();
			
			 aux.setNome((rs.getString("nome")));
			 aux.setIdade((rs.getInt("idade")));
			 aux.setMaterial((rs.getInt("material")));
			 aux.setFuncoes((rs.getString("funcoes")));
			 
			 List.add(aux);
			
		}
		return List;
		} 
	
	
	
	con.close();
	} catch(SQLException e){
		System.out.println("Nome não encontrato tente novamente");
	 
	}
	return List;
	

	
}

}
