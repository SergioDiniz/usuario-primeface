package br.com.beans;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

	private String estado;
	private String cidade;
	private String rua;
	private String complemento;
	
	public Endereco() {
		// TODO Auto-generated constructor stub
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	
	
}
