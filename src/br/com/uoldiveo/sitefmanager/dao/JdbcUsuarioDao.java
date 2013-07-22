package br.com.uoldiveo.sitefmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import br.com.uoldiveo.sitefmanager.cf.ConnectionFactory;
import br.com.uoldiveo.sitefmanager.modelo.Usuarios;

@Repository
public class JdbcUsuarioDao {
	public final Connection connection;

//Usando a CF
//	public JdbcUsuarioDao() {
//		try {
//			connection = new ConnectionFactory().getConnection();
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
	
	@Autowired
	public JdbcUsuarioDao(DataSource dataSource){
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
//	@Repository
//	public class JdbcSitefDao {
//		public final Connection connection;
//
//		@Autowired
//		public JdbcSitefDao(DataSource dataSource) {
//			try {
//				this.connection = dataSource.getConnection();
//			} catch (SQLException e) {
//				throw new RuntimeException(e);
//			}
//		}
	
	public boolean existeUsuario(Usuarios usuario) {
		
		if(usuario == null) {
			throw new IllegalArgumentException("Usuário não deve ser nulo");
		}
		
		try {
			PreparedStatement stmt = connection.prepareStatement("select * from login where login = ? and password = ?");
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getPassword());
			ResultSet rs = stmt.executeQuery();

			boolean encontrado = rs.next();
			rs.close();
			//stmt.close();

			return encontrado;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

