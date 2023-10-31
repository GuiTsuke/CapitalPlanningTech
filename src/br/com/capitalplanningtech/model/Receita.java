package br.com.capitalplanningtech.model;

import java.time.LocalDate;

public class Receita extends TransacaoFinanceira{
	
	public Receita() {
		
	}
	
	public Receita(int codigo, String descricao, double valor, LocalDate data, String tipoReceita, int codigoUsuario) {
		super(codigo, descricao, valor, data, tipoReceita, codigoUsuario);
		// TODO Auto-generated constructor stub
	}
	public Receita(String descricao, double valor, LocalDate data, String tipoReceita, int codigoUsuario) {
		super(descricao, valor, data, tipoReceita, codigoUsuario);
		// TODO Auto-generated constructor stub
	}


}

