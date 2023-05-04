package exam;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AssociationMainApp {

	public static void main(String[] args) {

		System.out.println("==================JPA 시작하기 (연관관계 TEST)==================");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
//		Team t1 = new Team(null, "team01");
//		Team t2 = new Team(null, "team02");
//		Team t3 = new Team(null, "team03");
//		
//		em.persist(t1);
//		em.persist(t2);
//		em.persist(t3);
//		
//		em.persist(Member.builder().name("아영").age(25).team(t1).build());
//		em.persist(Member.builder().name("예삐").age(24).team(t1).build());
//		em.persist(Member.builder().name("미니").age(23).team(t1).build());
//
//		em.persist(Member.builder().name("미남").age(21).team(t2).build());
//		em.persist(Member.builder().name("두부").age(22).team(t2).build());
//		em.persist(Member.builder().name("콩이").age(23).team(t2).build());
//
//		em.persist(Member.builder().name("재롱").age(20).team(t3).build());
//		em.persist(Member.builder().name("호두").age(21).team(t3).build());
//		em.persist(Member.builder().name("마루").age(22).team(t3).build());
			
		//회원검색
		/*Member m = em.find(Member.class, 1L);		
		System.out.println(m);
		System.out.println("================");
		Team team = m.getTeam();	//즉시로딩시 join 실행
		System.out.println(team);*/
		
		//팀에 소속된 회원 검색
		Team team = em.find(Team.class, 2L);
		System.out.println(team);
		System.out.println("===========");
		List<Member> list = team.getMemberList();
		System.out.println(list);
		
		tx.commit();		
		
	}

}
