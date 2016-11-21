package br.com.managedbeans;

import java.io.Serializable;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	public String login(){
		
		Usuario u = usuadioDAO.loginUsuario(this.usuario.getEmail(), this.usuario.getSenha());
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = request.getSession(true);
		
		if(u != null) {
			session.setAttribute("usuario", u);
			return "/app/index.xhtml?faces-redirect=true";
		}

		session.setAttribute("erroLoginMessagem", "Não foi possivel Realizar o Login!");
		return "/login.xhtml?faces-redirect=true";
		
	}
	
	public String logout(){
		
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		request.getSession().invalidate();
		
		return "/index.xhtml?faces-redirect=true";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
