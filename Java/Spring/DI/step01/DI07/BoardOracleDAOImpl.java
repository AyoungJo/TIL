package sample07;

import org.springframework.stereotype.Repository;

@Repository("oracleDAO")	//id="oracleDAO
public class BoardOracleDAOImpl implements BoardDAO {

	public BoardOracleDAOImpl() {
		System.out.println("BoardOracleDAOImpl() 생성자 호출");
	}
	@Override
	public void select() {
		System.out.println("BoardOracleDAOImpl()의 select()");

	}

}
