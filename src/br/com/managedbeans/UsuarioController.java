package br.com.managedbeans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.Calendar;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.primefaces.model.UploadedFile;

import br.com.beans.Endereco;
import br.com.beans.Usuario;
import br.com.sessionsbeans.UsuarioIT;

@ManagedBean
@SessionScoped
public class UsuarioController implements Serializable{

	private Usuario usuario;
	private UploadedFile file;
	
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
		
		if(u != null) {
			getSession().setAttribute("usuarioSession", u);
			getSession().removeAttribute("erroLoginMessagem");
			return "/app/index.xhtml?faces-redirect=true";
		}

		getSession().setAttribute("erroLoginMessagem", "Não foi possivel Realizar o Login!");
		return "/login.xhtml?faces-redirect=true";
		
	}
	
	public String logout(){
		getRequest().removeAttribute("usuarioSession");
		getRequest().getSession().invalidate();
		
		return "/index.xhtml?faces-redirect=true";
	}
	
	
	public void atualizar(Usuario u){
		
		if(file.getSize() > 0){
			System.out.println("Tem Upload!");
			String path = "imagens" + File.separator + "perfil" + File.separator;
			String nomeArquivo = upload(file, u.getId().toString(), path);
			u.setFoto(nomeArquivo);
			file = null;
		}
		
		Usuario usuario = usuadioDAO.atualizar(u);
		getSession().setAttribute("usuarioSession", usuario);
	}
	
	
	public String upload(UploadedFile arquivo, String nome, String path ){
		
		String localPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
		String formatoArquivo = arquivo.getFileName().substring(arquivo.getFileName().lastIndexOf("."), arquivo.getFileName().length());
		String nomeArquivo = nome + formatoArquivo; 
		String savePath = localPath + path + nomeArquivo;
		
		try {
			
			FileInputStream in = (FileInputStream) file.getInputstream();
			FileOutputStream out = new FileOutputStream(savePath);
			
			byte[] buffer = new byte [(int) file.getSize()];
			int contador = 0;
			while((contador = in.read(buffer)) != -1){
				out.write(buffer, 0, contador);
			}
			
			in.close();
			out.close();
			
			System.out.println("Upload OK!");
			return nomeArquivo;
			
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("ERROR: ");
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
	private HttpSession getSession(){
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = request.getSession(true);
		return session;
	}
	
	private HttpServletRequest getRequest(){
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		return request;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}


	
	
}
