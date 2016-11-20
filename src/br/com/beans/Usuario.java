package br.com.beans;

import javax.persistence.Entity;

@Entity
public class Usuario  extends Pessoa{

	private String nickname;
	
	public Usuario() {

	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
	
}
