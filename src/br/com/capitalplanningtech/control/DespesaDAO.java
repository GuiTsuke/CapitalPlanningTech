package br.com.capitalplanningtech.control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.capitalplanningtech.model.Despesa;

public class DespesaDAO {
	private Connection conexao;
	
	public void cadastrar(Despesa despesa) {
		PreparedStatement stmt = null;

		try {
			conexao = CPTechManagerBD.obterConexao();

			String sqlInsert = "INSERT INTO T_RECEITA(CD_DESPESA, VL_DESPESA, DT_DESPESA, DS_DESPESA, CD_USUARIO, DS_TIPO_DESPESA) VALUES(SQ_DESPESA.NEXTVAL, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sqlInsert);
			stmt.setDouble(1, despesa.getValor());
			Date data = new Date(despesa.getData().getTime());
			stmt.setDate(2, data);
			stmt.setString(3, despesa.getDescricao());
			stmt.setInt(4, despesa.getCodigoUsuario());
			stmt.setString(5, despesa.getTipoReceita());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				System.err.println("Ocorreu um erro!");
				e.printStackTrace();
			} catch (NullPointerException e) {
				System.err.println("Ocorreu um erro!");
			}
		}
	}

	public List<Despesa> listar() {
		List<Despesa> listUser = new ArrayList<Despesa>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = CPTechManagerBD.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_DESPESA");
			rs = stmt.executeQuery();
			
			while(rs.next()){
				int codigo = rs.getInt("CD_DESPESA");
				double valor = rs.getDouble("VL_DESPESA");
				String descricao = rs.getString("DS_DESPESA");
				String tipoReceita = rs.getString("DS_TIPO_DESPESA");
				Date data = rs.getDate("DT_DESPESA");
				int cdUsuario = rs.getInt("CD_USUARIO");
				Despesa despesa = new Despesa(codigo, descricao, valor, data, tipoReceita, cdUsuario);
				listUser.add(despesa);
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
