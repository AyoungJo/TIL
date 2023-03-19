package Student;

public class StudentService {
	
	Student [] stArr = new Student[5];
	
	/**
	 * 학생 5명 초기화(생성)
	 */
	public StudentService() {
		System.out.println("StudentService 기본생성자 호출됨");
//		System.out.println("stArr = " + stArr);
		
		/*
		 * for(Student st : stArr) { 
		 * 	System.out.println(st); 
		 * }*/
		 
		stArr[0] = new Student();
		stArr[1] = new Student("진영",26,"청주");
		stArr[2] = new Student("신우",23,"충주");
		stArr[3] = new Student("산들",25,"부산");
		stArr[4] = new Student("바로",24,"광주");
		
		 for(Student st : stArr) { 
			System.out.println(st); 
		 }
		
	}

	/**
	 * 전체 학생 조회
	 * 리턴타입이 전체 학생에 대한 정보 이기 때문에 Student[]배열이 return 타입 
	 */
	public Student[] selectAll() {
		//전체 조회
		
		return stArr;
	}
	
	/**
	 * name에 해당하는 학생 정보 조회
	 */
	public static void main(String[] args) {
		StudentService service = new StudentService(); //생성자 호출
		
		//전체 학생 조회
		System.out.println("1. 전체 학생 조회-----------------");
		Student[] arr = service.selectAll();
		System.out.println("arr = " + arr);
		
		System.out.println("1. 학생의 정보 ("+arr.length+"명-----------------");
		for(Student st : arr) {
			System.out.print("이름 : " + st.name + "\t");
			System.out.print("나이 : " + st.age + "\t");
			System.out.print("주소 : " + st.addr + "\t");
			System.out.println();
		}
		
	}
}
