package br.com.capitalplanningtech.model;

import java.time.LocalDate;

public class Investimento extends TransacaoFinanceira {
    double taxaJuros;
    LocalDate dataTermino;

    
    
    public Investimento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Investimento(int codigo, String descricao, double valor, LocalDate data, String tipoReceita, int codigoUsuario, double taxaJuros, LocalDate dataTermino) {
		super(codigo, descricao, valor, data, tipoReceita, codigoUsuario);
        this.taxaJuros = taxaJuros;
        this.dataTermino = dataTermino;
		// TODO Auto-generated constructor stub
	}
    
    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }
}
