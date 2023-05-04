package exam;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainApp {

	public static void main(String[] args) {

		System.out.println("==================JPA 시작하기==================");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");

		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin(); // transaction 시작

		// 등록
		// em.persist(Customer.builder().age(26).userName("아영").birthDay(new
		// Date()).build());
		// em.persist(Customer.builder().age(26).userName("태균").birthDay(new
		// Date()).build());
		// em.persist(Customer.builder().age(10).userName("시윤").birthDay(new
		// Date()).build());
		// em.persist(Customer.builder().age(28).userName("예린").birthDay(new
		// Date()).build());
		// em.persist(Customer.builder().age(28).userName("경원").birthDay(new
		// Date()).build());
		// em.persist(Customer.builder().age(28).userName("성환").birthDay(new
		// Date()).build());
		em.persist(Customer.builder().age(20).userName("죠르디").birthDay(new Date()).build());

		// 조회
		// Customer cu = em.find(Customer.class, 7L);
		// System.out.println(cu);

		// 변경
		// cu.setUserName("예삐");
		// cu.setAge(12);

		// 삭제
		// em.remove(cu);

		////////////////////////////////////////////////////////
		// JPQL 문법 : 객체 중심으로 쿼리를 작성하는 것
		
		/*
		 * String sql = "select c from Customer c where c.age <= 25"; List<Customer>
		 * list = em.createQuery(sql, Customer.class).getResultList();
		 * System.out.println(list);
		 */

		/*
		 * String sql = "select c from Customer c where c.userName like :name";
		 * List<Customer> list = em.createQuery(sql, Customer.class)
		 * .setParameter("name", "%예%").getResultList();
		 */
		
		String sql = "select c from Customer c where c.userName like ?1 and c.age < ?2";
		List<Customer> list = em.createQuery(sql, Customer.class)
									.setParameter(1, "%예%").setParameter(2, 25).getResultList();
		
		System.out.println(list);

		et.commit(); // transaction 종료

	}

}
