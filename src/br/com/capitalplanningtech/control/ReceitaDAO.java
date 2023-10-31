package br.com.capitalplanningtech.control;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.capitalplanningtech.model.Receita;

public class ReceitaDAO {
	private Connection conexao;
	
	public void cadastrar(Receita receita) {
		PreparedStatement stmt = null;

		try {
			conexao = CPTechManagerBD.obterConexao();

			String sqlInsert = "INSERT INTO T_RECEITA(CD_RECEITA, VL_RECEITA, DT_RECEITA, DS_RECEITA, CD_USUARIO, DS_TIPO_RECEITA) VALUES(SQ_RECEITA.NEXTVAL, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sqlInsert);
			stmt.setDouble(1, receita.getValor());
			Date data = Date.valueOf(receita.getData());
			stmt.setDate(2, data);
			stmt.setString(3, receita.getDescricao());
			stmt.setInt(4, receita.getCodigoUsuario());
			stmt.setString(5, receita.getTipoReceita());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
//				
//				e.printStackTrace();
			} catch (NullPointerException e) {
				System.err.println("Ocorreu um erro!");
			}
		}
	}

	public List<Receita> listar() {
		List<Receita> listUser = new ArrayList<Receita>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = CPTechManagerBD.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_RECEITA");
			rs = stmt.executeQuery();
			
			while(rs.next()){
				int codigo = rs.getInt("CD_RECEITA");
				double valor = rs.getDouble("VL_RECEITA");
				String descricao = rs.getString("DS_RECEITA");
				String tipoReceita = rs.getString("DS_TIPO_RECEITA");
				LocalDate data = rs.getDate("DT_RECEITA").toLocalDate();
				int cdUsuario = rs.getInt("CD_USUARIO");
				Receita receita = new Receita(codigo, descricao, valor, data, tipoReceita, cdUsuario);
				listUser.add(receita);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return listUser;
	}
}
