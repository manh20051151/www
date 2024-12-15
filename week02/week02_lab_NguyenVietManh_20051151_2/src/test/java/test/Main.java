package test;

import jakarta.persistence.*;

public class Main {
	@PersistenceContext(unitName = "my_pu")
	private static EntityManager entityManager;

    public static void main(String[] args) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-mariadb");
//		EntityManager em = emf.createEntityManager();
//
		EntityTransaction tx = entityManager.getTransaction();

		tx.begin();
		tx.commit();


    }
}
