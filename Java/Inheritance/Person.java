package ex0324;

/**
 * 상속과 생성자01
 */

/* abstract 클래스는 생성 불가, 상속만 가능 */
public abstract class Person implements Comparable<Person> {	//extends Object
	//은닉(외부에서 사용자 마음대로 조회, 변경을 못하게 하는 것)
	private String name; //null
	private int age;	//0
	
	// 기본생성자, 직접 생성하지 않아도 자동 생성됨
	public Person() {
	}

	// 그러나 인수가 존재하는 생성자 생성시 기본생성자 자동생성X
	public Person(String name) {
		this.name = name;
	}

	public Person(String name, int age) {
		// 필드 초기화
		//String 인수를 1개 받는 생성자 호출 ( 반드시 생성자 구현부 첫줄에서 호출)
		//즉, 하나의 생성자 안에서 생성자는 한번만 호출 가능
		this(name);	 
		this.age = age;
	}
	
	/*  setXxx() - 수정
	 * 제한자 -  public
	 * 리턴 타입 - void
	 * 메소드 이름 - set+필드명 첫글자 대문자()
	 * 인수 - 필수
	 */
	
	/*  getXxx() - 조회
	 * 제한자 -  public
	 * 리턴 타입 - 필수
	 * 메소드 이름 - get+필드명 첫글자 대문자()
	 * 인수 - X
	 */
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}	
	
	/**
	 * Overriding
	 * : 부모에 정의되어있는 메소드를 자식클래스에서 새롭게 재정의하는 것
	 * 규칙 - 제한자만 다를 수 있고, 접근 제한자는 부모제한자보다 크거나 같아야 함
	 * 접근 제한자 - public > protected > 생략(default) > private
	 * 리턴 타입, 메소드명, 인수 모두 동일 하지만, 기능은 다르게 작성
	 */
	
	@Override
	public String toString() {
		return name + " | " + age;
	}
	
	 public void eat() {
		 System.out.println("Person의 eat() 호출");
	 }
	 
	 public void walk() {
		 System.out.println("Person의 walk() 호출");
	 }
	 
	 //추상메소드 선언 - 선언문만 존재, 기능이 없다(body 존재 X)
	 //abstract 메소드를 가지고 있는 클래스는 반드시 abstract로 선언되어야 함
	 //객체를 상속받은 클래스에서 알아서 기능을 정의
	 //abstract 클래스를 하위클래스에서 오버라이딩함
	 public abstract void sleep();	 
	 
	 @Override
	public int compareTo(Person o) {
		
		 return age - o.getAge();	//자신의 나이와 인수로 전달된 나이 비교
	}
	 
}
