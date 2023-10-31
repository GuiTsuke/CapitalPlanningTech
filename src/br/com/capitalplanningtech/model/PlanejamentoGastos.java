package br.com.capitalplanningtech.model;

import java.util.Date;

public class PlanejamentoGastos extends TransacaoFinanceira {
	Date dataTermino;

	
    public PlanejamentoGastos() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PlanejamentoGastos(int codigo, String descricao, double valor, Date data, String tipoReceita,
			int codigoUsuario, Date dataTermino) {
		super(codigo, descricao, valor, data, tipoReceita, codigoUsuario);
		this.dataTermino = dataTermino;
		// TODO Auto-generated constructor stub
	}
    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }
}
