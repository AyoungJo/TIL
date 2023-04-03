package kb.view;

import kb.dao.EmpDAO;
import kb.dto.EmpDTO;

public class Test {

	public static void main(String[] args) {
		// 1. 전체 사원 검색
		System.out.println("************1. 전체 사원 검색 ************");
		EmpDAO sdao = new EmpDAO();
		sdao.selectAll();

		// 2. 사원 등록 하기
		System.out.println("************2. 사원 등록 하기 ************");

		EmpDAO idao = new EmpDAO();
		idao.insert(new EmpDTO(9999, "MINI", "TEACHER", 4000));
	}

}
