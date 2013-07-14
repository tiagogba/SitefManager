package br.com.uoldiveo.sitefmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.uoldiveo.sitefmanager.modelo.Lojas;

@Repository
public class JdbcSitefDao {
	public final Connection connection;

	@Autowired
	public JdbcSitefDao(DataSource dataSource) {
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void adiciona(Lojas lojas) {
		String sql = "insert into lojas (empresa,loja,razaosocial,cnpj) values (?,?,?,?)";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, lojas.getEmpresa());
			stmt.setString(2, lojas.getLoja());
			stmt.setString(3, lojas.getRazaoSocial());
			stmt.setString(4, lojas.getCnpj());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
