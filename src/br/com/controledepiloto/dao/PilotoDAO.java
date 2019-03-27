package br.com.controledepiloto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.controledepiloto.domain.Piloto;
import br.com.controledepiloto.factory.ConexaoFactory;


public class PilotoDAO {

	
	public void salvar(Piloto a) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("CALL SALVAR_PILOTO(?,?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		
		comando.setString(1, a.getNomeDoPiloto());
		comando.setString(2, a.getModeloDoCarro());
		
		
		
		try {
			comando.executeUpdate();
			System.out.println("Salvo com sucesso!!!");
		} catch (SQLException e) {
			System.out.println("Algo inesperado aconteceu...");
			e.printStackTrace();
		}
		
		
	}
	
	
	public void excluir(Piloto p) throws SQLException {
		StringBuilder meusql = new StringBuilder();
		
		meusql.append("CALL EXCLUIR_PILOTO(?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(meusql.toString());

		comando.setString(1, p.getNomeDoPiloto());

		comando.executeUpdate();
	}
	
	public void editar(Piloto p) throws SQLException {
		StringBuilder sql = new StringBuilder();
		Connection conexao = ConexaoFactory.conectar();
		sql.append("CALL EDITAR_MODELO(?,?)");

	

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, p.getNomeDoPiloto());
		comando.setString(2, p.getModeloDoCarro());

		comando.executeUpdate();
	}
	
    public void ConsultaAvancadaid(Piloto p) throws SQLException {
	         ResultSet resultado = null;
             StringBuilder meusql = new StringBuilder();
	
	
	         meusql.append ("CALL BUSCA_POR_ID(?)");
	
	         Connection conexao = ConexaoFactory.conectar();
		
        	 PreparedStatement comando = conexao.prepareCall(meusql.toString());
		
             comando.setLong(1, p.getIdPiloto());	
             resultado = comando.executeQuery();	
			
             try { 
	                  while  (resultado.next()) {	
	                       System.out.println(" ID Piloto : " + resultado.getInt("IdPiloto") + ", Nome do Piloto : " + resultado.getString("nomepiloto")
	                       +", Modelo do Carro do Piloto : " + resultado.getString("modelocarro"));
			
	                  } 
             } catch (SQLException e) {
	               System.out.println("Erro na Consulta Avançada Por ID !!");
	               e.printStackTrace();
	               
             }
    }
		
    public void ConsultaAvancadanome(Piloto p) throws SQLException {
        ResultSet resultado = null;
        StringBuilder meusql = new StringBuilder();         
    
		     meusql.append("CALL BUSCA_POR_NOME(?)");
		     
             Connection conexao = ConexaoFactory.conectar();
		     
             PreparedStatement comando = conexao.prepareStatement(meusql.toString());
		
		     comando.setString(1, p.getNomeDoPiloto());
		     resultado = comando.executeQuery();	
 					     
		     try {
                     while (resultado.next()) {
                    	 System.out.println(" ID Piloto : " + resultado.getInt("IdPiloto") + " , Nome do Piloto : " + resultado.getString("nomepiloto")
	                       +" , Modelo do Carro do Piloto : " + resultado.getString("modelocarro"));  
                   }
                     
		     } catch (SQLException e) {
		    	 System.out.println("Erro na Consulta Avançada Por Nome !!!");
		    	 e.printStackTrace();
                 
		     }
     }     	
	
   	public void listar() throws SQLException {
		ResultSet resultado = null;
		StringBuilder meusql = new StringBuilder();
		meusql.append ("CALL LISTAR_PILOTO(?,?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareCall(meusql.toString());

		resultado = comando.executeQuery();

		try {
			// code here
			while (resultado.next()) {
				System.out.println(" ID Piloto : " +  resultado.getLong("idpiloto") + ", Nome do Piloto : " + resultado.getString("nomepiloto")
						+ ",  Modelo do carro : " + resultado.getString("modelocarro"));
			}
		} catch (SQLException e) {
			System.out.println("Erro na consultar !!!");
			e.printStackTrace();
		}
		
	}
	
	
		
}
