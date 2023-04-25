package sample06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class EmpController {
	@Autowired //byType에 의해 주입 -> byName을 주입
	@Qualifier("emp2") 	//@Autowired 사용 시 동일한 타입 객체가 여러개이고  id와 property명이 일치하는 것이 없을 때 설정이 필요
	private EmpDTO empDTO;	//주입하기 위해 생성자 또는 setter 생성)
	
	@Autowired //byType에 의해 주입 -> byName을 주입
	private EmpDTO emp;	//주입하기 위해 생성자 또는 setter 생성)
	
	@Autowired //byType에 의해 주입
	private EmpService service;
	
	public EmpController() {
		System.out.println("EmpController 생성자 호출");
	}
	
	public void test() {
		System.out.println("empDTO = " + empDTO + ", empno = " + empDTO.getEmpno());
		System.out.println("emp = " + emp + ", emp = " + emp.getEmpno());
		System.out.println("service = " + service);
	
		service.test();
	}
}
