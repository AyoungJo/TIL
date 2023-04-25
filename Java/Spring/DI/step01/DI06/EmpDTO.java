package sample06;

import org.springframework.beans.factory.annotation.Value;

public class EmpDTO {
	
	@Value("10")
	private int empno;
	
	@Value("아영")
	private String name;

	@Value("개발자")
	private String job;
	
	public EmpDTO() {
		System.out.println("EmpDTO 생성자 호출");
	}	
	
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	
	public int getEmpno() {
		return empno;
	}
	
	public String getName() {
		return name;
	}
	
	public String getJob() {
		return job;
	}

}
