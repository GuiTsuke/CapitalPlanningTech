package br.com.capitalplanningtech.model;

public class RelatorioFinanceiro {
	String conteudo;
	
	public RelatorioFinanceiro(Usuario usuario, Receita receita, Despesa despesa, Investimento investimento, PlanejamentoGastos planejamento){
		conteudo = "Usuario: " + usuario.nome + "\nReceita: " + receita.valor + "\nDespesa: "
				+ despesa.valor + "\nValor Investido: " + investimento.valor + "\nPlano de juntar: " + planejamento.valor;
	}
	
	public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
