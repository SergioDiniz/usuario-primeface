package br.com.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Usuario  extends Pessoa{

	private String nickname;
	
	@ManyToMany(mappedBy="usuario")
	private List<Topico> topicos;
	
	@ManyToMany(mappedBy="usuario")
	private List<Comentario> comentario;
	
	public Usuario() {

	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
	
}
