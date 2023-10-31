package br.com.capitalplanningtech.model;

import java.time.LocalDate;

public class Despesa extends TransacaoFinanceira{

	public Despesa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Despesa(int codigo, String descricao, double valor, LocalDate data, String tipoReceita, int codigoUsuario) {
		super(codigo, descricao, valor, data, tipoReceita, codigoUsuario);
		// TODO Auto-generated constructor stub
	}

}
