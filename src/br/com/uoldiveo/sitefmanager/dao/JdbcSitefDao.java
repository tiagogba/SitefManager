package br.com.uoldiveo.sitefmanager.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

	public void remove(Lojas lojas) {

		if (lojas.getId() == null) {
			throw new IllegalStateException("Id da tarefa não deve ser nula.");
		}

		String sql = "delete from lojas where id = ?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setLong(1, lojas.getId());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void altera(Lojas lojas) {
		String sql = "update lojas set empresa = ?, loja = ?, razaosocial = ?, cnpj = ? where id = ?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, lojas.getEmpresa());
			stmt.setString(2, lojas.getLoja());
			stmt.setString(3, lojas.getRazaoSocial());
			stmt.setString(4, lojas.getCnpj());
			stmt.setLong(5, lojas.getId());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public Lojas buscaPorId(Long id) {

		if (id == null) {
			throw new IllegalStateException("Id da loja não deve ser nula.");
		}

		try {
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from lojas where id = ?");
			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return populaLojas(rs);
			}

			rs.close();
			stmt.close();

			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public List<Lojas> lista() {
		try {
			List<Lojas> lojas = new ArrayList<Lojas>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from lojas");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// adiciona a tarefa na lista
				lojas.add(populaLojas(rs));
			}
			rs.close();
			stmt.close();

			return lojas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	private Lojas populaLojas(ResultSet rs) throws SQLException {
		Lojas lojas = new Lojas();

		// popula o objeto tarefa
		lojas.setId(rs.getLong("id"));
		lojas.setEmpresa(rs.getString("empresa"));
		lojas.setLoja(rs.getString("loja"));
		lojas.setRazaoSocial(rs.getString("razaosocial"));
		lojas.setCnpj(rs.getString("cnpj"));
		return lojas;
	}
}
