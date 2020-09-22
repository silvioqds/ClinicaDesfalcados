package clinica.DAO;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.List;
import clinica.ConnectionFactory;
import clinica.Model.Aniversariante;
import clinica.Model.Funcionario;

public class FuncionarioDAO {

	private static EntityManager manager = ConnectionFactory.getEntityManager();

	public List<Aniversariante> GetAniversariantes() {

		List<Aniversariante> aniversariantes = new ArrayList<Aniversariante>();
		manager.getTransaction().begin();
		Query query = manager.createQuery("SELECT x FROM Funcionario x WHERE MONTH(x.DT_NASCIMENTO) = MONTH(NOW())");
		List<Funcionario> resultList = query.getResultList();

		for (final Funcionario item : resultList) {
			Aniversariante aniversariante = new Aniversariante();

			aniversariante.setNome(item.getNOME());
			aniversariante.setDataNascimento(item.getDT_NASCIMENTO().toString());

			aniversariantes.add(aniversariante);
		}
		manager.getTransaction().commit();
		return aniversariantes;
	}

	public List<Funcionario> GetDoutores(long ID_ESPECIALIZACAO) {

		List<Funcionario> doutores = new ArrayList<Funcionario>();
		String q = "FROM Funcionario";
		manager.getTransaction().begin();

		Query query = manager.createQuery(q);
		doutores = query.getResultList();

		manager.getTransaction().commit();

		return doutores;
	}
}
