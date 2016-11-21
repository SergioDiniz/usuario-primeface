package br.com.sessionsbeans;


import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	@Override
	public Usuario loginUsuario(String email, String senha) {
		
		Query query = em.createQuery("select u from Usuario u where u.email = :email and u.senha = :senha");
		query.setParameter("email", email);
		query.setParameter("senha", senha);
		List<Usuario> u = query.getResultList();
		
		if(u.size() > 0){
			return u.get(0);
		}
		
		return null;
	}

}
