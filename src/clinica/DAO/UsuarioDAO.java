package clinica.DAO;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import clinica.ConnectionFactory;
import clinica.Model.Usuario;

public class UsuarioDAO extends DaoGenerica<Usuario> {

	private static EntityManager manager = ConnectionFactory.getEntityManager();

	public Usuario GetUsuario(String username) {

		Usuario usuario = new Usuario();
	
		Query query = manager.createQuery("SELECT x FROM Usuario x WHERE x.USERNAME = :username)");
		query.setParameter("username", username);

		try {
			usuario = (Usuario) query.getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}

		return usuario;

	}

}
