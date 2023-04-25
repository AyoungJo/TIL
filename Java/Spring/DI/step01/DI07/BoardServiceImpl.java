package sample07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service	//id="boardServiceImpl"
public class BoardServiceImpl implements BoardService {
	@Autowired	//byType 주입 --> byName(id=property명)
	@Qualifier("oracleDAO")
	private BoardDAO boardOracleDao;	//의존성 주입 -> bean id="oracleDAO"
	
	@Autowired
	private BoardDAO boardMyBatisDAOImpl;	//의존성 주입

	public BoardServiceImpl() {
		System.out.println("BoardServiceImpl() 생성자 호출");
	}
	
	@Override
	public void select() {
		System.out.println("BoardServiceImpl()의 select()");
	}

}
