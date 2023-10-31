package br.com.capitalplanningtech.model;

public class PerfilUsuario {
	String tipo;
	
	public PerfilUsuario() {
		
	}
	
	public void definirTipoPerfil(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
	
}
