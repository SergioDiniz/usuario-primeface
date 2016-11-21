package br.com.managedbeans;

import java.io.Serializable;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import br.com.beans.Endereco;
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
		this.usuario.setEndereco(new Endereco());
	}

	public String addUsuario(){
		usuario.setDataNascimento(Calendar.getInstance());
		usuadioDAO.addUsuario(usuario);
		usuario = new Usuario();
		return "/index.xhtml?faces-redirect=true";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
