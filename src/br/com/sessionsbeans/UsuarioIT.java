package br.com.sessionsbeans;

import br.com.beans.Usuario;

public interface UsuarioIT {

	void addUsuario(Usuario usuario);
	
	Usuario loginUsuario(String email, String senha);
	
	Usuario atualizar(Usuario usuario);
	
}
