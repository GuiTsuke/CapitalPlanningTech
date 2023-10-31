package br.com.capitalplanningtech.model;

import java.util.Date;

public class Usuario {
	int codigo;
	String nome;
	String email;
	String senha;
	String sobrenome;
	String endereco;
	String telefone;
	Date dataCadastro;
	ContaBancaria contasBancarias = new ContaBancaria();
	PerfilUsuario perfis = new PerfilUsuario();
	RelatorioFinanceiro relatorios;
	Receita receita;
	Despesa despesa;
	Investimento investimento;
	PlanejamentoGastos planejamento;
	
	
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Usuario() {		
	}
	public Usuario(int codigo, String nome, String email, String senha, String sobrenome, String endereco, String telefone, Date dataCadastro) {
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.sobrenome = sobrenome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.dataCadastro = dataCadastro;
	}
	
	
	public void cadastrarContaBancaria(ContaBancaria conta) {
		contasBancarias = conta;  
	}	
	
	public void cadastrarReceita(String descricao, double valor, Date data, String tipoReceita, int codigoUsuario) {
		receita = new Receita(descricao, valor, data, tipoReceita, codigoUsuario);
	}	
	
	public void cadastrarDespesa(int codigo, String descricao, double valor, Date data, String tipoReceita, int codigoUsuario) {
        despesa = new Despesa(codigo, descricao, valor, data, tipoReceita, codigoUsuario);
    }
	
	public void realizarInvestimento(int codigo, String descricao, double valor, Date data, String tipoReceita, int codigoUsuario, double taxaJuros, Date dataTermino) {
        investimento = new Investimento(codigo, descricao, valor, data, tipoReceita, codigoUsuario, taxaJuros, dataTermino);
    }	
	
	public void gerarPlanejamentoDeGastos(int codigo, String descricao, double valor, Date data, String tipoReceita,
			int codigoUsuario, Date dataTermino) {
        planejamento = new PlanejamentoGastos(codigo, descricao, valor, data, tipoReceita, codigoUsuario, dataTermino);
    }
	public RelatorioFinanceiro gerarRelatorio() {
		Usuario usuario = new Usuario();
		relatorios = new RelatorioFinanceiro(usuario, receita, despesa, investimento, planejamento);
		return relatorios;
	}
	public void criarPerfilUsuario(String perfil) {
		perfis.definirTipoPerfil(perfil);
	}	
	
	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
	
}



