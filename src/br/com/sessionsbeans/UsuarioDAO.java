package br.com.sessionsbeans;


import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.beans.Usuario;


@Stateless
@Local(UsuarioIT.class)
public class UsuarioDAO implements UsuarioIT {

	@PersistenceContext(unitName="jdbc/Usuario")
	private EntityManager em;
	
	@Override
	public void addUsuario(Usuario usuario) {
		
		em.persist(usuario);
		
	}

}
