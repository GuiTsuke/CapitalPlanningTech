package br.com.capitalplanningtech.control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.capitalplanningtech.model.Usuario;

public class UsuarioDAO {
	private Connection conexao;

	public void cadastrar(Usuario usuario) {
		PreparedStatement stmt = null;

		try {
			conexao = CPTechManagerBD.obterConexao();

			String sqlInsert = "INSERT INTO T_USUARIO(CD_USUARIO, NM_USUARIO, NM_SOBRENOME, DS_EMAIL, DS_SENHA, NM_ENDERECO, NR_TELEFONE, DT_CADASTRO) VALUES(SEQ_USUARIO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sqlInsert);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSobrenome());
			stmt.setString(3, usuario.getEmail());
			stmt.setString(4, usuario.getSenha());
			stmt.setString(5, usuario.getEndereco());
			stmt.setString(6, usuario.getTelefone());

			Date data = new Date(usuario.getDataCadastro().getTime());
			stmt.setDate(7, data);

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Usuario> listar() {
		List<Usuario> listUser = new ArrayList<Usuario>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = CPTechManagerBD.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_USUARIO");
			rs = stmt.executeQuery();
			
			while(rs.next()){
				int codigo = rs.getInt("CD_USUARIO");
				String nome = rs.getString("NM_USUARIO");
				String sobrenome = rs.getString("NM_SOBRENOME");
				String email = rs.getString("DS_EMAIL");
				String senha = rs.getString("DS_SENHA");
				String endereco = rs.getString("NM_ENDERECO");
				String telefone = rs.getString("NR_TELEFONE");
				Date data = rs.getDate("DT_CADASTRO");
				Usuario user = new Usuario(codigo, nome, sobrenome, email, senha, endereco, telefone, data);
				listUser.add(user);
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
