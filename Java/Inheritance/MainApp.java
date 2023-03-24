package ex0324;

import java.util.ArrayList;
import java.util.List;

/**
 * 상속과 생성자 Main
 */
public class MainApp {

	public static void main(String[] args) {
		// 객체 생성
		//Person p = new Person("아영", 20);
		Person p;	//abstract 클래스는 생성불가, 타입 선언 가능 

		// print(Object obj) or println(Object obj) --> obj.toString() 호출
		// System.out.println("p = " + p);
		// 리턴 : getClass().getName() + '@' + Integer.toHexString(hashCode())
		// System.out.println("p.toString = " + p.toString());

		//System.out.println("-----------Person타입 객체-----------");		
		//p.eat();
		//p.walk();

		//SpiderMan sm = (SpiderMan)p;	//불가능. ClassCastException 
		//부모타입으로 생성한 필드를 자식 타입으로 다시 캐스팅 불가능
		//sm.eat();
		//sm.jump();
		
		System.out.println("-----------SpiderMan-----------");
		p = new SpiderMan("자식1", 20, true);	//가능, 다형성 성립
		System.out.println("p = " + p);		
		p.eat();	//부모 클래스에만 존재
		p.walk();	//부모+자식 클래스에 모두 존재 -> 오버라이딩(재정의)
		//재정의된 메소드는 부모타입일지라도 자식부분 호출 가능
		
		System.out.println("----------------------");
		//p변수로 자식부분의 메소드나 필드를 접근하고 싶으면 ObjectDownCasting 필요
		SpiderMan sm = (SpiderMan)p;
		System.out.println("p = " + p);
		System.out.println("sm = " + sm);
		
		sm.jump();
		sm.eat();
		System.out.println("----------------------");
		sm.walk();
		
	}
	
}
