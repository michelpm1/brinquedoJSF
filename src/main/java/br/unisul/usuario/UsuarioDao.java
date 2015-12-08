package br.unisul.usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.unisul.factory.Factory;




public class UsuarioDao {
	Usuario aux = new Usuario();
	
	public Usuario loginCheck(Usuario usuario) {
		
		
		
		Usuario B = new Usuario();
	try{	new Factory();
	Connection con = Factory.getConexaoMySQL();

	String sql = "select nome, senha from usuario where nome = ? and senha = ?";

	java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
	preparedStatement.setString(1, usuario.getUsername());
	preparedStatement.setString(2, usuario.getPassword());


	// execute select SQL stetement
	ResultSet rs = preparedStatement.executeQuery();	


	// executa o sql
	

	while (rs.next()) {
		
		     
		 aux.setUsername(rs.getString("nome"));
		 aux.setPassword(rs.getString("senha"));
	
		
		 
		 
		 
		
	
	}


con.close();
	} catch(SQLException e){
		System.out.println("CPF não encontrato tente novamente");
	 
	}


return aux;
	}
}
