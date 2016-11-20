package br.com.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Usuario  extends Pessoa{

	private String nickname;
	
	@OneToMany(mappedBy="usuario")
	private List<Topico> topicos;
	
	@OneToMany(mappedBy="usuario")
	private List<Comentario> comentario;
	
	public Usuario() {

	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public List<Topico> getTopicos() {
		return topicos;
	}

	public void setTopicos(List<Topico> topicos) {
		this.topicos = topicos;
	}

	public List<Comentario> getComentario() {
		return comentario;
	}

	public void setComentario(List<Comentario> comentario) {
		this.comentario = comentario;
	}
	
	
	
}
