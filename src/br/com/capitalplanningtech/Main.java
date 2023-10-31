package br.com.capitalplanningtech;

import java.time.LocalDate;
import java.util.List;

import br.com.capitalplanningtech.control.ReceitaDAO;
import br.com.capitalplanningtech.model.Receita;

public class Main {

	public static void main(String[] args) {
		ReceitaDAO sql = new ReceitaDAO();
		try {
			

		System.out.println("Cadastrando tudo automaticamente...");
		Receita rec1 = new Receita("Venda na amazon", 199.90, LocalDate.now(), "Venda", 25);
		Receita rec2 = new Receita("Transferencia da mamae", 100, LocalDate.now(), "Venda", 25);
		Receita rec3 = new Receita("Salario", 2000.98, LocalDate.now(), "Venda", 26);
		Receita rec4 = new Receita("Venda no Mercado livre ", 320.52, LocalDate.now(), "Venda", 26);
		Receita rec5 = new Receita("Aposta de LOL", 15.50, LocalDate.now(), "Venda", 25);

		sql.cadastrar(rec1);
		sql.cadastrar(rec2);
		sql.cadastrar(rec3);
		sql.cadastrar(rec4);
		sql.cadastrar(rec5);

		System.out.println("Cadastrados");

		List<Receita> lista = sql.listar();
		for(Receita item: lista) {
			System.out.println(item.getCodigo() + " || " + item.getDescricao() + " || " + item.getValor() + " || " + item.getData() + " || " + item.getTipoReceita() + " || " + item.getCodigoUsuario());
		}
		
		} catch (Exception e) {
			System.err.println("Encerrando...");
		}
	}

}

