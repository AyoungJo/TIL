package ex0324;

/**
 * 상속과 생성자02
 */
public /*abstract*/ class SpiderMan extends Person {	//SpiderMan is a Person. 성립
	/**
	 * 	boolean
	 * 	boolean은 조건식에서 많이 사용 (조회) true or false?
	 * 	boolean 형의 get메서드를 Generate를 통해 생성시
	 * 	형태가 is필드명 으로 생성되기 때문에
	 * 	is 키워드는 생략하는 것이 좋다(상황마다 다르지만)
	 */
	private boolean spider;

	public SpiderMan() {
		// 자식생성자 구현부 첫줄, 생성 안했을 시 자동생성
		 super(); //부모 클래스에 기본생성자 생성 안했을 시 에러발생
	}

	public SpiderMan(String name, int age, boolean spider) {
		//하나의 생성자 안에서 생성자는 한번만 호출 가능
		//super();
		super(name, age);
		this.spider = spider;
		
		// 부모 클래스의 private 멤버필드는 set, get 메서드로 접근
		//this.setName(name);
		//super.setAge(age);
	}
	
	public boolean isSpider() {
		return spider;
	}

	public void setSpider(boolean spider) {
		this.spider = spider;
	}
	
	@Override
	public String toString() {
		//return name + " | " + age + " | " + spider;
		//return getName() + " | " + getAge() + " | " + spider;
		return super.toString() + " | " + spider;
	}
	
	//자식클래스만 갖는 메소드
	public void jump() {
		System.out.println("SpiderMan 클래스만 가지고 있는 jump() 호출");
	}
	
	@Override
	public void walk() {
		//부모쪽에 있는 walk() 호출하고 싶다.
		super.walk();
		System.out.println("SpiderMan의 walk() 호출 - 걷는거 싫다.");
	}
	
	@Override
	public void sleep() {
		System.out.println("Spiderman sleep 호출");
		
	}
	
}
