package clinica.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.HibernateException;


import clinica.ConnectionFactory;
import clinica.Model.Entidade;

public class DaoGenerica<T extends Entidade> {

	private static EntityManager manager = ConnectionFactory.getEntityManager();

	public T findById(Class<T> clazz, Long id) {
		return manager.find(clazz, id);
	}

	public List<T> GetAll(Class<T> clazz) {
		List<T> objects = null;
		try {
			manager.getTransaction().begin();
			Query query = (Query) manager.createQuery("from " + clazz.getName());
			objects = query.getResultList();
		} catch (HibernateException e) {
			manager.getTransaction().rollback();
		} finally {
			manager.getTransaction().commit();
		}
		return objects;
	}

	public void saveOrUpdate(T obj) {
		try {
			manager.getTransaction().begin();
			if (obj.getId() == 0) {
				manager.persist(obj);
			} else {
				manager.merge(obj);
			}
			manager.getTransaction().commit();
		} catch (Exception e) {
			//manager.getTransaction().rollback();
		}
	}

	public void remove(Class<T> clazz, Long id) {
		T t = findById(clazz, id);
		try {
			manager.getTransaction().begin();
			manager.remove(t);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}
	}

}
