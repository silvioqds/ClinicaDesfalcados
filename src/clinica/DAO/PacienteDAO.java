package clinica.DAO;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import clinica.ConnectionFactory;
import clinica.Model.Paciente;
import clinica.Model.Usuario;

public class PacienteDAO {

	private static EntityManager manager = ConnectionFactory.getEntityManager();
	
	public Paciente GetByCPF(String cpf){
		
		Paciente paciente = new Paciente();
		manager.getTransaction().begin();
		Query query = manager.createQuery("SELECT x FROM Paciente x WHERE x.CPF = :cpf)");
		query.setParameter("cpf", cpf);

		try {
			paciente = (Paciente) query.getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}
		manager.getTransaction().commit();
		return paciente;
		
	}
}
