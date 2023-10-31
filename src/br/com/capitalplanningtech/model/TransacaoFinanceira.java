package br.com.capitalplanningtech.model;

import java.time.LocalDate;

public class TransacaoFinanceira {
	int codigo;
	String descricao;
    double valor;
    LocalDate data;
    String tipoReceita;
    int codigoUsuario;
    

    public TransacaoFinanceira() {
	}

	public TransacaoFinanceira(int codigo, String descricao, double valor, LocalDate data, String tipoReceita,
			int codigoUsuario) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
		this.tipoReceita = tipoReceita;
		this.codigoUsuario = codigoUsuario;
	}
	public TransacaoFinanceira(String descricao, double valor, LocalDate data, String tipoReceita,
			int codigoUsuario) {
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
		this.tipoReceita = tipoReceita;
		this.codigoUsuario = codigoUsuario;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTipoReceita() {
		return tipoReceita;
	}

	public void setTipoReceita(String tipoReceita) {
		this.tipoReceita = tipoReceita;
	}

	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
