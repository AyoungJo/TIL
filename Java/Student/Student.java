pacakge Student;

/**
 * 학생의 정보를 저장하는 객체  = VO, DTO, Domain
 */
public class Student {
		String name; 
		int age;
		String addr;
		
    //생성자
		public Student() {}
		public Student(String name, int age, String addr) {
			this.name = name;
			this.age = age;
			this.addr = addr;
		}

}
