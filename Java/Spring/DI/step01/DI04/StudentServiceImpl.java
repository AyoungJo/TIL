package sample04;

public class StudentServiceImpl implements StudentService {
	private StudentDAO studentDAO;
	
	public StudentServiceImpl() {
		System.out.println("StudentServiceImpl 생성자 호출됨....");
	}
	
	//set을 이용한 객체 주입
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
		System.out.println("setStudentDAO(StudentDAO studentDAO) 호출됨... studentDAO = " + studentDAO);
	}

	@Override
	public void insert(Student student) {
       System.out.println("StudentServiceImpl의 insert 호출됨.....");
       studentDAO.insert(student);

	}

}
