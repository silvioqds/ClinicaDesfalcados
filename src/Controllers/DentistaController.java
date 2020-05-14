package Controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import clinica.Model.Dentista;

public class DentistaController {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public DentistaController(){
		emf = Persistence.createEntityManagerFactory("clinica");
		em = emf.createEntityManager();
	}
	
	public void salvar(Dentista dentista){
		em.getTransaction().begin();
		em.merge(dentista);
		em.getTransaction().commit();
		emf.close();
		
		
	}
	
}
