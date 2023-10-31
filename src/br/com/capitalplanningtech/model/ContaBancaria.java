package br.com.capitalplanningtech.model;

import java.util.Date;

public class ContaBancaria {
	String numeroConta;
	String nomeBanco;
	
	public ContaBancaria() {
		
	}
	
	public ContaBancaria(String numeroConta, String nomeBanco) {
		this.numeroConta = numeroConta;
		this.nomeBanco = nomeBanco;
	}
	
	public ExtratoBancario consultarExtrato() {
		Date data = new Date();
		ExtratoBancario conteudo = new ExtratoBancario(data, "Compra na amazon", 10.15);
		return conteudo;
	}
	
	public double consultarSaldo() {
		double saldo = 1000.15;
		return saldo;
	}
	
	public String getNomeBanco() {
	    return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
	    this.nomeBanco = nomeBanco;
	}
	
	public String getNumeroConta() {
	    return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
	    this.numeroConta = numeroConta;
	}
}


/*
 * Consulta em API de banco para retornar o saldo do banco e gerar um extrato
 * Hardcode para simular os retornos
 */