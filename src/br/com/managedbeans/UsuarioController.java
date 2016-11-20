package br.com.managedbeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import br.com.beans.Usuario;
import br.com.sessionsbeans.UsuarioIT;

@ManagedBean
@SessionScoped
public class UsuarioController implements Serializable{

	private Usuario usuario;
	
	@EJB
	private UsuarioIT usuadioDAO;
	
	public UsuarioController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init(){
		this.usuario = new Usuario();
	}

	public void addUsuario(){
		usuadioDAO.addUsuario(usuario);
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
