package sample07;

import org.springframework.stereotype.Repository;

//xml에서 <bean class="BoardMyBatisDAOImpl" id="boardMyBatisDAOImpl">
@Repository	//기본 id는 클래스 이름의 첫글자만 소문자, 나머지는 동일 
public class BoardMyBatisDAOImpl implements BoardDAO {
	
	public BoardMyBatisDAOImpl() {
		System.out.println("BoardMyBatisDAOImpl() 생성자 호출");
	}

	@Override
	public void select() {
		System.out.println("BoardMyBatisDAOImpl()의 select()");

	}

}
