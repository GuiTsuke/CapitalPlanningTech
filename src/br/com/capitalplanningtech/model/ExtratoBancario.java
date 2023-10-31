package br.com.capitalplanningtech.model;

import java.util.Date;

public class ExtratoBancario {
	Date dataTransacao;
	String descricao;
	double valorTransacao;

	public ExtratoBancario() {

	}

	public ExtratoBancario(Date dataTransacao, String descricao, double valorTransacao) {
		this.dataTransacao = dataTransacao;
		this.descricao = descricao;
		this.valorTransacao = valorTransacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valorTransacao;
	}

	public void setValor(double valorTransacao) {
		this.valorTransacao = valorTransacao;
	}

	public Date getDataTransacao() {
		return dataTransacao;
	}

	public void setDataTransacao(Date dataTransacao) {
		this.dataTransacao = dataTransacao;
	}
}
